package cn.chen.springcloud.controller;


import cn.chen.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {
    @Autowired
    AccountService service;

    @RequestMapping("/account/decrease")
    public void decrease(@RequestParam Long userId,
                         @RequestParam BigDecimal money){
        service.decrease(userId,money);
    }

}
