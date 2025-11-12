package com.pluralsight.order;

public  abstract class Product implements OrderItem {
   protected String size;
   protected int quantity;
   protected double price;
   protected String description;

    public Product(String size, int quantity, double price, String description) {
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public abstract double getPrice();



    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
