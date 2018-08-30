package com.soharatech.unitconverter.data;

import java.util.Map;

public class Converter{
	
	Map<Unit, Map<Unit, Double>> mRates;
	
	
	public Converter(Map<Unit, Map<Unit, Double>> rates){
		mRates = rates;
	}
	
	
	public double convert(double measure, Unit from, Unit to){
		return measure * (mRates.get(from).get(to)) * to.getRate() / from.getRate();
	}
}
