package com.soharatech.unitconverter.data;

public class Conversion{
	
	private Unit mFrom;
	private Unit mTo;
	private double mRate;
	
	
	public Conversion(Unit from, Unit to, Double rate){
		mFrom = from;
		mTo = to;
		mRate = rate;
	}
	
	
	public Unit getFrom(){
		return mFrom;
	}
	
	
	public void setFrom(Unit from){
		mFrom = from;
	}
	
	
	public Unit getTo(){
		return mTo;
	}
	
	
	public void setTo(Unit to){
		mTo = to;
	}
	
	
	public double getRate(){
		return mRate;
	}
	
	
	public void setRate(double rate){
		mRate = rate;
	}
}
