package com.dhht.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	  // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
      @Value("${application.hello:Hello Angel}")
      private String hello;

       @RequestMapping("/helloJsp")
       public String helloJsp(ModelMap map){
              System.out.println("HelloController.helloJsp().hello="+hello);
              map.put("hello", hello);
              return "helloJsp";
       }
       
       @RequestMapping("/hello")
       public String hello() {
    	     System.out.println("hello  world");
    	     return "hello";
       }
}
