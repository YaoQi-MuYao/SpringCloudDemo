package com.wenruo.service;

import com.wenruo.entity.Payment;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/6/25 22:30
 * @version: 1.0.0
 */
public interface PaymentService {

    int add(Payment payment);

    Payment getPaymentById(Integer id);
}
