package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import com.example.springboot.repository.Diploma;
import com.example.springboot.repository.DiplomaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.web3j.crypto.Credentials;
import org.web3j.model.DiplomaRegistry;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.List;

@Service
public class DiplomaRegistryService {

    private final DiplomaRegistry contract;
    private final DiplomaRepository diplomaRepository;
    private final Path storageDirectory;

    public DiplomaRegistryService(
            Web3j web3j,
            Credentials credentials,
            @Value("${chain.contract-address}") String contractAddress,
            DiplomaRepository diplomaRepository,
            @Value("${diploma.storage-directory}") String storageDirectory
    ) {
        this.contract = DiplomaRegistry.load(contractAddress, web3j, credentials, new DefaultGasProvider());
        this.diplomaRepository = diplomaRepository;
        this.storageDirectory = Paths.get(storageDirectory);
    }

    public BigInteger issueDiploma(String student, String institution, String title, String publicationYear, MultipartFile pdf) throws Exception {

        // 1) Hash PDF
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(pdf.getBytes());

        // 2) Issue on-chain
        TransactionReceipt receipt = contract.issueDiploma(student, hash, institution).send();
        List<DiplomaRegistry.DiplomaIssuedEventResponse> events = contract.getDiplomaIssuedEvents(receipt);

        BigInteger onChainId = events.getFirst().id;

        // 3) Save PDF to disk using onChainId as filename
        Files.createDirectories(storageDirectory);

        String fileName = onChainId + ".pdf";
        Path target = storageDirectory.resolve(fileName).normalize();

        // security guard: ensure path stays inside storageDir
        if (!target.startsWith(storageDirectory.normalize())) {
            throw new SecurityException("Invalid target path: " + target);
        }

        // overwrite if exists (prototype behavior)
        try (InputStream in = pdf.getInputStream()) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }

        String pdfPath = target.toString();

        // 4) Persist metadata
        Diploma diploma = new Diploma(
                onChainId.longValue(),
                receipt.getTransactionHash(),
                student,
                institution,
                title,
                publicationYear,
                pdfPath
        );

        diplomaRepository.save(diploma);

        return onChainId;
    }

    public boolean verifyDiploma(BigInteger onChainId, MultipartFile pdf) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] computedHash = digest.digest(pdf.getBytes());

        return contract.verifyDiploma(onChainId, computedHash).send();
    }
}
