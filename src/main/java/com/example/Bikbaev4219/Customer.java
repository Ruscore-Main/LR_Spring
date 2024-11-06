package com.example.Bikbaev4219;

public class Customer {
    private final String name;
    private final String address;
    Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public  String getName() {
        return this.name;
    }

    public  String address() {
        return this.address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
