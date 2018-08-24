package com.soharatech.unitconverter.models;

import java.util.Map;

public class Converter {

    Map<String, Map<String, Double>> rates;

    public Converter(Map<String, Map<String, Double>> rates) {
        this.rates = rates;
    }

    public double convert(double measure, Unit from, Unit to) {
        return measure * (rates.get(from).get(to)) * to.getRate() / from.getRate();
    }
}
