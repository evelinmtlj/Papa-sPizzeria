package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private LocalDateTime ordertime;

    //constructor
    public Order(){
        this.ordertime = LocalDateTime.now();
    }

    //add items

    public void addProduct(Product product) {
        products.add(product);
    }
    //get all products
    public List<Product> getProducts(){
        return products;
    }

    //total price
    public double getTotal(){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void displayOrder(){
        System.out.println("\n ---------- Order total -------");

       products.forEach(product ->
               System.out.println(product.getQuantity() +
                       " x " + product.getDescription() +
                       " - $" + String.format("%.2f",product.getPrice())));


        System.out.println("------------------------------");
        System.out.println("Total: $" + String.format("%.2f",getTotal()));
    }

    public void saveReceipt() {

        File receiptFolder = new File("receipts");
        if(!receiptFolder.exists()) {
            receiptFolder.mkdir();
        }

        //create the file
        LocalDateTime orderTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = "receipts/" + ordertime.format(formatter) + ".txt";

        //details to the file

        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write("PAPA'S PIZZERIA RECEIPT \n");
            writer.write("-----------------------\n");

            for (Product p : products) {
                writer.write(p.getQuantity() + " x " +
                        p.getDescription() + " -$" + String.format("%.2f",p.getPrice()) + "\n");
            }
                writer.write("----------------------");
               writer.write("Total: $" + String.format("%.2f", getTotal()) + "\n");
            System.out.println("Receipt saved as: " + fileName);
            displayOrder();
        } catch (IOException e) {
            System.out.println("Error saving receipt" + e.getMessage());
        }
    }



}
