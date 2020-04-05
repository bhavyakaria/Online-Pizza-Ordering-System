package com.bhavyakaria.pizza_system;

import com.bhavyakaria.pizza_system.enums.PizzaOrderStatus;
import com.bhavyakaria.pizza_system.models.*;
import com.bhavyakaria.pizza_system.services.PizzaOrderService;
import com.bhavyakaria.pizza_system.services.PizzaStoreService;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PizzaOrderService pizzaOrderService = new PizzaOrderService();
        int NO_OF_PIZZAS = 10;
        int NO_OF_TOPPINGS = 5;

        PizzaStoreService pizzaStoreService = new PizzaStoreService();

        PizzaStore pizzaStore1 = new PizzaStore("Pizza Hut");
        pizzaStore1.setPizzaList(pizzaStoreService.generatePizzaList(NO_OF_PIZZAS, pizzaStore1));
        pizzaStore1.setToppingList(pizzaStoreService.generateToppingsList(NO_OF_TOPPINGS, pizzaStore1));
        pizzaStoreService.addPizzaStore(pizzaStore1);

        PizzaStore pizzaStore2 = new PizzaStore("ABC Pizza");
        pizzaStore2.setPizzaList(pizzaStoreService.generatePizzaList(NO_OF_PIZZAS, pizzaStore2));
        pizzaStore2.setToppingList(pizzaStoreService.generateToppingsList(NO_OF_TOPPINGS, pizzaStore2));
        pizzaStoreService.addPizzaStore(pizzaStore2);

        List<Pizza> pizzaMenu = pizzaStoreService.getPizzaMenu();
        List<Ingredient> toppingsMenu = pizzaStoreService.getToppingsMenu();

	    Customer customer = new Customer.Builder().setFirstName("Bhavya").setLastName("Karia").setEmail("bhavya@gmail.com").build();

	    Order order = pizzaStoreService.generateNewOrder(customer);

        // add pizza to order
        OrderItem orderItemOne = pizzaOrderService.orderPizza(pizzaMenu.get(3), 2);

        // add toppings
        orderItemOne = pizzaOrderService.addToppings(orderItemOne, toppingsMenu.get(2));

        // replace the default topping
        orderItemOne = pizzaOrderService.replaceToppings(orderItemOne, toppingsMenu.get(4), toppingsMenu.get(3));

        // add another pizza
        OrderItem orderItemThree = pizzaOrderService.orderPizza(pizzaMenu.get(5), 4);

        order.addOrderItem(orderItemOne);
        order.addOrderItem(orderItemThree);

        // place the order
        pizzaOrderService.placeOrder(order, pizzaStore1);

        Order order2 = pizzaStoreService.generateNewOrder(customer);

        OrderItem orderItem3 = pizzaOrderService.orderPizza(pizzaMenu.get(3), 4);
        order2.addOrderItem(orderItem3);

        pizzaOrderService.placeOrder(order2, pizzaStore2);

        System.out.println("Customer: " + customer.getFirstName() + " has " + customer.getOrders().size() + " orders");
        pizzaStoreService.getPizzaStoreAnalytics(PizzaOrderStatus.CONFIRMED, pizzaStore1);

    }
}

/**
 * Output:
 * Customer: Bhavya has 2 orders
 * Order 1:
 *
 * Order Item: Pizza 3 Amount: 206
 * Toppings: Topping 2 Price: 52
 * Toppings: Topping 4 Price: 54
 *
 * Order Item: Pizza 5 Amount: 420
 * Toppings: Topping 0 Price: 0
 * Total Amount: 732
 *
 * */
