package com.wnc.dubbo.news;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * Created by Jaycekon on 20/09/2017.
 */
// Spring Boot 应用的标识
@SpringBootApplication
@EnableDubbo
public class NewsApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(NewsApplication.class, args);
    }
}