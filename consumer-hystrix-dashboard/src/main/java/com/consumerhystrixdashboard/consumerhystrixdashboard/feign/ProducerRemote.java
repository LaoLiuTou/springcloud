package com.consumerhystrixdashboard.consumerhystrixdashboard.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-producer",fallback = ProducerRemoteHystrix.class)
public interface ProducerRemote {
    @RequestMapping(value = "/selectChatuser")
    public String selectChatuser(@RequestParam(value = "id") String id);
    @RequestMapping(value = "/listChatuser")
    public String listChatuser(@RequestParam(value = "page") int page,@RequestParam(value = "size") int size);
}
