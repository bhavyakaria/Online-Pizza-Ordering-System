package com.bhavyakaria.pizza_system.models;

import com.bhavyakaria.pizza_system.enums.PizzaOrderStatus;
import com.bhavyakaria.pizza_system.enums.PizzaStoreStatus;
import com.bhavyakaria.pizza_system.exceptions.PizzaOrderException;
import com.bhavyakaria.pizza_system.exceptions.PizzaStoreException;

import java.util.ArrayList;
import java.util.List;

public class PizzaStore {

    private String name;
    private List<Pizza> pizzaList = new ArrayList<>();
    private List<Ingredient> toppingList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private PizzaStoreStatus status;

    public PizzaStore(String name) {
        this.name = name;
        this.status = PizzaStoreStatus.OPEN;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public void setToppingList(List<Ingredient> toppingList) {
        this.toppingList = toppingList;
    }

    public void setStatus(PizzaStoreStatus status) {
        this.status = status;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Ingredient> getToppingList() {
        return toppingList;
    }

    public void acceptOrder(Order order) throws PizzaStoreException, PizzaOrderException {
        if (!status.equals(PizzaStoreStatus.OPEN)) {
            throw new PizzaStoreException();
        } else {

            for (OrderItem orderItem : order.orderItems) {
                if (orderItem.pizza.pizzaStore != this) {
                    throw new PizzaOrderException();
                }
            }
            orderList.add(order);
            order.setPizzaOrderStatus(PizzaOrderStatus.CONFIRMED);
        }
    }
}
