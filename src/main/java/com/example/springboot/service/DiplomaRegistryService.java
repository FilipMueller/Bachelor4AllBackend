package com.example.springboot.service;

import com.example.springboot.repository.User;
import com.example.springboot.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final Path storageDirectory;

    public DiplomaRegistryService(
            Web3j web3j,
            Credentials credentials,
            @Value("${chain.contract-address}") String contractAddress,
            DiplomaRepository diplomaRepository,
            @Value("${diploma.storage-directory}") String storageDirectory,
            UserRepository userRepository
    ) {
        this.contract = DiplomaRegistry.load(contractAddress, web3j, credentials, new DefaultGasProvider());
        this.diplomaRepository = diplomaRepository;
        this.storageDirectory = Paths.get(storageDirectory);
        this.userRepository = userRepository;
    }

    public BigInteger issueDiploma(String student, String institution, String title, String publicationYear, MultipartFile pdf) throws Exception {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(pdf.getBytes());

        TransactionReceipt receipt = contract.issueDiploma(student, hash, institution).send();
        List<DiplomaRegistry.DiplomaIssuedEventResponse> events = contract.getDiplomaIssuedEvents(receipt);

        BigInteger onChainId = events.getFirst().id;

        Files.createDirectories(storageDirectory);

        String fileName = onChainId + ".pdf";
        Path target = storageDirectory.resolve(fileName).normalize();

        if (!target.startsWith(storageDirectory.normalize())) {
            throw new SecurityException("Invalid target path: " + target);
        }

        try (InputStream in = pdf.getInputStream()) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }

        String pdfPath = "/diplomas/" + fileName;

        Diploma diploma = new Diploma(
                onChainId.longValue(),
                receipt.getTransactionHash(),
                student,
                institution,
                title,
                publicationYear,
                false,
                pdfPath
        );

        diplomaRepository.save(diploma);

        return onChainId;
    }

    public boolean verifyDiplomaForStudent(String email, MultipartFile pdf) throws Exception {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] computedHash = digest.digest(pdf.getBytes());

        List<Diploma> diplomas = diplomaRepository.findAllByStudentAddress(user.getWalletAddress());

        for (Diploma diploma : diplomas) {

            BigInteger id = BigInteger.valueOf(diploma.getOnChainId());

            boolean isValid = contract.verifyDiploma(id, computedHash).send();

            if (isValid) {
                return true;
            }
        }

        return false;
    }

    public void revokeDiploma(Long onChainId) throws Exception {

        BigInteger id = BigInteger.valueOf(onChainId);

        TransactionReceipt receipt = contract.revokeDiploma(id).send();

        List<DiplomaRegistry.DiplomaRevokedEventResponse> events =
                contract.getDiplomaRevokedEvents(receipt);

        if (events.isEmpty()) {
            throw new RuntimeException("Revocation failed");
        }

        Diploma diploma = diplomaRepository
                .findByOnChainId(onChainId)
                .orElseThrow(() -> new RuntimeException("Diploma not found"));

        diploma.setRevoked(true);
        diplomaRepository.save(diploma);
    }
}
