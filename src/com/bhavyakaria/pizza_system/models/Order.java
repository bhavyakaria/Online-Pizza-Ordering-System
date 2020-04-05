package com.bhavyakaria.pizza_system.models;

import com.bhavyakaria.pizza_system.enums.PizzaOrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    public Customer customer;
    public PizzaOrderStatus pizzaOrderStatus;
    public int totalAmount;
    public Date placedOn;
    public List<OrderItem> orderItems;
    public PizzaStore pizzaStore;

    public Order(Customer customer, PizzaOrderStatus pizzaOrderStatus) {
        this.customer = customer;
        this.pizzaOrderStatus = pizzaOrderStatus;
        this.placedOn = new Date();
    }

    public void setPizzaOrderStatus(PizzaOrderStatus pizzaOrderStatus) {
        this.pizzaOrderStatus = pizzaOrderStatus;
    }

    public void addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        orderItems.add(orderItem);
    }

    public int calculateTotalAmount() {
        int total = 0;

        // base price
        for (OrderItem orderItem : orderItems) {
            total += orderItem.calculateTotalAmount();
        }
        this.totalAmount = total;
        return this.totalAmount;
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }


    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", status=" + pizzaOrderStatus +
                ", totalAmount=" + totalAmount +
                ", placedOn=" + placedOn +
                ", orderItems=" + orderItems +
                '}';
    }
}
