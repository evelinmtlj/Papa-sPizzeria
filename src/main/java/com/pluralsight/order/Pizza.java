package com.pluralsight.order;

import com.pluralsight.pizza.Crust;
import com.pluralsight.pizza.Sauce;
import com.pluralsight.pizza.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends Product {
    private String size;
    private Crust crust;
    private boolean stuffedCrust = false;

    private List<Topping> meatToppings = new ArrayList<>();
    private List<Topping> cheeseToppings = new ArrayList<>();
    private List<Topping> regularToppings = new ArrayList<>();
    private List<Sauce> sauces = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();




    public Pizza(String size, Crust crust) {
        super(size,1,0.0,"Pizza");
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
public void addSauce(Sauce sauce){
        sauces.add(sauce);
}
public void addSide(Side side){
        sides.add(side);
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
        for(Topping t: regularToppings){
            price += t.getExtraPrice();
        }
        for(Sauce s: sauces){
            price += s.getExtraPrice();
        }
        for(Side s: sides){
            price += s.getPrice();
        }
        if(stuffedCrust) {
            price += 2.0;
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
                " crust, stuffed: " +(stuffedCrust ? "yes" : "no") +
                ", meats: " + listToString(meatToppings) +
                ", cheeses: " + listToString(cheeseToppings) +
                ", toppings: " + listToString(regularToppings) +
                ", sauces:" + listToString(sauces) +
                " ,sides:" + listToString(sides);

    }
    //convert any list to string
    private String listToString(List<?> list) {
        if(list.isEmpty()) return "none";
        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }





}
