package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author MTR-007
 */
@MapperScan("com.example")
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages="com.example")
public class AccountBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountBookApplication.class, args);
    }

}
