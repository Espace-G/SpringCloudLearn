package cn.chen.springcloud.controller;


import cn.chen.springcloud.domain.CommonResult;
import cn.chen.springcloud.domain.Order;
import cn.chen.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(@RequestParam Order order){
        orderService.create(order);
        return new CommonResult<>(200,"创建订单成功!");
    }


}
