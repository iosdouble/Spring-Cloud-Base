package com.example.springcloudhelloservice.controller;

import com.example.springcloudhelloservice.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {
   @Autowired
    private DiscoveryClient client;

   @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
       ServiceInstance instance = client.getLocalServiceInstance();
       System.out.println("hello, host:"+instance.getHost()+"service_id"+instance.getServiceId());
       return "HelloWorld!";
   }

   @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello "+name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name,@RequestHeader Integer integer){
        return new User(name,integer);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public String hello(@RequestBody User user){
        return "Hello "+user.getName()+" "+user.getAge();
    }






}
