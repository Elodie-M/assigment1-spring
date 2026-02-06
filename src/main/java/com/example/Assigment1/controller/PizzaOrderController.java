package com.example.Assigment1.controller;

import com.example.Assigment1.model.PizzaOrder;
import com.example.Assigment1.service.PizzaOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PizzaOrderController {

    private PizzaOrderService service;

    public PizzaOrderController(PizzaOrderService service) {
        this.service = service;
    }

    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("pizzaOrder", new PizzaOrder());
        return "order_form";
    }

    @PostMapping("/order")
    public String submitOrder(PizzaOrder pizzaOrder, Model model) {

        PizzaOrder savedOrder = service.placeOrder(pizzaOrder);
        model.addAttribute("order", savedOrder);
        return "summary";
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
