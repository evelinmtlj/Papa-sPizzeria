package com.pluralsight;

public class GarlicKnots extends Product{

    public GarlicKnots(String size, int quantity, double price, String description) {
        super(size, quantity, price, description);
    }

    @Override
    public double getPrice() {
        return 0;
    }


}
