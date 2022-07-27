package cn.chen.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.chen.springcloud.dao")
public class MybatisConfig {
}
