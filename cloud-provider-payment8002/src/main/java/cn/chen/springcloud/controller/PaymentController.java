package cn.chen.springcloud.controller;

import cn.chen.springcloud.entities.CommenResult;
import cn.chen.springcloud.entities.Payment;
import cn.chen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService service;

    @PostMapping(value = "/payment/create")
    public CommenResult create(@RequestBody Payment payment){
        int result = service.create(payment);
        log.info("*****插入结果" + result);

        if(result > 0){
            return new CommenResult(200,"插入数据库成功\t服务端口:"+serverPort,result);
        }else{
            return new CommenResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommenResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = service.getPaymentById(id);
        log.info("*****获取结果" + paymentById);
        if(paymentById != null){
            return new CommenResult(200,"查询成功\t服务端口:"+serverPort,paymentById);
        }else{
            return new CommenResult(444,"查询失败",null);
        }
    }
}
