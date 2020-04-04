package com.bhavyakaria.pizza_system.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    public String firstName;
    public String lastName;
    public String email;
    public String mobileNumber;
    public String address;
    public List<Order> orders = new ArrayList<>();

    public Customer(String firstName, String lastName, String email, String mobileNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}

// improvise by converting attributes into list case of adding more attributes