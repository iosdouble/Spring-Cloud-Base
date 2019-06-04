package com.example.springcloudfeign.service;

import com.example.springcloudfeign.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    public String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer integer);

    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public String hello(@RequestBody User user);

}
