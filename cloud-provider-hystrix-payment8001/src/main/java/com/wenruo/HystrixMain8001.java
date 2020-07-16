package com.wenruo;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.contrib.requests.stream.HystrixRequestEventsSseServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/13 11:36
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8001.class, args);
    }

    /**
     * 此配置为了服务监控而监控，与服务容错本身无关，springcloud升级后的坑
     * servletRegistrationBean 因为SpringBoot的默认路径不是“hystrix.stream",
     * 只要在自己的项目里配置上下面的Servlet就可以
     * @param: []
     * @return: org.springframework.boot.web.servlet.ServletRegistrationBean
     * @author: MuYao.Zhang 
     * @date: 2020/7/16 12:33      
     **/
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(streamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
