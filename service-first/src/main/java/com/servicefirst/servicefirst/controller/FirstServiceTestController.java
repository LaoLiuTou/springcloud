package com.servicefirst.servicefirst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstServiceTestController {
    @RequestMapping("/test")
    public String test(@RequestParam(value = "name") String name) {

        return "第一个生产者！！！Name:" + name;
    }
}
