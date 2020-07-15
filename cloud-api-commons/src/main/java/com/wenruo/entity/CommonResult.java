package com.wenruo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 通用实体
 * @author: MuYao
 * @date: Created in 2020/6/25 22:11
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T      data;

    public CommonResult(Integer code,String message) {
        this(code, message, null);
    }
}
