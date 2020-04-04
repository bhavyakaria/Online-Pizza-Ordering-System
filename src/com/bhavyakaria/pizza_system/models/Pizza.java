package com.bhavyakaria.pizza_system.models;

import java.util.List;

public class Pizza {
    public String name;
    public int price;
    public boolean isCustomizable;
    public boolean isAvailable;
    public List<Ingredient> ingredients;

    public Pizza(String name, int price, boolean isCustomizable, boolean isAvailable, List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.isCustomizable = isCustomizable;
        this.isAvailable = isAvailable;
        this.ingredients = ingredients;
    }

    public void updatePrice(int price) {
        this.price = price;
    }

    public void changeStatus(boolean status) {
        this.isAvailable = status;
    }
}

// create an interface of pizza
//