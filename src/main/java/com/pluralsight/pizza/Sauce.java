package com.pluralsight.pizza;

public class Sauce {
    private String name;
    private boolean isPremium;
    private double extraPrice;

    public static String[] sauceOptions = {"Marinara", "Alfredo", "Pesto", "BBQ", "Buffalo", "Olive oil"};


    public Sauce(String name) {
        this.name = name;
        this.isPremium = false;
        this.extraPrice = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }

    @Override
    public String toString() {
        return name + (isPremium ? " (Premium)": "");
    }
}
