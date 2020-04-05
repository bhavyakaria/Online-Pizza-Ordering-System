package com.bhavyakaria.pizza_system.services;

import com.bhavyakaria.pizza_system.exceptions.PizzaOrderException;
import com.bhavyakaria.pizza_system.exceptions.PizzaStoreException;
import com.bhavyakaria.pizza_system.models.*;

import java.util.HashMap;
import java.util.Map;

public class PizzaOrderService {

    public PizzaOrderService() {
    }

    public OrderItem orderPizza(Pizza pizza, int quantity) {

        Map<Ingredient, Integer> defaultIngredients = new HashMap<>();

        for (Ingredient ingredient : pizza.ingredients) {
            defaultIngredients.put(ingredient, 0);
        }

        return new OrderItem.Builder().setPizza(pizza).setQuantity(quantity).setBaseRate(pizza.price).setDefaultIngredients(pizza.ingredients).build();
    }

    public OrderItem addToppings(OrderItem orderItem, Ingredient ingredient) {
        orderItem.addToppings(ingredient);
        return orderItem;
    }

    public OrderItem replaceToppings(OrderItem orderItem, Ingredient newIngredient, Ingredient oldIngredient) {
        if (orderItem.defaultIngredients.contains(oldIngredient)) {
            int index = orderItem.defaultIngredients.indexOf(oldIngredient);
            orderItem.defaultIngredients.add(index, newIngredient);
        }
        return orderItem;
    }

    public void placeOrder(Order order, PizzaStore pizzaStore) {
        try {
            pizzaStore.acceptOrder(order);
        } catch (PizzaOrderException e) {
            e.printException();
        } catch (PizzaStoreException e) {
            e.printStackTrace();
        }
    }
}
