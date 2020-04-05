package com.bhavyakaria.pizza_system.services;

import com.bhavyakaria.pizza_system.enums.PizzaOrderStatus;
import com.bhavyakaria.pizza_system.models.*;

import java.util.ArrayList;
import java.util.List;

public class PizzaStoreService {

    public List<PizzaStore> pizzaStoreList = new ArrayList<>();

    public PizzaStoreService() {
    }

    public void addPizzaStore(PizzaStore pizzaStore) {
        pizzaStoreList.add(pizzaStore);
    }

    public List<Ingredient> generateToppingsList(int NO_OF_TOPPINGS, PizzaStore pizzaStore) {
        List<Ingredient> toppingList = new ArrayList<>();
        // adding toppings available for order
        for (int i = 0; i < NO_OF_TOPPINGS; i++) {
            toppingList.add(new Ingredient.IngredientBuilder().setName("Topping "+i).setPrice(50 + i).setAvailable(true).setVeg(true).setPizzaStore(pizzaStore).build());
        }
        return toppingList;
    }

    public List<Pizza> generatePizzaList(int NO_OF_PIZZAS, PizzaStore pizzaStore) {

        List<Pizza> pizzaList = new ArrayList<>();
        // adding pizzas available for order
        for (int i = 0; i < NO_OF_PIZZAS; i++) {
            List<Ingredient> ingredients = new ArrayList<>();
            ingredients.add(new Ingredient.IngredientBuilder().setName("Topping "+i).setPrice(50 + i).setAvailable(true).setVeg(true).setPizzaStore(pizzaStore).build());
            pizzaList.add(new Pizza.Builder().setName("Pizza "+i).setPrice(100+i).setAvailable(true).setCustomizable(true).setIngredients(ingredients).setPizzaStore(pizzaStore).build());
        }
        return pizzaList;
    }

    public Order generateNewOrder(Customer customer) {
        return new Order(customer, PizzaOrderStatus.CREATED);
    }

    public List<Pizza> getPizzaMenu() {
        List<Pizza> pizzaList = new ArrayList<>();

        for (PizzaStore pizzaStore : pizzaStoreList) {
            pizzaList.addAll(pizzaStore.getPizzaList());
        }
        return pizzaList;
    }

    public List<Ingredient> getToppingsMenu() {
        List<Ingredient> toppingList = new ArrayList<>();

        for (PizzaStore pizzaStore : pizzaStoreList) {
            toppingList.addAll(pizzaStore.getToppingList());
        }
        return toppingList;
    }

    public void getPizzaStoreAnalytics(PizzaOrderStatus pizzaOrderStatus, PizzaStore pizzaStore) {
        int count = 0;
        for (Order order : pizzaStore.getOrderList()) {
            if (order.pizzaOrderStatus.equals(pizzaOrderStatus)) {
                count += 1;
            }
        }
        System.out.printf("Count of %s orders is %d\n",pizzaOrderStatus,count);
    }

}
