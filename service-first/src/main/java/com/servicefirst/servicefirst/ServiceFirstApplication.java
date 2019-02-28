package com.servicefirst.servicefirst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.servicefirst.servicefirst.mapper")
public class ServiceFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFirstApplication.class, args);
    }


}
