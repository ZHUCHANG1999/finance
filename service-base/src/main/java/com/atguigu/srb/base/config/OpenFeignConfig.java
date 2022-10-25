package com.atguigu.srb.base.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class OpenFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
