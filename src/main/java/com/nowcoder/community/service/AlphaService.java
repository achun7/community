package com.nowcoder.community.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service//作为服务组件扫描为bean
//@Scope("prototype")//每次访问bean创建一个实例（非单例）
public class AlphaService {
    public AlphaService() {
        System.out.println("实例化AlphaService");
    }
    @PostConstruct//在构造器执行之后进行
    public void init() {
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁AlphaService");
    }
}
