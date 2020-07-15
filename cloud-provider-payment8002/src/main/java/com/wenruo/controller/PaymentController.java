package com.wenruo.controller;

import com.wenruo.entity.CommonResult;
import com.wenruo.entity.Payment;
import com.wenruo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/6/25 22:36
 * @version: 1.0.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/add")
    public CommonResult<Payment> add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("******插入结果" + result);
        if (result > 0) {
            return new CommonResult<>(200,"插入成功,serverPort: " + serverPort, payment);
        }
        return new CommonResult<>(500,"插入失败,serverPort: " + serverPort, null);
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Integer id){
        try {
            Payment payment = paymentService.getPaymentById(id);
            log.info("查询成功-------->" + payment);
            return new CommonResult<>(200,"查询成功,serverPort: " + serverPort, payment);
        } catch (Exception e){
            e.printStackTrace();
            return new CommonResult<>(500, "查询失败,serverPort: " + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }


}
