package com.example.springboot.service;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.model.ProjectRegistry;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

@Service
public class ProjectRegistryService {

    private final ProjectRegistry contract;

    public ProjectRegistryService(
            Web3j web3j,
            Credentials credentials
    ) {
        this.contract = ProjectRegistry.load(
                "0xe7f1725E7734CE288F8367e1Bb143E90bb3F0512",
                web3j,
                credentials,
                new DefaultGasProvider()
        );
    }

    public BigInteger createProject(String title, String ipfsHash) throws Exception {
        TransactionReceipt receipt =
                contract.createProject(title, ipfsHash).send();

        return contract.nextId().send().subtract(BigInteger.ONE);
    }

    public Tuple8<
                BigInteger, String, String, String,
                BigInteger, Boolean, BigInteger, BigInteger
                > getProject(BigInteger id) throws Exception {
        return contract.getProject(id).send();
    }
}