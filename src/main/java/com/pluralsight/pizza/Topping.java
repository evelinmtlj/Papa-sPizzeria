package com.pluralsight.pizza;

public  class Topping {
    private String name;
    private String category;
    private boolean isPremium;
    private double extraPrice;

    public Topping(String name, String category, boolean isPremium) {
        this.name = name;
        this.category = category;
        this.isPremium = isPremium;
        this.extraPrice = extraPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        return name + ((isPremium) ? " (Premium) " : "");
    }
}
