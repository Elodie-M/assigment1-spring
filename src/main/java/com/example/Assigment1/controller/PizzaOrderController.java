package com.example.Assigment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaOrderController {

    @GetMapping("/order")
    public String order() {
        return "order_form";
    }

    @GetMapping("/summary")
    public String summary() {
        return "summary";
    }

    @GetMapping("/history")
    public String history() {
        return "history";
    }
}
