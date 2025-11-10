package com.pluralsight;

import java.awt.image.CropImageFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends Product{
    private String size;
    private Crust crust;
    private List<Topping> meatToppings = new ArrayList<>();
    private List<Topping> cheeseToppings = new ArrayList<>();
    private List<Topping> regularToppings = new ArrayList<>();
    private List<Topping> sauces = new ArrayList<>();

    public Pizza(String size, int quantity, Crust crust) {
        super(size, quantity, 0,"Pizza");
        this.size = size;
        this.crust = crust;

    }

    //add topping and sauces
    public void addMeatTopping(Topping topping){
        meatToppings.add(topping);
    }
public void addCheeseTopping(Topping topping){
        cheeseToppings.add(topping);
}
public void addRegularTopping(Topping topping){
        regularToppings.add(topping);
}
public void addSauce(Topping sauce){
        sauces.add(sauce);
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
       return price * getQuantity();
    }




    private double getBasePriceBySize() {
        return switch (size.toLowerCase()) {
            case "personal" -> 8.50;
            case "medium" -> 12.00;
            case "large" -> 16.50;
            default -> 0.0;
        };
    }

    @Override
    public String getDescription(){
        return size + " pizza with " + crust.getName() +
                " crust, meats: " + listToString(meatToppings) +
                ", cheeses: " + listToString(cheeseToppings) +
                ", toppings: " + listToString(regularToppings) +
                ", sauces: " + listToString(sauces);

    }

    private String listToString(List<Topping> list) {
        if(list.isEmpty()) return "none";
        return list.stream()
                .map(Topping::getName)
                .collect(Collectors.joining(", "));
    }





}
