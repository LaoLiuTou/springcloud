package com.clientfirst.clientfirst.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-producer",fallback = ProducerRemoteHystrix.class)
public interface ProducerRemote {
    @RequestMapping(value = "/test")
    public String test(@RequestParam(value = "name") String name);
}
