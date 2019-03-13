package com.soharatech.unitconverter.data;

public class Conversion{
	
	private Unit mFrom;
	private Unit mTo;
	private double mRate;
	private double mOffset;
	
	
	public Conversion(Unit from, Unit to, Double rate){
		mFrom = from;
		mTo = to;
		mRate = rate;
		mOffset = 0;
	}
	
	
	public Conversion(Unit from, Unit to, Double rate, Double offset){
		this(from, to, rate);
		mOffset = offset;
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
	
	
	public double getOffset(){
		return mOffset;
	}
	
	
	public void setOffset(double offset){
		mOffset = offset;
	}
}
