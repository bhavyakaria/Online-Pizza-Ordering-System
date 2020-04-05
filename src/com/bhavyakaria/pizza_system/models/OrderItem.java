package com.bhavyakaria.pizza_system.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderItem {
    public Pizza pizza;
    public int quantity;
    public int baseRate;
    public int amount;
    public List<Ingredient> defaultIngredients = new ArrayList<>();
    public List<Ingredient> orderIngredients = new ArrayList<>();

    public OrderItem(Builder builder) {
        this.pizza = builder.pizza;
        this.quantity = builder.quantity;
        this.baseRate = builder.baseRate;
        this.amount = builder.amount;
        this.defaultIngredients = builder.defaultIngredients;
    }

    public void addToppings(Ingredient ingredient) {
        this.orderIngredients.add(ingredient);
    }

    public int calculateTotalAmount() {
        int total = 0;
        for (Ingredient ingredient : orderIngredients) {
            total += ingredient.price;
        }
        this.amount = this.quantity*this.baseRate + total;
        return this.amount;
    }

    public static class Builder {
        public Pizza pizza;
        public int quantity;
        public int baseRate;
        public int amount;
        public List<Ingredient> defaultIngredients = new ArrayList<>();
        public List<Ingredient> orderIngredients = new ArrayList<>();

        public Builder setPizza(Pizza pizza) {
            this.pizza = pizza;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setBaseRate(int baseRate) {
            this.baseRate = baseRate;
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDefaultIngredients(List<Ingredient> defaultIngredients) {
            this.defaultIngredients = defaultIngredients;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }

    }

}

// store default ingredients sperately
// orderIngredients -> ingredients


