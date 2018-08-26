package com.soharatech.unitconverter.models;

public class Unit {

    private int id;
    private double rate;
    private String name;
    private String abbr;
    private Unit prime;

    public Unit(int id, double rate, String name, String abbr, Unit prime) {
        this.id = id;
        this.rate = rate;
        this.name = name;
        this.abbr = abbr;
        this.prime = prime;
    }

    public int getId() {
        return id;
    }

    // TODO: can this function be removed?
    public void setId(int id) {
        this.id = id;
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

    public boolean isPrime() {
        return prime != null;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
