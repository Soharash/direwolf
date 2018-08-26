package com.soharatech.unitconverter.models;

import java.util.Map;

public class Converter {

    Map<Unit, Map<Unit, Double>> rates;

    public Converter(Map<Unit, Map<Unit, Double>> rates) {
        this.rates = rates;
    }

    public double convert(double measure, Unit from, Unit to) {
        return measure * (rates.get(from).get(to)) * to.getRate() / from.getRate();
    }
}
