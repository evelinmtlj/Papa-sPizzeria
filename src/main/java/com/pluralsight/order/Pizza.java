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
    private List<Topping> sides = new ArrayList<>();


    public static String[] cheeseTypes = {"Mozzarella", "Parmesan", " Ricotta", "Goat Cheese", "Buffalo"};
    public static String[] pizzaSize =  {"Personal 8", "Medium 12", "Large 16"};
   public static double [] pizzaPrice =  {8.50,12.00,16.50};
   public static String[] meats =  {"Pepperoni", "Sausage", "Ham", "Bacon", "Chicken", "Meatball"};



    public Pizza(String size, Crust crust, double basePrice) {
        super(size,1,0.0,"Pizza");
        this.size = size;
        this.crust = crust;

    }
    public String getSize(){
        return size;
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
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
public void addSide(Topping topping){
       sides.add(topping);
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
        for(Topping t : sides){
            price += t.getExtraPrice();
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

        StringBuilder rFormat = new StringBuilder();

        //header
        rFormat.append(String.format("%-40s Qty: %d\n", size.toUpperCase() + "PIZZA", getQuantity()));
        rFormat.append("✦·┈๑⋅⋯ ⋯⋅๑┈·✦✦·┈๑⋅⋯ ⋯⋅๑┈·✦✦·┈๑⋅⋯ ⋯⋅๑┈·✦✦·┈๑⋅⋯ ⋯⋅๑┈·✦\n");

        //base
        rFormat.append(String.format(" %-38s $%.2f\n", crust.getName() + " Crust", getBasePriceBySize()));

        //toppings with prices
        for(Topping t: meatToppings) {
            rFormat.append(String.format("   + %-35s$%.2f\n", t.getName(),t.getExtraPrice()));
        }
        for(Topping t: cheeseToppings) {
            rFormat.append(String.format("   + %-35s $%.2f\n", t.getName(), t.getExtraPrice()));
        }
        for(Topping t : regularToppings) {
            if(t.getExtraPrice() > 0) {
                rFormat.append(String.format("   + %-35s  $%.2f\n", t.getName(), t.getExtraPrice()));
            } else {
                rFormat.append(String.format("   + %-35s FREE\n", t.getName()));
            }
        }
        for(Sauce s : sauces){
            rFormat.append(String.format("   + %-35s  FREE\n", s.getName() + " Sauce"));
        }
        for(Topping t : sides) {
            rFormat.append(String.format("   + %-35s  FREE\n", t.getName() + " (side)"));
        }
        if(stuffedCrust) {
            rFormat.append(String.format("   + %-35s $%.2f\n", "Stuffed Crust", 2.00));
        }
        rFormat.append("✦·┈๑⋅⋯ ⋯⋅๑┈·✦✦·┈๑⋅⋯ ⋯⋅๑┈·✦✦·┈✦·┈๑⋅⋯ ⋯⋅๑┈·✦๑⋅⋯ ⋯⋅๑┈·✦\n");
        rFormat.append(String.format("%-40s $%.2f\n", "SUBTOTAL:", getPrice()));
        return rFormat.toString();
    }
    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                '}';
    }
}
