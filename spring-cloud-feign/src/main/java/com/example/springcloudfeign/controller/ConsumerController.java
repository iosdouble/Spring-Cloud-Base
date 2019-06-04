package com.example.springcloudfeign.controller;

import com.example.springcloudfeign.bean.User;
import com.example.springcloudfeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloController(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloController2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("nihui")).append("\n");
        sb.append(helloService.hello("nihui",24)).append("\n");
        sb.append(helloService.hello(new User("nihui",24))).append("\n");
        return sb.toString();
    }
}
