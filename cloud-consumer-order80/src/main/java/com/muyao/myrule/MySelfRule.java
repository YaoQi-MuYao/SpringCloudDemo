package com.muyao.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/10 13:03
 * @version: 1.0.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule mRule() {
        return new RandomRule();
    }
}
