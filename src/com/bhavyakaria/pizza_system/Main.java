package com.bhavyakaria.pizza_system;

import com.bhavyakaria.pizza_system.models.Customer;
import com.bhavyakaria.pizza_system.models.Ingredient;
import com.bhavyakaria.pizza_system.models.OrderItem;
import com.bhavyakaria.pizza_system.models.Pizza;
import com.bhavyakaria.pizza_system.services.PizzaOrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        PizzaOrderService pizzaOrderService = new PizzaOrderService();
        int NO_OF_PIZZAS = 10;
        int NO_OF_TOPPINGS = 5;
        List<Pizza> pizzaList = new ArrayList<>();
        List<Ingredient> toppingsList = new ArrayList<>();

        // adding toppings available for order
        for (int i = 0; i < NO_OF_TOPPINGS; i++) {
            toppingsList.add(new Ingredient("Topping "+i, null, 50+i, true, true));
        }

        // adding pizzas available for order
        for (int i = 0; i < NO_OF_PIZZAS; i++) {
            List<Ingredient> ingredients = new ArrayList<>();
            ingredients.add(toppingsList.get(i % 5));
            pizzaList.add(new Pizza("Pizza "+i, 100+i, true, true, ingredients));
        }

	    Customer customer = new Customer("Bhavya", "Karia", "abc@gmail.com", "1234567890", "103");

        // add pizza to order
        OrderItem orderItemOne = pizzaOrderService.orderPizza(customer, pizzaList.get(3), 2);

        // add toppings
        orderItemOne = pizzaOrderService.addToppings(orderItemOne, toppingsList.get(2));

        // replace the default topping
        orderItemOne = pizzaOrderService.replaceToppings(orderItemOne, toppingsList.get(4), toppingsList.get(3));

        // add another pizza
        OrderItem orderItemThree = pizzaOrderService.orderPizza(customer, pizzaList.get(5), 4);

        // calculate the total bill
        customer.orders.get(0).calculateTotalAmount();

        // place the order
        pizzaOrderService.placeOrder(customer);

        // place another order by the same customer
        OrderItem orderItemTwo = pizzaOrderService.orderPizza(customer, pizzaList.get(6), 1);

        System.out.println("Customer: " + customer.firstName + " has " + customer.orders.size() + " orders");
        System.out.print("Order 1:");
        for (OrderItem orderItem : customer.orders.get(0).orderItems) {
            System.out.print("\n\nOrder Item: " + orderItem.pizza.name + " Amount: " + orderItem.amount);
            for (Map.Entry<Ingredient, Integer> entry : orderItem.orderIngredients.entrySet()) {
                System.out.print("\nToppings: " + entry.getKey().name + " Price: " + entry.getValue());
            }
        }
        System.out.println("\nTotal Amount: " + customer.orders.get(0).totalAmount);

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
