package com.duan.issue;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@EnableDubbo(scanBasePackages = "com.duan.issue")
@PropertySource("classpath:/dubbo-consumer.properties")
//@ComponentScan(value = {"com.duan.issue"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
