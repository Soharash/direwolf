package com.soharatech.unitconverter.data.source.memory;

import com.soharatech.unitconverter.data.Unit;

import java.util.ArrayList;
import java.util.List;

public class TemperatureUnitMemoryRepository implements UnitMemoryRepositoryContract{
	
	private List<Unit> mUnits;
	
	
	public TemperatureUnitMemoryRepository(){
		mUnits = new ArrayList<>();
		mUnits.add(new Unit(0, 1, "Celsius", "°C", null, 0, true));
		mUnits.add(new Unit(1, 1, "Fahrenheit", "°F", null, 0, true));
		mUnits.add(new Unit(2, 1, "Kelvin", "K", mUnits.get(0), -273.15, true));
		mUnits.add(new Unit(3, 1, "Rankine", "°R", mUnits.get(1), -459.67, true));
		mUnits.add(new Unit(4, 40d / 21, "Rømer", "°Rø", mUnits.get(0), -7.5, false));
		mUnits.add(new Unit(5, 5d / 4, "Réaumur", "°Ré", mUnits.get(0), 0, true));
		mUnits.add(new Unit(6, -2d / 3, "Delisle", "°De", mUnits.get(0), 100, true));
	}
	
	
	@Override
	public List<Unit> getAll(){
		return mUnits;
	}
	
	
	@Override
	public Unit create(){
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public Unit get(Integer id){
		return mUnits.get(id);
	}
	
	
	@Override
	public Unit update(Unit unit){
		throw new UnsupportedOperationException();
	}
}
