package com.nikita.lessons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebCalculatorController {
    @GetMapping("/calculator")
    public String webCalculator(@RequestParam("a")Double a, @RequestParam("b")Double b,
                                @RequestParam("action")String action, Model model) {
        double result;
        switch (action) {
            case "multiplication": {
                result = a * b;
                break;
            }
            case "addition": {
                result = a + b;
                break;
            }
            case "subtraction": {
                result = a - b;
                break;
            }
            case "division": {
                result = a / b;
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        model.addAttribute("result", result);
        return "calculator/result";
    }
}
