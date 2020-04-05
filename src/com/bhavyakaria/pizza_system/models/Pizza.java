package com.bhavyakaria.pizza_system.models;

import java.util.List;

public class Pizza {
    public String name;
    public int price;
    public boolean isCustomizable;
    public boolean isAvailable;
    public List<Ingredient> ingredients;
    public PizzaStore pizzaStore;

    public Pizza(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.isCustomizable = builder.isCustomizable;
        this.isAvailable = builder.isAvailable;
        this.ingredients = builder.ingredients;
        this.pizzaStore = builder.pizzaStore;
    }

    public void updatePrice(int price) {
        this.price = price;
    }

    public void changeStatus(boolean status) {
        this.isAvailable = status;
    }

    public static class Builder {
        public String name;
        public int price;
        public boolean isCustomizable;
        public boolean isAvailable;
        public List<Ingredient> ingredients;
        public PizzaStore pizzaStore;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setCustomizable(boolean customizable) {
            isCustomizable = customizable;
            return this;
        }

        public Builder setAvailable(boolean available) {
            isAvailable = available;
            return this;
        }

        public Builder setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder setPizzaStore(PizzaStore pizzaStore) {
            this.pizzaStore = pizzaStore;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

// create an interface of pizza
//