package com.greetingsapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.greetingsapp.model.Greeting;
import com.greetingsapp.service.GreetingService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/greetings")
public class GreetingController {

  private final GreetingService greetingService;

  public GreetingController(GreetingService greetingService){
    this.greetingService = greetingService;
  }

  // READ - Get all greetings
    @GetMapping
    public String getAllGreetings(Model model) {

        List<Greeting> greetings = greetingService.getAllGreetings();
        model.addAttribute("greetings", greetings);
        return "greetings";
    }

    // READ - Get one greeting
    @GetMapping("/{id}")
    public String getGreetingById(@PathVariable Long id, Model model) {

        Greeting greeting = greetingService.getGreetingById(id);
        model.addAttribute("greeting", greeting);
        return "greeting-details";
    }

    // CREATE - Show form
    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("greeting", new Greeting());
        return "greeting-form";
    }

    // CREATE - Save greeting
    @PostMapping
    public String createGreeting(@ModelAttribute Greeting greeting) {

        greetingService.createGreeting(greeting);
        return "redirect:/greetings";
    }

    // UPDATE - Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Greeting greeting = greetingService.getGreetingById(id);

        model.addAttribute("greeting", greeting);

        return "greeting-edit";
    }

    // UPDATE - Save changes
    @PostMapping("/update/{id}")
    public String updateGreeting(
            @PathVariable Long id,
            @ModelAttribute Greeting greeting) {

        greetingService.updateGreeting(id, greeting);

        return "redirect:/greetings";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {

        greetingService.deleteGreeting(id);

        return "redirect:/greetings";
    }
}
