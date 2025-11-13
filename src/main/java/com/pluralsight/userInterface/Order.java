package com.pluralsight.userInterface;

import com.pluralsight.order.Product;

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
        System.out.println("\n ──────────────────⋆⋅Your ☆ Order⋅⋆──────────────────── ");


        products.forEach(product -> {
                    String line = String.format("%d  x %s  - $%.2f",
                            product.getQuantity(),
                            product.getDescription(),
                            product.getPrice());
            System.out.println("  " + line);
        });

        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("Total: $" + String.format("%.2f", getTotal()));
    }

    public void clearOrder(){
        products.clear();
        ordertime = LocalDateTime.now();
    }

    public void saveReceipt() {
        //create time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String time = LocalDateTime.now().format(formatter);

        // try saving to file
        String fileName = "receipts/" + time + ".txt"; //create file name

        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(this.toString());
            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt");
        }

    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("\n════════════════════════════ Papa's Pizzeria⋆⋅☆⋅⋆ Receipt ════════════════════════════\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd - HH:mm:ss");
        receipt.append("Order time: ").append(ordertime.format(formatter)).append("\n");
        receipt.append("─────────────────────────────────────────────────────────────────────────────────────\n\n");

        //list all items
        for (Product p : products) {
            receipt.append(p.getDescription()).append("\n");
            receipt.append(String.format("Price: $%.2f\n\n", p.getPrice()));
        }
        receipt.append("─────────────────────────────────────────────────────────────────────────────────────\n");
        receipt.append(String.format("Total: $%.2f\n", getTotal()));
        receipt.append("═════════════════════════════════════════════════════════════════════════════════════\n");

        return receipt.toString();
    }
}

