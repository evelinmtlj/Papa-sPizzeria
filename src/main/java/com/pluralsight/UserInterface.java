package com.pluralsight;

import java.util.Arrays;
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
                    //
                    break;
                case 2:
                    System.out.println("Thank you for visiting us please come again!");

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
                    //
                    break;
                case 2:
                    //
                    break;

                case 3:
                    //
                    break;
                case 4:
                    //
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
    private void addPizza(){
        System.out.println("***** Build your own ******");

        //build array of sizes
        String[] sizes = {"Personal 8", "Medium 12","Large 16"};
        String[] sizeNames = {"Personal","Medium","Large"}; //for internal

        IntStream.range(0, sizes.length)
                .forEach(i -> System.out.println((i+1) + " - " + sizes[i]));

        int sizeOption = ConsoleHelper.promptForInt("Enter option");
        if (sizeOption <1 || sizeOption > sizes.length) sizeOption = 1; //default to personal
        String size = sizeNames[sizeOption -1]; //to get the correct size
        System.out.println("Your size is " + size);

        //crust
        String[] crusts = {"1) Thin", "2) Regular","3) Thick","4) Cauliflower"};
        IntStream.range(0, crusts.length)
                .forEach(i-> System.out.println((i+1) + " - " + crusts[i]));
        int crustOption = ConsoleHelper.promptForInt("Choose crust");
        if(crustOption <1 || crustOption > crusts.length) crustOption = 2; //defaul to regular
        Crust crust = new Crust(crusts[crustOption-1]);
        System.out.println("Your crust is: "  + crusts[crustOption -1]);

        //create a pizza
        Pizza pizza = new Pizza(size,crust);
        //meats
        String[] meats = {"Pepperoni", "Sausage","Ham","Bacon","Chicken","Meatball"};


    }
}
