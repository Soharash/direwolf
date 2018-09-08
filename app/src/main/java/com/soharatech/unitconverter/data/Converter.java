package com.soharatech.unitconverter.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Converter{
	
	Map<Unit, Map<Unit, Double>> mRates;
	List<Unit> mUnits;
	
	
	public Converter(){
		mRates = new TreeMap<>();
		mUnits = new ArrayList<>();
	}
	
	
	public Converter(Map<Unit, Map<Unit, Double>> rates){
		mRates = rates;
	}
	
	
	public List<Conversion> convertAll(double measure, Unit from){
		List<Conversion> conversions = new ArrayList<>();
		for(Unit unit : mUnits){
			double rate = convert(measure, from, unit);
			conversions.add(new Conversion(from, unit, rate));
		}
		return conversions;
	}
	
	
	public double convert(double measure, Unit from, Unit to){
		if(from.equals(to)){
			return measure;
		}
		double primeRate = 0;
		Unit fromPrime = from.getPrime() == null ? from : from.getPrime();
		Unit toPrime = to.getPrime() == null ? to : to.getPrime();
		if(mRates.containsKey(fromPrime) && mRates.get(fromPrime).containsKey(toPrime)){
			primeRate = mRates.get(fromPrime).get(toPrime);
		} else if(mRates.containsKey(toPrime) && mRates.get(toPrime).containsKey(fromPrime)){
			primeRate = 1.0 / mRates.get(toPrime).get(fromPrime);
		} else{
			primeRate = 1;
		}
		return measure * primeRate * from.getRate() / to.getRate();
	}
	
	
	public void setUnits(List<Unit> units){
		mUnits = units;
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
