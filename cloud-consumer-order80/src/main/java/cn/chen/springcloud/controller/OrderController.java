package cn.chen.springcloud.controller;


import cn.chen.springcloud.entities.CommenResult;
import cn.chen.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommenResult<Payment> create(Payment payment){
        log.info(payment + "");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommenResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommenResult.class);
    }

    @GetMapping("consumer/payment/getEntity/{id}")
    public CommenResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommenResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommenResult.class);
        log.info("********code : " + forEntity.getStatusCode());
        log.info("********header : " + forEntity.getHeaders());
        if(forEntity.getBody() != null){
            return forEntity.getBody();
        }else{
            return new CommenResult<Payment>(444,"查询失败");
        }
    }

}
