package com.bhavyakaria.pizza_system.models;

public class Ingredient {
    public String name;
    public String description;
    public int price;
    public boolean isVeg;
    public boolean isAvailable;
    public PizzaStore pizzaStore;

    public Ingredient(IngredientBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.isVeg = builder.isVeg;
        this.isAvailable = builder.isAvailable;
        this.pizzaStore = builder.pizzaStore;
    }

    public static class IngredientBuilder {
        public String name;
        public String description;
        public int price;
        public boolean isVeg;
        public boolean isAvailable;
        public PizzaStore pizzaStore;

        public IngredientBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public IngredientBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public IngredientBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public IngredientBuilder setVeg(boolean veg) {
            isVeg = veg;
            return this;
        }

        public IngredientBuilder setAvailable(boolean available) {
            isAvailable = available;
            return this;
        }

        public IngredientBuilder setPizzaStore(PizzaStore pizzaStore) {
            this.pizzaStore = pizzaStore;
            return this;
        }

        public Ingredient build() {
            return new Ingredient(this);
        }
    }
}
