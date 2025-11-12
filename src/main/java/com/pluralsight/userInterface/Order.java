package com.pluralsight.userInterface;

import com.pluralsight.order.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>(); //store pizzas,drinks
    private LocalDateTime ordertime;

    //constructor
    public Order() {
        this.ordertime = LocalDateTime.now();
    }

    //add items

    public void addProduct(Product product) {
        products.add(product);
    }

    //get all products
    public List<Product> getProducts() {
        return products;
    }

    //total price
    public double getTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void displayOrder() {
        System.out.println("\n ---------- Order total -------");

        products.forEach(product ->
                System.out.println(product.getQuantity() +
                        " x " + product.getDescription() +
                        " - $" + String.format("%.2f", product.getPrice())));


        System.out.println("------------------------------");
        System.out.println("Total: $" + String.format("%.2f", getTotal()));
    }

    public void saveReceipt() {
        //create time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String time = LocalDateTime.now().format(formatter);

        // try saving to file
        String fileName = "receipts/" + time + ".txt"; //create file name

        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(" ────────────────────────────────── Papa's Pizzeria⋆⋅☆⋅⋆ Receipt ──────────────────");
            writer.write("Oder time: " + time );

            //
            writer.write(this.toString());

            writer.write("\n  ─────────────────────────────────────────⋆⋅☆⋅⋆ ────────────────────────────────");
            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt");
        }


    }
}

