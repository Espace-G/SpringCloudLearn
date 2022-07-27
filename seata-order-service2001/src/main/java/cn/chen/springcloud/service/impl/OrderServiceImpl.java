package cn.chen.springcloud.service.impl;

import cn.chen.springcloud.dao.OrderDao;
import cn.chen.springcloud.domain.Order;
import cn.chen.springcloud.service.AccountService;
import cn.chen.springcloud.service.OrderService;
import cn.chen.springcloud.service.StorageService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    StorageService storageService;

    @Autowired
    AccountService accountService;

    @Override
    public void create(Order order) {
        //1.创建订单
        log.info("------------>下单开始。。。");
        orderDao.create(order);

        //2.数据库中减少库存
        log.info("------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->order-service中扣减库存结束");
        //3.数据库中减少余额
        log.info("------->order-service中账户扣钱开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->order-service中账户扣钱结束");
        //4.修改订单状态
        log.info("数据库信息更新完成，修改订单状态信息开始");
        orderDao.update(order.getUserId(),order.getStatus());
    }
}
