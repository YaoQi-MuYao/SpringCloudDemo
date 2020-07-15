package com.wenruo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/6/25 22:36
 * @version: 1.0.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZK() {
        return "Spring Cloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }



}
