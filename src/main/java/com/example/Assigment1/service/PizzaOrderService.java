package com.example.Assigment1.service;

import com.example.Assigment1.model.PizzaOrder;
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

        orders.add(order);

        return order;
    }

    // history
    public List<PizzaOrder> getAllOrders() {
        return orders;
    }
}
