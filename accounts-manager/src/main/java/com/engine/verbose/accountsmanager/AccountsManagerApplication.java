package com.engine.verbose.accountsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsManagerApplication.class, args);
    }

}
