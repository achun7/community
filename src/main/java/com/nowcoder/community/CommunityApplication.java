package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication//Spring Boot项目的核心注解，目的是开启自动配置
public class CommunityApplication {

    @PostConstruct
    public void init() {
        //解决Netty启动冲突问题
        //看Netty4Utils
        System.setProperty("es.set.netty.runtime.available.processors","false");
    }

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
