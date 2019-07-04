package com.shijing.nopainnogain.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: greet
 * @author: Mr.Wang
 * @create: 2019-07-02 23:55
 **/
@RestController
@RequestMapping("/greet")
public class GreetController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
