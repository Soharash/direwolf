package com.soharatech.unitconverter.data;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Converter{
	
	Map<Unit, Map<Unit, Double>> mRates;
	
	
	public Converter(){
	}
	
	
	public Converter(Map<Unit, Map<Unit, Double>> rates){
		mRates = rates;
	}
	
	
	public double convert(double measure, Unit from, Unit to){
		double primeRate = 0;
		if(mRates.containsKey(from) && mRates.get(from).containsKey(to)){
			primeRate = mRates.get(from).get(to);
		} else{
			primeRate = 1.0 / mRates.get(to).get(from);
		}
		return measure * primeRate * to.getRate() / from.getRate();
	}
	
	
	public void inflate(List<Conversion> conversions){
		mRates = new TreeMap<>();
		for(Conversion conversion : conversions){
			if(!mRates.containsKey(conversion.getFrom())){
				mRates.put(conversion.getFrom(), new TreeMap<Unit, Double>());
			}
			mRates.get(conversion.getFrom()).put(conversion.getTo(), conversion.getRate());
		}
	}
}
