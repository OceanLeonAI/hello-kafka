package com.leon.hello.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参考文档：https://juejin.cn/post/6971224791793532941
 * 本地 swagger
 * swagger:http://localhost:8080/swagger-ui.html
 */
@SpringBootApplication
public class HelloKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloKafkaApplication.class, args);
    }

}
