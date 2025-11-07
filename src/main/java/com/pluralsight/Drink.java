package com.pluralsight;

public class Drink extends Product {


    public Drink(String size, int quantity, double price, String description) {
        super(size, quantity, price, description);
    }

    @Override
    public double getPrice() {
        double pricePerItem = switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
        return pricePerItem * quantity;
    }
}
