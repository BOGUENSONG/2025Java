package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello") //간단한 Get API 만들기. Hello world
    public String Hello(){
        return "Hello World!";
    }
}
