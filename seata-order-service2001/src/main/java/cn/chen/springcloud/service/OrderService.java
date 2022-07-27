package cn.chen.springcloud.service;

import cn.chen.springcloud.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

}
