package com.pluralsight;

public class Pizza extends Product{

    public Pizza(String size, int quantity, double price, String description) {
        super(size, quantity, price, description);
    }

    @Override
    public double getPrice() {
       double pizzaSize = switch (size.toLowerCase()) {
           case "personal" -> 8.50;
           case "medium" -> 12.00;
           case "large" -> 16.50;
           default -> 0;
       };

       //for premium toppings
      for(Topping toppings : topping) {
          if(toppings.isPremium()) {
              pizzaSize += toppings.getExtraPrice();
          }
      }

    }


}
