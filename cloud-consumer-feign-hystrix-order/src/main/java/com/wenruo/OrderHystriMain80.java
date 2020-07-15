package com.wenruo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/13 14:33
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrderHystriMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystriMain80.class, args);
    }
}
