package com.bhavyakaria.pizza_system.models;

import java.util.Map;

public class OrderItem {
    public Pizza pizza;
    public int quantity;
    public int baseRate;
    public int amount;
    public Map<Ingredient, Integer> orderIngredients;

    public OrderItem(Pizza pizza, int quantity, int baseRate, int amount, Map<Ingredient, Integer> orderItemIngredients) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.baseRate = baseRate;
        this.amount = amount;
        this.orderIngredients = orderItemIngredients;
    }

    public int totalToppingsCost() {
        int total = 0;
        for (Map.Entry<Ingredient, Integer> entry : this.orderIngredients.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }
}

// store default ingredients sperately
// orderIngredients -> ingredients


