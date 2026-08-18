package com.firstspringapp.controller;

import com.firstspringapp.model.User;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World !";
    }

    @GetMapping("/hello/query")
    public String helloName(@RequestParam String name){
        return "Hello "+name;
    }

    @GetMapping("/hello/path/{name}")
    public String helloWithPathVariable(@PathVariable String name){
        return "Hello "+name;
    }

    @PostMapping("/hello/body")
    public String helloWithBody(@RequestBody User user){
        return "Hello "+ user.getFirstName();
    }

}
