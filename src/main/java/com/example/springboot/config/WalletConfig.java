package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;

@Configuration
public class WalletConfig {

    @Value("${chain.admin-private-key}")
    private String privateKEY;

    @Bean
    public Credentials credentials() {
        return Credentials.create(
                privateKEY
        );
    }
}
