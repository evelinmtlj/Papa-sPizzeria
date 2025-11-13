package com.pluralsight.pizza;

import com.pluralsight.order.Pizza;

public  class Topping {
    private String name;
    private String category;
    private boolean isPremium;
    private String pizzaSize;

    public static  String[] regulars = {"Onions", "Mushrooms", "Bell Peppers", "Olives", "Tomatoes", "Spinach",
            "Basil", "Pineapple", "Anchovies"};
    //sides array
    public static String[] sides = {"Red pepper", "Parmesan"};

    public Topping(String name, String category, boolean isPremium, String pizzaSize) {
        this.name = name;
        this.category = category;
        this.isPremium = isPremium;
        this.pizzaSize = pizzaSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public double getExtraPrice(){
        switch (category.toLowerCase()) {
            case "meat":
                return switch (pizzaSize.toLowerCase()) {
                    case "personal" -> 1.00;
                    case "medium" -> 2.00;
                    case "large" -> 3.00;
                    default -> 0.0;
                };

            case "extra meat":
                return switch (pizzaSize.toLowerCase()){
                    case "personal" -> 0.50;
                    case "medium" -> 1.00;
                    case "large" -> 1.50;
                    default -> 0.0;
                };
            case "cheese":
                return switch (pizzaSize.toLowerCase()) {
                    case "personal" -> 0.75;
                    case "medium" -> 1.50;
                    case "large" -> 2.25;
                    default -> 0.0;
                };
            case "extra cheese":
                return switch (pizzaSize.toLowerCase()) {
                    case "personal" -> 0.30;
                    case "medium" -> 0.60;
                    case "large" -> 0.90;
                    default -> 0.0;
                };
            case "side":
            return 0;
            case "regular":
            default:
                return 0.0; //regulars are free
        }
    }
    @Override
    public String toString(){
        return name;
    }
}
