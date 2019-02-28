package com.clientfirst.clientfirst.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Component
public class ProducerRemoteHystrix implements ProducerRemote {
    @Override
    public String test(@RequestParam(value = "name") String name){

        return "请求失败，已熔断，Name:"+name;
    }
}
