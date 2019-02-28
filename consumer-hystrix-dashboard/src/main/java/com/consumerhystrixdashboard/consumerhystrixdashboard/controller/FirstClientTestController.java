package com.consumerhystrixdashboard.consumerhystrixdashboard.controller;

import com.consumerhystrixdashboard.consumerhystrixdashboard.feign.ProducerRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstClientTestController {
    @Autowired
    private ProducerRemote producerRemote;

    @RequestMapping("/selectChatuser/{id}")
    public String selectChatuser(@PathVariable("id") String id) {
        return producerRemote.selectChatuser(id);
    }
    @RequestMapping("/selectChatuser")
    public String selectChatuserByid(@RequestParam(value = "id") String id) {
        return producerRemote.selectChatuser(id);
    }

    @RequestMapping("/listChatuser")
    public String listChatuser(@RequestParam(value = "page") int page,
                       @RequestParam(value = "size") int size) {
        return producerRemote.listChatuser(page,size);
    }
}
