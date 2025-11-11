package com.pluralsight;

public class UserInterface {

    public void display() {

        String menu = """
                                *************************************
                                *     Welcome to the Main Screen   *
                                **************************************
                              1 - Find vehicles within a price range
                              2 - Find vehicles by make / model
                
                """;

        while (true) {
            System.out.println(menu);
            int choice = ConsoleHelper.promptForInt("Enter option");

            switch (choice) {
                case 1:
                    //
                    break;
                case 2:
                    //

                default:
                    System.out.println("Invalid option please try again");
                    break;
            }

        }

    }
}
