package com.soharatech.unitconverter.data;

import android.support.annotation.NonNull;

public class Unit implements Comparable<Unit>{
	
	private int mId;
	private double mRate;
	private String mName;
	private String mAbbr;
	private Unit mPrime;
	private double mOffset;
	private boolean mOrder;
	
	
	public Unit(int id, double rate, String name, String abbr, Unit prime){
		mId = id;
		mRate = rate;
		mName = name;
		mAbbr = abbr;
		mPrime = prime;
		mOffset = 0;
		mOrder = true;
	}
	
	
	public Unit(int id, double rate, String name, String abbr, Unit prime, double offset, boolean order){
		this(id, rate, name, abbr, prime);
		mOffset = offset;
		mOrder = order;
	}
	
	
	public int getId(){
		return mId;
	}
	
	
	// TODO: can this function be removed?
	public void setId(int id){
		mId = id;
	}
	
	
	public double getRate(){
		return mRate;
	}
	
	
	public void setRate(double rate){
		mRate = rate;
	}
	
	
	public Unit getPrime(){
		return mPrime;
	}
	
	
	public void setPrime(Unit prime){
		this.mPrime = prime;
	}
	
	
	public String getName(){
		return mName;
	}
	
	
	public void setName(String name){
		this.mName = name;
	}
	
	
	public String getAbbr(){
		return mAbbr;
	}
	
	
	public void setAbbr(String abbr){
		this.mAbbr = abbr;
	}
	
	
	public double getOffset(){
		return mOffset;
	}
	
	
	public void setOffset(double offset){
		mOffset = offset;
	}
	
	
	public boolean getOrder(){
		return mOrder;
	}
	
	
	public void setOrder(boolean order){
		mOrder = order;
	}
	
	
	public boolean isPrime(){
		return mPrime != null;
	}
	
	
	@Override
	public String toString(){
		return String.valueOf(mName);
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(!obj.getClass().equals(Unit.class)){
			return false;
		}
		if(obj.hashCode() == hashCode()) return true;
		Unit unit = (Unit) obj;
		return unit.getId() == getId() &&
				unit.getName().equals(getName()) &&
				unit.getRate() == getRate() &&
				unit.getAbbr().equals(getAbbr()) &&
				unit.getPrime().equals(getPrime());
	}
	
	
	@Override
	public int compareTo(@NonNull Unit o){
		return o.getId() - getId();
	}
}
