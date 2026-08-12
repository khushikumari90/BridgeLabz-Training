package com.example.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // show the greeting form
    @GetMapping("/greeting")
    public String showForm() {
        return "greeting";
    }

    // handle form submit and show message
    @PostMapping("/greeting")
    public String greet(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "Hello, " + name + "! Welcome to Spring MVC Greeting App.");
        return "greeting";
    }
}
