package cn.chen.springcloud.controller;


import cn.chen.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {
    @Autowired
    private StorageService service;

    @RequestMapping("/storage/decrease")
    public void decrease(Long productId,Integer count){
        service.decrease(productId,count);
    }
}
