package com.wenruo.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @description: 自定义轮询算法接口
 * @author: MuYao
 * @date: Created in 2020/7/10 13:33
 * @version: 1.0.0
 */
public interface LoadBalancer {

    /**
     * 获取服务器集群
     * @param: [serviceInstances]
     * @return: org.springframework.cloud.client.ServiceInstance
     * @author: MuYao.Zhang
     * @date: 2020/7/10 13:36
     **/
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
