package com.pluralsight.order;

public class Side extends Product {
    private String name;
    private double price;


    public Side(String name, double price) {
        super("N/A",1,price,"side");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " -$" + String.format("%.2f",price);
    }
}
