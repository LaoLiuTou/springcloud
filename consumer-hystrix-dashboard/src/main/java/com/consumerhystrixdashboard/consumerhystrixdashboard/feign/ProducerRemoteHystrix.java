package com.consumerhystrixdashboard.consumerhystrixdashboard.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ProducerRemoteHystrix implements ProducerRemote {
    @Override
    public String selectChatuser(@RequestParam(value = "id") String id){

        return "请求失败，已熔断，ID:"+id;
    }

    @Override
    public String listChatuser(int page, int size) {
        return "请求失败，已熔断";
    }
}
