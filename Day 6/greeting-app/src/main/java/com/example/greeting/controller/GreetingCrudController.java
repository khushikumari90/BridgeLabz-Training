package com.example.greeting.controller;

import com.example.greeting.dao.GreetingDao;
import com.example.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greetings")
public class GreetingCrudController {

    @Autowired
    private GreetingDao greetingDao;

    // READ - list all greetings
    @GetMapping
    public String listGreetings(Model model) {
        model.addAttribute("greetings", greetingDao.getAllGreetings());
        return "greetings-list";
    }

    // CREATE - show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greetings-form";
    }

    // CREATE - save new greeting
    @PostMapping("/add")
    public String addGreeting(@ModelAttribute Greeting greeting) {
        greetingDao.addGreeting(greeting);
        return "redirect:/greetings";
    }

    // UPDATE - show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("greeting", greetingDao.getGreetingById(id));
        return "greetings-form";
    }

    // UPDATE - save changes
    @PostMapping("/edit/{id}")
    public String updateGreeting(@PathVariable("id") int id, @ModelAttribute Greeting greeting) {
        greeting.setId(id);
        greetingDao.updateGreeting(greeting);
        return "redirect:/greetings";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable("id") int id) {
        greetingDao.deleteGreeting(id);
        return "redirect:/greetings";
    }
}
