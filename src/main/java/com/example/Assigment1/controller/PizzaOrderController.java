package com.example.Assigment1.controller;

import com.example.Assigment1.service.PizzaOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaOrderController {

    private PizzaOrderService service;

    public PizzaOrderController(PizzaOrderService service) {
        this.service = service;
    }

    @GetMapping("/order")
    public String order() {
        return "order_form";
    }

    @GetMapping("/summary")
    public String summary() {
        return "summary";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("orders", service.getAllOrders());
        return "history";
    }
}
