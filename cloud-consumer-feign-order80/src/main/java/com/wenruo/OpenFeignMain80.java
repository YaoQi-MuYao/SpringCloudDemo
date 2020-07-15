package com.wenruo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: 配置feign的客户端
 * @author: MuYao
 * @date: Created in 2020/7/12 21:13
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class, args);
    }
}
