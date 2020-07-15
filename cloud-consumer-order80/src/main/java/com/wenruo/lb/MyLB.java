package com.wenruo.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: MuYao
 * @date: Created in 2020/7/10 13:37
 * @version: 1.0.0
 */
@Component
public class MyLB implements LoadBalancer {

    /**
     * 原子类
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));

        System.out.println("-------------->next" + next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口第几次请求数%服务器集群总数量 = 实际调用服务器位置下表，每次服务重启后rest接口计数从1开始
     * @param: [serviceInstances]
     * @return: org.springframework.cloud.client.ServiceInstance
     * @author: MuYao.Zhang
     * @date: 2020/7/10 14:08
     **/
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
