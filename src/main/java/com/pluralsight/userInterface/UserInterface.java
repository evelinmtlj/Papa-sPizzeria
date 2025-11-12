package com.pluralsight.userInterface;

import com.pluralsight.order.*;
import com.pluralsight.pizza.Crust;
import com.pluralsight.pizza.Sauce;
import com.pluralsight.pizza.Topping;

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

        //build array of sizes
        String[] sizes = {"Personal 8", "Medium 12", "Large 16"};
        String[] sizeNames = {"Personal", "Medium", "Large"}; //for internal

        IntStream.range(0, sizes.length)
                .forEach(i -> System.out.println((i + 1) + " - " + sizes[i]));

        int sizeOption = ConsoleHelper.promptForInt("Enter option");
        if (sizeOption < 1 || sizeOption > sizes.length) sizeOption = 1; //default to personal
        String size = sizeNames[sizeOption - 1]; //to get the correct size
        System.out.println("Your size is " + size);

        //crust
        String[] crusts = {" Thin", " Regular", " Thick", " Cauliflower"};
        IntStream.range(0, crusts.length)
                .forEach(i -> System.out.println((i + 1) + " - " + crusts[i]));
        int crustOption = ConsoleHelper.promptForInt("Choose crust");
        if (crustOption < 1 || crustOption > crusts.length) crustOption = 2; //defaul to regular
        Crust crust = new Crust(crusts[crustOption - 1]);
        System.out.println("Your crust is: " + crusts[crustOption - 1]);

        //create a pizza
        Pizza pizza = new Pizza(size, crust);
        //meats
        String[] meats = {"Pepperoni", "Sausage", "Ham", "Bacon", "Chicken", "Meatball"};
        if (ConsoleHelper.promptForYesNo("Add meats?")) {
            IntStream.range(0, meats.length)
                    .filter(i -> ConsoleHelper.promptForYesNo("Add " + meats[i] + "?"))
                    .forEach(i -> pizza.addMeatTopping(new Topping(meats[i], "meat", true)));
        }
        //sauces


        //cheeses
        String[] cheeses = {"Mozzarella", "Parmesan", " Ricotta", "Goat Cheese", "Buffalo"};
        if (ConsoleHelper.promptForYesNo("Add cheeses?")) {
            IntStream.range(0, cheeses.length)
                    .filter(i -> ConsoleHelper.promptForYesNo("Add " + cheeses[i] + "?"))
                    .forEach(i -> pizza.addCheeseTopping(new Topping(cheeses[i], "cheese", true)));
        }

        //regular toppings
        String[] regulars = {"Onions", "Mushrooms", "Bell Peppers", "Olives", "Tomatoes", "Spinach",
                "Basil", "Pineapple", "Anchovies"};
        if (ConsoleHelper.promptForYesNo("Add regular toppings?")) {
            System.out.println("\nAvailable regular toppings:");
            for (int i = 0; i < regulars.length; i++) {
            }
            while (true) {
                int choice = ConsoleHelper.promptForInt("Enter topping number (0 when you're done):");

                if (choice == 0) break; //when customer is done
                if (choice < 1 || choice > regulars.length) {
                    System.out.println("Topping not found please try again");
                    continue;
                }

                String toppingName = regulars[choice - 1];
                pizza.addRegularTopping(new Topping(toppingName, "regular", false));
                System.out.println(toppingName + " has been added ");
            }
        }

        //Sauces
        String[] sauces = {"Marinara", "Alfredo", "Pesto", "BBQ", "Buffalo", "Olive oil"};
        if (ConsoleHelper.promptForYesNo("Add sauces?")) {
            System.out.println("\nAvailable sauces");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + " - " + sauces[i]);
            }
            while (true) {
                int choice = ConsoleHelper.promptForInt("Enter sauce number (0 when you're done)");

                if (choice == 0) break;
                if (choice < 1 || choice > sauces.length) {
                    System.out.println("Sauce not found. Please try again");
                    continue;
                }
                String sauceName = sauces[choice - 1];
                pizza.addSauce(new Sauce(sauceName));
                System.out.println(sauceName + " has been added!");
            }
            //sides
            String[] sides = {"Red Pepper", "Parmesan"};
            double[] sidePrices = {0.50, 0.50};

            if (ConsoleHelper.promptForYesNo("Add sides?")) {
                IntStream.range(0, sides.length)
                        .filter(i -> ConsoleHelper.promptForYesNo("Add" + sides[i] + "?"))
                        .forEach(i -> pizza.addSide(new Side(sides[i], sidePrices[i])));
            }
            //add pizza to order
            order.addProduct(pizza);
            System.out.println("Pizza has been added to order");
        }
    }
        private void addDrink () {
            System.out.println("***** Add a drink ******");

            String[] drinks = {"Small", "Medium", "Large"};
            double[] prices = {2.00, 2.50, 3.00};

            IntStream.range(0, drinks.length) //creates range from 0-2
                    .forEach(i -> System.out.println((i + 1) + " - " + drinks[i] + " $" + prices[i]));
            int drinkChoice = ConsoleHelper.promptForInt("Enter drink choice");
            if (drinkChoice < 1 || drinkChoice > drinks.length) drinkChoice = 1;

            Drink drink = new Drink(drinks[drinkChoice - 1], 1, prices[drinkChoice - 1], "Drink");
            order.addProduct(drink);

            System.out.println(drinks[drinkChoice - 1] + "drink added to your order");

        }
        private void addGarlicKnots () {
            int gty = ConsoleHelper.promptForInt("Enter quantity of garlic knots");
            if (gty < 1) gty = 1;

            GarlicKnots knots = new GarlicKnots(gty);
            order.addProduct(knots);
            System.out.println(gty + "Garlic knots added to your order");

        }
        private void checkOut () {
            if (order.getProducts().isEmpty()) {
                System.out.println("Your order is empty : Cannot checkout");
                return;
            }
            System.out.println("\n ──────────────── ⋆⋅Your ☆ Order⋅⋆ ──────────────────");
            List<Product> products = order.getProducts();
            Collections.reverse(products); //newest

            products.forEach(product -> System.out.println(product.getDescription() + " -$" + product.getPrice()));
            System.out.println("Total: $" + order.getTotal());

            if (ConsoleHelper.promptForYesNo("Confirm order")) {
                order.saveReceipt();
                System.out.println("Order Complete.....");
                order = null;
            } else {
                System.out.println("Order canceled.... returning");
                order = null;
            }

        }
    }


