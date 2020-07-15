package com.wenruo.mapper;

import com.wenruo.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/6/25 22:15
 * @version: 1.0.0
 */
@Mapper
public interface PaymentMapper {

    Integer add(Payment payment);

    Payment getPaymentById(@Param("id") Integer id);

}
