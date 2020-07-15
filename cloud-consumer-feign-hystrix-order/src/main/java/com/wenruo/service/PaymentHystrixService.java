package com.wenruo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/13 14:34
 * @version: 1.0.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {

    /**
     * 请求ok
     * @param id 随意
     * @return 返回信息
     */
    @GetMapping(value = "/payment/paymentInfoOK/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id);

    /**
     * 请求错误
     * @param id 随意
     * @return 返回信息
     */
    @GetMapping(value = "/payment/paymentInfoTimeOut/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);

}
