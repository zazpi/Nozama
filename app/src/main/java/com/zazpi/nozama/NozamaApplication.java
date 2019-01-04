package com.zazpi.nozama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zazpi.nozama.dao")
@EnableTransactionManagement
@EntityScan(basePackages="com.zazpi.nozama")
public class NozamaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(NozamaApplication.class, args);
       
    }

}