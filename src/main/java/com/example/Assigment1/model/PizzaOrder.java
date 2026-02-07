package com.example.Assigment1.model;

import java.time.LocalDateTime;
import java.util.List;

public class PizzaOrder {

    private Long id;
    private String customerName;

    private PizzaSize size;
    private CrustType crust;
    private List<Topping> toppings;

    private int quantity;
    private boolean delivery;
    private String deliveryAddress;

    private double subtotal;
    private double discountAmount;
    private double tax;
    private double total;

    private LocalDateTime orderTime;

    // Getter/Setter

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public PizzaSize getSize(){
        return size;
    }
    public void setSize(PizzaSize size){
        this.size = size;
    }

    public CrustType getCrust(){
        return crust;
    }
    public void setCrust(CrustType crust){
        this.crust = crust;
    }

    public List<Topping> getToppings(){
        return toppings;
    }
    public void setToppings(List<Topping> toppings){
        this.toppings = toppings;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public boolean isDelivery(){
        return delivery;
    }
    public void setDelivery(boolean delivery){
        this.delivery = delivery;
    }

    public String getDeliveryAddress(){
        return deliveryAddress;
    }
    public void setDeliveryAddress(String deliveryAddress){
        this.deliveryAddress = deliveryAddress;
    }

    public double getSubtotal(){
        return subtotal;
    }
    public void setSubtotal(double subtotal){
        this.subtotal = subtotal;
    }

    public double getDiscountAmount(){
        return discountAmount;
    }
    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTax(){
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal(){
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
