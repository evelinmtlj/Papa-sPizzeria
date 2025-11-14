package com.pluralsight.order;

public class Drink extends Product {


    public static String [] drinkSize = {"Small", "Medium", "Large"};
    public static double [] priceDrink = {2.00, 2.50, 3.00};
    public static String [] drinkFlavors = {"Pepsi","Dr Pepper","Aquafina","Sweet Tea","Gatorade"};

    private final String flavor;

    public Drink(String size,String flavor, int quantity, double price, String description) {
        super(size, quantity, price, description);
        this.flavor = flavor;
    }

    public String getFlavor(){
        return flavor;
    }

    @Override
    public double getPrice() {
        double pricePerItem = switch (getSize().toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
        return pricePerItem * quantity;
    }

    @Override
    public String getDescription(){
        StringBuilder drink = new StringBuilder();
        double pricePerItem = switch (getSize().toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };

           //         header
           drink.append(String.format("%-35s Qty: %-3d $%.2f\n", getSize() + " " +
                   flavor, getQuantity(), getPrice()));

        return drink.toString();



    }

}
