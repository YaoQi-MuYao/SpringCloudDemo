package com.wenruo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wenruo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/13 11:44
 * @version: 1.0.0\
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/paymentInfoOK/{id}")
    public String paymentInfoOK(@PathVariable Integer id) {
        String result = paymentService.paymentInfoOK(id);
        log.info("------------------------------>" + result);
        return result;
    }

    @GetMapping(value = "/payment/paymentInfoTimeOut/{id}")
    public String paymentInfoTimeOut(@PathVariable Integer id) {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("------------------------------>" + result);
        return result;
    }

    /**
     * 熔断服务
     * @param: [id]
     * @return: java.lang.String
     * @author: MuYao.Zhang
     * @date: 2020/7/16 10:06
     **/
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("=============>result = " + result);
        return result;
    }


}
