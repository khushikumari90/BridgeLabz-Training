package com.example.greeting.controller;

import com.example.greeting.dao.GreetingDao;
import com.example.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greetings")
public class GreetingCrudController {

    @Autowired
    private GreetingDao greetingDao;

    // show all greetings
    @GetMapping
    public String list(Model model) {
        model.addAttribute("greetings", greetingDao.getAllGreetings());
        return "greetings-list";
    }

    // show add form
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greetings-form";
    }

    // save new greeting
    @PostMapping("/add")
    public String add(@ModelAttribute Greeting greeting) {
        greetingDao.addGreeting(greeting);
        return "redirect:/greetings";
    }

    // show edit form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("greeting", greetingDao.getGreetingById(id));
        return "greetings-form";
    }

    // update existing greeting
    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute Greeting greeting) {
        greeting.setId(id);
        greetingDao.updateGreeting(greeting);
        return "redirect:/greetings";
    }

    // delete greeting
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        greetingDao.deleteGreeting(id);
        return "redirect:/greetings";
    }
}
