package com.servicesecond.servicesecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSecondApplication.class, args);
    }

}
