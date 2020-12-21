package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * springboot会在项目启动时自动实例化一个mongo实例，因此需要在项目启动时禁用mongo的自动配置。
 */
@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@EnableAutoConfiguration
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
//@EnableAutoConfiguration开启自动配置功能