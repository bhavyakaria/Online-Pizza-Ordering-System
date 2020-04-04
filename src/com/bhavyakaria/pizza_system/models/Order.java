package com.bhavyakaria.pizza_system.models;

import com.bhavyakaria.pizza_system.enums.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    public Customer customer;
    public Status status;
    public int totalAmount;
    public Date placedAt;	//placedAt
    public List<OrderItem> orderItems;

    public Order(Customer customer, Status status, Date placedAt) {
        this.customer = customer;
        this.status = status;
        this.placedAt = placedAt;
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
            total += orderItem.amount;

            // additional toppings
            total += orderItem.totalToppingsCost();
        }
        this.totalAmount = total;
        return total;
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public void updateOrderItem(OrderItem orderItem) {
        int index = orderItems.indexOf(orderItem);
        orderItems.set(index, orderItem);
    }

}
