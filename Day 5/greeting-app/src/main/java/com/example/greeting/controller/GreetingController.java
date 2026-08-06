package com.example.greeting.controller;

import com.example.greeting.model.GreetingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // ---------- GET METHOD ----------
    // Jab user pehli baar page open karega -> ye form dikhayega
    @GetMapping("/greeting")
    public String showGreetingForm(Model model) {
        model.addAttribute("greetingModel", new GreetingModel());
        return "greeting";   // -> /WEB-INF/views/greeting.jsp
    }

    // ---------- POST METHOD ----------
    // Jab user form submit karega (naam bharke) -> ye greeting message banayega
    @PostMapping("/greeting")
    public String processGreeting(@RequestParam("name") String name, Model model) {
        String message = "Hello, " + name + "! Welcome to Spring MVC Greeting App.";
        model.addAttribute("message", message);
        model.addAttribute("greetingModel", new GreetingModel());
        return "greeting";   // same view, ab message ke saath
    }
}
