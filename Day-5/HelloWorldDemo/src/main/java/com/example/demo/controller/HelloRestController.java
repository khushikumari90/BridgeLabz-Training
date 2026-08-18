package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello From BridgeLabz!!!";
    }

    @GetMapping("/query")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!!!";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + "!!!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " "
                + user.getLastName() + "!!!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(
            @PathVariable String firstName,
            @RequestParam(value = "lastName") String lastName) {

        return "Hello " + firstName + " " + lastName + "!!!";
    }
}