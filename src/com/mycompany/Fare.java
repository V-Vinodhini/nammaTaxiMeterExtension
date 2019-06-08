package com.mycompany;

public class Fare {

    private final double km;
    private final double amt;

    Fare(double km, double amt) {

        this.km = km;
        this.amt = amt;
    }

    public double getKm() {
        return km;
    }

    public double getAmt() {
        return amt;
    }
}
