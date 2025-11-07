package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Product{
private String size;
    private Crust crust;
    private List<Topping> meatToppings = new ArrayList<>();
    private List<Topping> cheeseToppings = new ArrayList<>();
    private List<Topping> regularToppings = new ArrayList<>();
    private List<Topping> sauces = new ArrayList<>();

    public Pizza(String size, int quantity, double price, String description) {
        super(size, quantity, price, description);
    }

    @Override
   public double getPrice() {
        double price = getBasePriceBySize();

        for(Topping t : meatToppings) {
            price += t.getExtraPrice();
        }
        for(Topping t: cheeseToppings) {
            price += t.getExtraPrice();
        }
        return price;
    }




    private double getBasePriceBySize(){
        return switch (size.toLowerCase()) {
            case "personal" -> 8.50;
            case "medium" -> 12.00;
            case "large" -> 16.50;
            default -> 0.0;
        };






}
