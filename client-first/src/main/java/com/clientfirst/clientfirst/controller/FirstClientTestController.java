package com.clientfirst.clientfirst.controller;

import com.clientfirst.clientfirst.feign.ProducerRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstClientTestController {
    @Autowired
    private ProducerRemote producerRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return producerRemote.test(name);
    }
}
