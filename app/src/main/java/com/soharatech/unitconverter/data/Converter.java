package com.soharatech.unitconverter.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Converter{
	
	Map<Unit, Map<Unit, Double>> mRates;
	Map<Unit, Map<Unit, Double>> mOffsets;
	Map<Unit, Boolean> mDirection;
	List<Unit> mUnits;
	
	
	public Converter(){
		mRates = new TreeMap<>();
		mOffsets = new TreeMap<>();
		mUnits = new ArrayList<>();
		mDirection = new TreeMap<>();
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
		boolean forwardConversion = true;
		double primeRate = 0;
		double primeOffset = 0;
		Unit fromPrime = from.getPrime() == null ? from : from.getPrime();
		Unit toPrime = to.getPrime() == null ? to : to.getPrime();
		if(mRates.containsKey(fromPrime) && mRates.get(fromPrime).containsKey(toPrime)){
			primeRate = mRates.get(fromPrime).get(toPrime);
			primeOffset = mOffsets.get(fromPrime).get(toPrime);
			forwardConversion = true;
		} else if(mRates.containsKey(toPrime) && mRates.get(toPrime).containsKey(fromPrime)){
			primeRate = 1.0 / mRates.get(toPrime).get(fromPrime);
			primeOffset = -mOffsets.get(toPrime).get(fromPrime);
			forwardConversion = false;
		} else{
			primeRate = 1;
			primeOffset = 0;
		}
		measure = from.getOrder() ? from.getRate() * measure + from.getOffset()
				: (measure + from.getOffset()) * from.getRate();
		measure = forwardConversion ? primeRate * measure + primeOffset
				: (measure + primeOffset) * primeRate;
		measure = to.getOrder() ? (measure - to.getOffset()) / to.getRate()
				: measure / to.getRate() - to.getOffset();
		return measure;
	}
	
	
	public void setUnits(List<Unit> units){
		mUnits = units;
	}
	
	
	public void inflate(List<Conversion> conversions){
		mRates = new TreeMap<>();
		for(Conversion conversion : conversions){
			if(!mRates.containsKey(conversion.getFrom())){
				mRates.put(conversion.getFrom(), new TreeMap<Unit, Double>());
				mOffsets.put(conversion.getFrom(), new TreeMap<Unit, Double>());
			}
			mRates.get(conversion.getFrom()).put(conversion.getTo(), conversion.getRate());
			mOffsets.get(conversion.getFrom()).put(conversion.getTo(), conversion.getOffset());
		}
	}
}
