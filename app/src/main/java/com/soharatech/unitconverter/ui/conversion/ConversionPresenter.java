package com.soharatech.unitconverter.ui.conversion;

import android.content.Context;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Converter;
import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.data.source.ConversionRepository;
import com.soharatech.unitconverter.data.source.UnitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class ConversionPresenter implements ConversionContract.Presenter{
	
	private ConversionRepository mConversionRepository;
	private UnitRepository mUnitRepository;
	private ConversionContract.View mConversionView;
	private String mCategory;
	private Converter mConverter;
	
	
	ConversionPresenter(Context ctx, ConversionContract.View view, String category){
		mCategory = category;
		mConversionRepository = new ConversionRepository(ctx, mCategory);
		mUnitRepository = new UnitRepository(ctx, mCategory);
		mConversionView = view;
		mConversionView.setPresenter(this);
		mConverter = new Converter();
		mConverter.inflate(mConversionRepository.getAll());
	}
	
	
	@Override
	public void start(){
		// TODO: add getAllNames to repository
		List<Unit> units = mUnitRepository.getAll();
		List<String> unitNames = new ArrayList<>();
		for(Unit unit : units){
			unitNames.add(unit.getName());
		}
		mConversionView.setUnitNames(unitNames);
	}
	
	
	@Override
	public void notifyDecimalChange(String decimal){
	
	}
	
	
	@Override
	public void notifyUnitChange(int position){
	
	}
	
	
	@Override
	public void notifyUnitChange(String unitName){
	
	}
}
