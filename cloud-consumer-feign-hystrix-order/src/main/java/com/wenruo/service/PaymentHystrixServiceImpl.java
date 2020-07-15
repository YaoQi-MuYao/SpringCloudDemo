package com.wenruo.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/13 16:40
 * @version: 1.0.0
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "-------------->paymentInfoOK /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-------------->paymentInfoTimeOut /(ㄒoㄒ)/~~";
    }
}
