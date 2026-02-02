package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;

import java.math.BigInteger;

@RestController
@RequestMapping("/debug")
public class Web3DebugController {

    private final Web3j web3j;

    public Web3DebugController(Web3j web3j) {
        this.web3j = web3j;
    }

    @GetMapping("/block-number")
    public BigInteger blockNumber() throws Exception {
        return web3j.ethBlockNumber().send().getBlockNumber();
    }
}