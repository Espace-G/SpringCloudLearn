package cn.chen.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: " + port + "\t" + UUID.randomUUID().toString();
    }
}
