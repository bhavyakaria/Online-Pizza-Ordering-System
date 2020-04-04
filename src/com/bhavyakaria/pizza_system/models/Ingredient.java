package com.bhavyakaria.pizza_system.models;

public class Ingredient {
    public String name;
    public String description;
    public int price;
    public boolean isVeg;
    public boolean isAvailable;

    public Ingredient(String name, String description, int price, boolean isVeg, boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isVeg = isVeg;
        this.isAvailable = isAvailable;
    }

//        public boolean updatePrice(boolean price);
//        public boolean changeStatus(boolean status);
}
