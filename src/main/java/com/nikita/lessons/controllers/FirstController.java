package com.nikita.lessons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surName", required = false)String surName,
                            Model model) {
        model.addAttribute("message", name + " " + surName);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodBuyPage() {
        return "first/goodbye";
    }
}
