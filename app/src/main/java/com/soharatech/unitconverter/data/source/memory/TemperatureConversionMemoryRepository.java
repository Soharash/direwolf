package com.soharatech.unitconverter.data.source.memory;

import android.util.Pair;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;

import java.util.ArrayList;
import java.util.List;

public class TemperatureConversionMemoryRepository implements ConversionMemoryRepositoryContract{
	
	private List<Conversion> mConversions;
	private List<Unit> mUnits;
	
	
	public TemperatureConversionMemoryRepository(){
		mConversions = new ArrayList<>();
		mUnits = (new TemperatureUnitMemoryRepository()).getAll();
		mConversions.add(new Conversion(mUnits.get(0), mUnits.get(1), 9d / 5, 32d));
	}
	
	
	@Override
	public List<Conversion> getAll(){
		return mConversions;
	}
	
	
	@Override
	public Conversion create(){
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public Conversion get(Pair<Unit, Unit> k){
		for(int i = 0; i < mConversions.size(); i++){
			if((mConversions.get(i).getFrom().getId() == k.first.getId() && mConversions.get(i).getTo().getId() == k.second.getId())
					|| (mConversions.get(i).getFrom().getId() == k.second.getId() && mConversions.get(i).getTo().getId() == k.first.getId())){
				return mConversions.get(i);
			}
		}
		throw new NullPointerException();
	}
	
	
	@Override
	public Conversion update(Conversion conversion){
		throw new UnsupportedOperationException();
	}
}
