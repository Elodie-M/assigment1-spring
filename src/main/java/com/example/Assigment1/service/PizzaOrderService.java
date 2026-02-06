package com.example.Assigment1.service;

import com.example.Assigment1.model.PizzaOrder;
import com.example.Assigment1.model.PizzaSize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderService {

    private List<PizzaOrder> orders = new ArrayList<>();
    private long nextId = 1;

    // save order
    public PizzaOrder placeOrder(PizzaOrder order) {

        order.setId(nextId);
        nextId++;

        order.setOrderTime(LocalDateTime.now());

        calculatePrices(order);

        orders.add(order);

        return order;
    }

    private void calculatePrices(PizzaOrder order) {
        double basePrice = getBasePrice(order.getSize());

        int toppingCount = 0;
        if (order.getToppings() != null) {
            toppingCount = order.getToppings().size();
        }

        double toppingCost = toppingCount * 1.25;
        double pricePerPizza = basePrice + toppingCost;

        int qty = order.getQuantity();
        double pizzaSubtotal = pricePerPizza * qty;

        // Discount: 10% off pizza subtotal if quantity > 3
        double discount = 0.0;
        if (qty > 3) {
            discount = pizzaSubtotal * 0.10;
        }

        // Delivery fee: $3.99 if delivery
        double deliveryFee = order.isDelivery() ? 3.99 : 0.0;

        // Tax: 13% on (pizzaSubtotal - discount + deliveryFee)
        double taxableAmount = (pizzaSubtotal - discount) + deliveryFee;
        double tax = taxableAmount * 0.13;

        double total = taxableAmount + tax;

        // Round to 2 decimals
        order.setSubtotal(round2(pizzaSubtotal));
        order.setDiscountAmount(round2(discount));
        order.setTax(round2(tax));
        order.setTotal(round2(total));
    }

    private double getBasePrice(PizzaSize size) {
        if (size == null) return 0.0; // temporary safety for now

        switch (size) {
            case SMALL: return 8.00;
            case MEDIUM: return 10.00;
            case LARGE: return 12.00;
            default: return 0.0;
        }


    }

    // history
    public List<PizzaOrder> getAllOrders() {
        return orders;
    }

    private double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
