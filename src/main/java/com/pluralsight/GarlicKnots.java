package com.pluralsight;

public class GarlicKnots extends Product{

    public GarlicKnots(int quantity) {
        super("One size",quantity,1.50,"Garlic knots");
    }

    @Override
    public double getPrice() {
        double pricePerItem = 1.50;
        return pricePerItem * quantity;
    }


}
