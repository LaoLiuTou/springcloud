package com.servicesecond.servicesecond.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondServiceTestController {

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name") String name) {

        return "第二个生产者！！！Name:" + name;
    }
}
