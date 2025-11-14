package com.pluralsight.order;

public class GarlicKnots extends Product {

    public GarlicKnots(int quantity) {
        super("One size",quantity,1.50,"Garlic knots");
    }

    @Override
    public double getPrice() {
        double pricePerItem = 1.50;
        return pricePerItem * quantity;
    }

    @Override
    public String getDescription(){
        StringBuilder garlicFormat = new StringBuilder();

       garlicFormat.append(String.format("%-35s Qty: %-3d $%.2f\n",
               "Garlic Knots", getQuantity(), getPrice()));

        return garlicFormat.toString();

    }


}
