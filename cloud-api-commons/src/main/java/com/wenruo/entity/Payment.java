package com.wenruo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 订单
 * @author: MuYao
 * @date: Created in 2020/6/25 22:06
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 单号
     */
    private String serial;
}
