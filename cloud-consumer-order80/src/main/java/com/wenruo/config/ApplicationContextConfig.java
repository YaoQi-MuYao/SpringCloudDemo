package com.wenruo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/6/29 15:01
 * @version: 1.0.0
 */
@Configuration
public class ApplicationContextConfig {

    /**
     *  注解@LoadBalanced赋予 RestTemplate负载均衡地能力
     * @param: []
     * @return: org.springframework.web.client.RestTemplate
     * @author: MuYao.Zhang
     * @date: 2020/7/8 16:14
     **/
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
