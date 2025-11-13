package com.pluralsight.userInterface;

import com.pluralsight.order.*;
import com.pluralsight.pizza.Crust;
import com.pluralsight.pizza.Sauce;
import com.pluralsight.pizza.Topping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class UserInterface {

    //use order class
    private Order order;

    public void display() {

        String menu = """
                               ──────────────── ⋆⋅☆⋅⋆ ──────────────────
                                * 🍕   𝕎𝕖𝕝𝕔𝕠𝕞𝕖 𝕥𝕠 ℙ𝔸ℙ𝔸'𝕊 ℙ𝕀ℤℤ𝔼ℝ𝕀𝔸  🍕  *
                               ────────────────── ⋆⋅☆⋅⋆ ─────────────────
                              1 - 𝕟𝕖𝕨 𝕠𝕣𝕕𝕖𝕣
                              2 - 𝕖𝕩𝕚𝕥
                
                """;

        while (true) {
            System.out.println(menu);
            int choice = ConsoleHelper.promptForInt("Enter option");

            switch (choice) {
                case 1:
                    newOrder();
                    break;
                case 2:
                    System.out.println("Thank you for visiting us please come again!");
                    return;

                default:
                    System.out.println("Invalid option please try again");
                    break;
            }

        }

    }

    private void newOrder() {
        order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("""
                     ──────────────── ⋆⋅Order ☆ Screen⋅⋆ ──────────────────
                     1) Add Pizza
                     2) Add Drink
                     3) Add Garlic Knots
                     4) Checkout
                     5) Cancel Order
                    """);
            int choice = ConsoleHelper.promptForInt("Enter choice");

            switch (choice) {
                case 1:
                    addPizza();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addGarlicKnots();
                    break;
                case 4:
                    checkOut();
                    break;
                case 5:
                    System.out.println("Canceling order...... \n Return to main menu");
                    ordering = false;
                    break;
                default:
                    System.out.println("Please enter one of the choices in the menu");
                    break;
            }

        }

    }

    private void addPizza() {
        System.out.println("***** Build your own ******");

//pizza base
        IntStream.range(0, Pizza.pizzaSize.length)
                .forEach(i -> System.out.printf("%d - %15s $%.2f%n",
                        (i + 1), Pizza.pizzaSize[i], Pizza.pizzaPrice[i]));

        int sizeOption = ConsoleHelper.promptForInt("ENTER OPTION");
        if (sizeOption < 1 || sizeOption > Pizza.pizzaSize.length) sizeOption = 1; //default to personal

        String size = Pizza.pizzaSize[sizeOption-1];
        double pizzaPrice = Pizza.pizzaPrice[sizeOption-1];

        String sizeWord = size.split(" ")[0].toLowerCase();

        //crust

        IntStream.range(0, Crust.crustType.length)
                .forEach(i -> System.out.println((i + 1) + " - " + Crust.crustType[i]));
        int crustOption = ConsoleHelper.promptForInt("ENTER CRUST TYPE");
        if (crustOption < 1 || crustOption > Crust.crustType.length) crustOption = 2; //default to regular
        Crust crust = new Crust(Crust.crustType[crustOption - 1]);
        System.out.println("Your crust is: " + Crust.crustType[crustOption - 1]);

        //ask about stuffed crust
        boolean stuffedCrust = ConsoleHelper.promptForYesNo("Stuffed crust for (+$2.00)");

        //create a pizza
        Pizza pizza = new Pizza(sizeWord, crust,pizzaPrice);
        //set stuffed
        if(stuffedCrust) {
            pizza.setStuffedCrust(true);
        }
        //meats
        if (ConsoleHelper.promptForYesNo("ADD MEATS ?")) {
            System.out.println("****** AVAILABLE MEATS *********");
            IntStream.range(0, Pizza.meats.length)
                    .forEach(i -> System.out.println((i+1) + " - " + Pizza.meats[i]));

            while (true) {
                int choice = ConsoleHelper.promptForInt(("Enter meat type (0 when you're done)"));
                if (choice == 0) break;
                if(choice <1 || choice > Pizza.meats.length){
                    System.out.println("Meat type not found please try again");
                    continue;
                }
                String meatName = Pizza.meats[choice-1];
                System.out.println(meatName + " has been added");
                //ask for extra meat?
                boolean isExtra = ConsoleHelper.promptForYesNo("Want to add extra " + meatName + "?");
                String category = isExtra ? "extra meat" : "meat";

                pizza.addMeatTopping(new Topping(meatName,category,true,pizza.getSize()));

            }
        }
        //sauces

        //cheeses
        if (ConsoleHelper.promptForYesNo("Add cheese?")) {
            System.out.println("\n ******** AVAILABLE CHEESE TYPES *********");

            //display cheese with numbers
            IntStream.range(0, Pizza.cheeseTypes.length)
                    .forEach(i -> System.out.println((i+1) + " - " + Pizza.cheeseTypes[i]));
            while(true) {
                int choice = ConsoleHelper.promptForInt(("Enter cheese type (0 when you're done)"));
                if(choice ==0) break;
                if(choice<1 || choice > Pizza.cheeseTypes.length) {
                    System.out.println("Cheese type not found please try again");
                    continue;
                }
                String cheeseName = Pizza.cheeseTypes[choice - 1];
                System.out.println(cheeseName + " has been added");
                //ask for extra cheese
                boolean isExtra = ConsoleHelper.promptForYesNo("Want to add extra " + cheeseName + "?");
                String category = isExtra ? "extra cheese" : "cheese";

                pizza.addCheeseTopping(new Topping(cheeseName, category, true,pizza.getSize()));

            }

                    // prompt use to select cheeses by number
//            String input = ConsoleHelper.promptForString("ENTER THE NUMBER OF CHEESE TYPE YOU WANT: USE COMMA TO ADD MORE");
//               for(String s: input.split(",")){
//                   int n = Integer.parseInt(s.trim());
//                   if(n >= 1 && n <= Pizza.cheeseTypes.length) {
//                       pizza.addCheeseTopping(new Topping(Pizza.cheeseTypes[n-1],"cheese",true));
//                   }
//               }
//            for(int i =0; i < Pizza.cheeseTypes.length; i++) {
//                System.out.println((i+1) + " - "+ Pizza.cheeseTypes[i]);
            }
//
//                    .filter(i -> ConsoleHelper.promptForYesNo("Add " + Pizza.cheeseTypes[i] + "?"))
//
        //regular toppings
        if (ConsoleHelper.promptForYesNo("Add regular toppings?")) {
            System.out.println("\n********** AVAILABLE TOPPINGS ********");
            for (int i = 0; i < Topping.regulars.length; i++) {
                System.out.println((i + 1) + " - " + Topping.regulars[i]);
            }
            while (true) {
                int choice = ConsoleHelper.promptForInt("Enter topping number (0 when you're done)");

                if (choice == 0) break; //when customer is done
                if (choice < 1 || choice > Topping.regulars.length) {
                    System.out.println("Topping not found please try again");
                    continue;
                }

                String toppingName = Topping.regulars[choice - 1];
                pizza.addRegularTopping(new Topping(toppingName, "regular", false,pizza.getSize()));
                System.out.println(toppingName + " has been added ");
            }
        }
        //Sauces
        if (ConsoleHelper.promptForYesNo("Add sauces?")) {
            System.out.println("\nAVAILABLE SAUCES ");
            for (int i = 0; i < Sauce.sauceOptions.length; i++) {
                System.out.println((i + 1) + " - " + Sauce.sauceOptions[i]);
            }
            while (true) {
                int choice = ConsoleHelper.promptForInt("Enter sauce number (0 when you're done)");

                if (choice == 0) break;
                if (choice < 1 || choice > Sauce.sauceOptions.length) {
                    System.out.println("Sauce not found. Please try again");
                    continue;
                }
                String sauceName = Sauce.sauceOptions[choice - 1];
                pizza.addSauce(new Sauce(sauceName));
                System.out.println(sauceName + " has been added!");
            }
            //sides

            if (ConsoleHelper.promptForYesNo("Add sides?")) {
                System.out.println("********* Available sides ***********");
                IntStream.range(0,Topping.sides.length)
                        .forEach(i -> System.out.println((i+1) + " - " + Topping.sides[i]));

                for(int i = 0; i < Topping.sides.length; i++) {
                    if(ConsoleHelper.promptForYesNo("Add " + Topping.sides[i] + "?")) {
                        pizza.addSide(new Topping(Topping.sides[i],"side",false, pizza.getSize() ));
                    }
                }
            }

        }  //add pizza to order
        order.addProduct(pizza);
        System.out.println("Pizza has been added to order");
    }
        private void addDrink () {
            System.out.println("***** Add a drink ******");

            IntStream.range(0, Drink.drinkSize.length) //creates range from 0-2
                    .forEach(i -> System.out.println((i + 1) + " - " + Drink.drinkSize[i] + " $" + Drink.priceDrink[i]));
            int drinkChoice = ConsoleHelper.promptForInt("Enter drink choice");
            if (drinkChoice < 1 || drinkChoice > Drink.drinkSize.length) drinkChoice = 1;

            Drink drink = new Drink(Drink.drinkSize[drinkChoice - 1], 1, Drink.priceDrink[drinkChoice - 1], "Drink");
            order.addProduct(drink);

            System.out.println(Drink.drinkSize[drinkChoice - 1] + "drink added to your order");

        }
        private void addGarlicKnots () {
            int gty = ConsoleHelper.promptForInt("Enter quantity of garlic knots");
            if (gty < 1) gty = 1;

            GarlicKnots knots = new GarlicKnots(gty);
            order.addProduct(knots);
            System.out.println(gty + " Garlic knots added to your order");

        }
        private void checkOut () {
            if (order.getProducts().isEmpty()) {
                System.out.println("Your order is empty : Cannot checkout");
                return;
            }

            //check if order has no pizzas
            boolean hasPizza= false;
            boolean hasGarlicKnots = false;
            boolean hasDrink = false;

            for(Product p: order.getProducts()) {
                if(p instanceof  Pizza) hasPizza = true;
                if(p.getDescription().equalsIgnoreCase("Garlic Knots")) hasGarlicKnots = true;
                if(p instanceof Drink) hasDrink = true;
            }
            order.displayOrder();

            //ask for confirmation
            boolean confirm = ConsoleHelper.promptForYesNo("Would you like to proceed n: to cancel ");
            if(confirm) {
                order.saveReceipt();
                System.out.println("Thank you for your purchase! Order has been saved");
                //to clear
                order.clearOrder();
            } else {
                System.out.println("Order canceled");
            }


//            System.out.println("\n ──────────────── ⋆⋅Your ☆ Order⋅⋆ ──────────────────");
//
//            List<Product> products = order.displayOrder();
//           // Collections.reverse(products); //newest
//
//            products.forEach(product ->
//                    System.out.println(product.getDescription() + " -$" + product.getPrice()));
//            System.out.println("Total: $" + order.getTotal());
//
//            if (ConsoleHelper.promptForYesNo("Confirm order")) {
//                order.saveReceipt();
//                System.out.println("Order Complete.....");
//                order = null;
//            } else {
//                System.out.println("Order canceled.... returning");
//                order = null;
//            }

        }
    }


