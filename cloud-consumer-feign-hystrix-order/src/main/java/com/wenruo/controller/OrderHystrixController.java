package com.wenruo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wenruo.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/13 14:36
 * @version: 1.0.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfoOK(id);
    }


//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或自己运行出错请检查自己，/(ㄒoㄒ)/~~";
    }

    /**
     * 一个统一的fallBackMethod，如果没有指定使用特定的fallBackMethod方法，就会使用这种统一的方法
     * @param: []
     * @return: java.lang.String
     * @author: MuYao.Zhang
     * @date: 2020/7/13 16:11
     **/
    public String paymentGlobalFallBackMethod() {
        return "Global异常处理信息，请稍后尝试，/(ㄒoㄒ)/~~";
    }
}
