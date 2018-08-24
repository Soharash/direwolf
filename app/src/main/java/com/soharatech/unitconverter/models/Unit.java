package com.soharatech.unitconverter.models;

public class Unit {

    private double rate;
    private String name;
    private String abbr;
    private Unit prime;

    public Unit(double rate, String name, String abbr, Unit prime) {
        this.rate = rate;
        this.name = name;
        this.abbr = abbr;
        this.prime = prime;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Unit getPrime() {
        return prime;
    }

    public void setPrime(Unit prime) {
        this.prime = prime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    boolean isPrime() {
        return prime != null;
    }

    @Override
    public String toString() {
        return abbr;
    }
}
