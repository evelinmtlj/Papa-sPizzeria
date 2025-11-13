package com.pluralsight.pizza;

public class Crust {
    private String name;
    private boolean isStuffed;
    private double extraPrice;



   public static  String[] crustType = {" Thin", " Regular", " Thick", " Cauliflower"};



    public Crust(String name) {
        this.name = name;
        this.isStuffed = false;
        this.extraPrice = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStuffed() {
        return isStuffed;
    }

    public void setStuffed(boolean stuffed) {
        isStuffed = stuffed;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }

    @Override
    public String toString() {
        return name + (isStuffed ? "(Stuffed Crust)" : "" );

    }
}
