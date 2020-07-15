package com.wenruo.service.impl;

import com.wenruo.entity.Payment;
import com.wenruo.mapper.PaymentMapper;
import com.wenruo.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/6/25 22:33
 * @version: 1.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    /**
     * @param: [payment]
     * @return: int
     * @author: MuYao.Zhang
     * @date: 2020/7/6 0:19
     **/
    @Override
    public int add(Payment payment) {
        return paymentMapper.add(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentMapper.getPaymentById(id);
    }
}
