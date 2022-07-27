package cn.chen.springcloud.controller;

import cn.chen.springcloud.entities.CommenResult;
import cn.chen.springcloud.entities.Payment;
import cn.chen.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {


    @Resource
    private PaymentFeignService feignService;
    
    @GetMapping("/consumer/payment/get/{id}")
    public CommenResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommenResult<Payment> paymentById = feignService.getPaymentById(id);
        return paymentById;
    }
}
