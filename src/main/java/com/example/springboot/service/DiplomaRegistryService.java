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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

@Service
public class DiplomaRegistryService {

    private final DiplomaRegistry contract;
    private final DiplomaRepository diplomaRepository;

    public DiplomaRegistryService(
            Web3j web3j,
            Credentials credentials,
            @Value("${chain.contract-address}") String contractAddress,
            DiplomaRepository diplomaRepository
    ) {
        this.contract = DiplomaRegistry.load(
                contractAddress,
                web3j,
                credentials,
                new DefaultGasProvider()
        );
        this.diplomaRepository = diplomaRepository;
    }

    public BigInteger issueDiploma(
            String student,
            String institution,
            MultipartFile pdf
    ) throws Exception {

        // 1️⃣ Hash PDF
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(pdf.getBytes());

        // 2️⃣ Issue on-chain
        TransactionReceipt receipt =
                contract.issueDiploma(student, hash, institution).send();

        List<DiplomaRegistry.DiplomaIssuedEventResponse> events =
                contract.getDiplomaIssuedEvents(receipt);

        BigInteger onChainId = events.getFirst().id;

        var d = contract.diplomas(onChainId).send();

        System.out.println("ID: " + d.component1());
        System.out.println("Student: " + d.component2());
        System.out.println("Hash: " + d.component3());
        System.out.println("IssuedAt: " + d.component4());
        System.out.println("Institution: " + d.component5());
        // 3️⃣ Store PDF (example path)
        String pdfPath = "/files/diplomas/" + onChainId + ".pdf";

        // 4️⃣ Persist metadata
        Diploma diploma = new Diploma(
                onChainId.longValue(),
                receipt.getTransactionHash(),
                student,
                institution,
                pdfPath
        );

        diplomaRepository.save(diploma);

        return onChainId;
    }

}