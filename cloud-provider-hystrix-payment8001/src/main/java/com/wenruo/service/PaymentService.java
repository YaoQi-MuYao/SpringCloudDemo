package com.wenruo.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/13 11:38
 * @version: 1.0.0
 */
@Service
public class PaymentService {

    /**
     * 正常访问，肯定ok的方法
     * @param: [id]
     * @return: java.lang.String
     * @author: MuYao.Zhang
     * @date: 2020/7/13 11:40
     **/
    public String  paymentInfoOK(Integer id) {
        return  "线程池 " + Thread.currentThread().getName() + "   paymentInfoOK  " + id + "\t" + "文若";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {

        Integer num = 3;

        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "线程池 " + Thread.currentThread().getName() + " paymentInfoTimeOut " + id + "\t" + "文若 ";
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return  "线程池 " + Thread.currentThread().getName() + "   系统繁忙  " + id + "\t" + "/(ㄒoㄒ)/~~ ";
    }

    /* ================================================================ */

    /**
     * 熔断
     * @param: [id]
     * @return: java.lang.String
     * @author: MuYao.Zhang
     * @date: 2020/7/13 17:21
     **/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enable", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("=======> id 不能为负");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号" + serialNumber;
    }

    public String paymentCircuitBreakerFallBack(@PathVariable("id") Integer id) {
        return "id 不能为负，请稍后尝试，/(ㄒoㄒ)/~~  id：" + id;
    }

}
