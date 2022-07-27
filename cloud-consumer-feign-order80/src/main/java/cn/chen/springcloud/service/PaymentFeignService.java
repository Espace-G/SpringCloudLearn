package cn.chen.springcloud.service;

import cn.chen.springcloud.entities.CommenResult;
import cn.chen.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommenResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
