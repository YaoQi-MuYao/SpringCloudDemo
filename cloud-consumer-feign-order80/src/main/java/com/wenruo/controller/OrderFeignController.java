package com.wenruo.controller;

import com.wenruo.entity.CommonResult;
import com.wenruo.entity.Payment;
import com.wenruo.service.PaymentFeignService;
import com.wenruo.service.PaymentHysTrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/12 21:25
 * @version: 1.0.0
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @Resource
    private PaymentHysTrixService paymentHysTrixService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feignTimeOut")
    public String feignTimeOut() {
        return paymentFeignService.feignTimeOut();
    }

    @GetMapping(value = "/consumer/payment/paymentInfoOK/{id}")
    public String paymentInfoOK(@PathVariable Integer id) {
        return paymentHysTrixService.paymentInfoOK(id);
    }

    @GetMapping(value = "/consumer/payment/paymentInfoTimeOut/{id}")
    String paymentInfoTimeOut(@PathVariable Integer id) {
        return paymentHysTrixService.paymentInfoTimeOut(id);
    }
}
