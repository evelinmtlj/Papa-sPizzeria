package com.pluralsight;

public class Sauce {
    private String name;
    private boolean isPremium;
    private double extraPrice;


    public Sauce(String name, boolean isPremium, double extraPrice) {
        this.name = name;
        this.isPremium = isPremium;
        this.extraPrice = extraPrice;
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
