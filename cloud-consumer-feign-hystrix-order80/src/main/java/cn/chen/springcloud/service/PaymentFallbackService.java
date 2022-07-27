package cn.chen.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService-paymentInfo_OK (┬┬﹏┬┬) ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService-paymentInfo_TimeOut (┬┬﹏┬┬) ";
    }
}
