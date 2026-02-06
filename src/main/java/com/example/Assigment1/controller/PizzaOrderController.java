package com.example.Assigment1.controller;

import com.example.Assigment1.model.CrustType;
import com.example.Assigment1.model.PizzaOrder;
import com.example.Assigment1.model.PizzaSize;
import com.example.Assigment1.model.Topping;
import com.example.Assigment1.service.PizzaOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PizzaOrderController {

    private PizzaOrderService service;

    public PizzaOrderController(PizzaOrderService service) {
        this.service = service;
    }

    @ModelAttribute("pizzaOrder")
    public PizzaOrder pizzaOrder() {
        PizzaOrder o = new PizzaOrder();
        o.setQuantity(1);
        return o;
    }

    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("sizes", PizzaSize.values());
        model.addAttribute("crusts", CrustType.values());
        model.addAttribute("toppings", Topping.values());
        return "order_form";
    }

    @PostMapping("/order")
    public String submitOrder(PizzaOrder pizzaOrder, Model model) {

        if (pizzaOrder.isDelivery()){
            if (pizzaOrder.getDeliveryAddress() == null || pizzaOrder.getDeliveryAddress().trim().isEmpty()) {

                model.addAttribute("error", "Delivery address is required if delivery is selected.");

                model.addAttribute("sizes", PizzaSize.values());
                model.addAttribute("crusts", CrustType.values());
                model.addAttribute("toppings", Topping.values());

                return "order_form";
            }
        }
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
