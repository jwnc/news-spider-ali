package com.wnc.dubbo.news.qq;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by Jaycekon on 20/09/2017.
 */
// Spring Boot 应用的标识
@SpringBootApplication
@EnableDubbo
public class QqNewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(QqNewsApplication.class, args);
    }
}