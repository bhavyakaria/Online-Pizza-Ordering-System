package com.bhavyakaria.pizza_system.services;

import com.bhavyakaria.pizza_system.enums.Status;
import com.bhavyakaria.pizza_system.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PizzaOrderService {

    public List<Order> orderList = new ArrayList<>();

    public PizzaOrderService() {
    }

    public OrderItem orderPizza(Customer customer, Pizza pizza, int quantity) {

        Map<Ingredient, Integer> defaultIngredients = new HashMap<>();

        for (Ingredient ingredient : pizza.ingredients) {
            defaultIngredients.put(ingredient, 0);
        }

        OrderItem orderItem = new OrderItem(pizza, quantity, pizza.price, quantity*pizza.price, defaultIngredients);

        Order order = getOpenOrderOfCustomer(customer);
        order.addOrderItem(orderItem);

        orderList.add(order);

        return orderItem;
    }

    public OrderItem addToppings(OrderItem orderItem, Ingredient ingredient) {
        orderItem.orderIngredients.put(ingredient, ingredient.price);
        return orderItem;
    }

    public OrderItem replaceToppings(OrderItem orderItem, Ingredient newIngredient, Ingredient oldIngredient) {
        boolean status = orderItem.orderIngredients.containsKey(oldIngredient);
        if (status) {
            orderItem.orderIngredients.remove(oldIngredient);
        }
        orderItem.orderIngredients.put(newIngredient, newIngredient.price);
        return orderItem;
    }

    private Order getOpenOrderOfCustomer(Customer customer) {
        Order order;
        if (customer.orders.size() > 0 && customer.orders.get(customer.orders.size() - 1).status.equals(Status.OPEN)) {
            order = customer.orders.get(customer.orders.size() - 1);
        } else {
            order = new Order(customer, Status.OPEN, null);
            customer.orders.add(order);
        }
        return order;
    }

    public void placeOrder(Customer customer) {
        customer.orders.get(customer.orders.size()-1).status = Status.RECEIVED;
    }
}
