package com.soharatech.unitconverter.data;

import android.support.annotation.NonNull;

public class Unit implements Comparable<Unit>{
	
	private int mId;
	private double nRate;
	private String mName;
	private String mAbbr;
	private Unit mPrime;
	
	
	public Unit(int id, double rate, String name, String abbr, Unit prime){
		mId = id;
		nRate = rate;
		mName = name;
		mAbbr = abbr;
		mPrime = prime;
	}
	
	
	public int getId(){
		return mId;
	}
	
	
	// TODO: can this function be removed?
	public void setId(int id){
		mId = id;
	}
	
	
	public double getRate(){
		return nRate;
	}
	
	
	public void setRate(double rate){
		nRate = rate;
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
	
	
	public boolean isPrime(){
		return mPrime != null;
	}
	
	
	@Override
	public String toString(){
		return String.valueOf(mName);
	}
	
	
	@Override
	public int compareTo(@NonNull Unit o){
		return o.getId() - getId();
	}
}
