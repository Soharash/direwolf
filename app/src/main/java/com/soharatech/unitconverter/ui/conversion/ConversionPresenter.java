package com.soharatech.unitconverter.ui.conversion;

import android.content.Context;

import com.soharatech.unitconverter.data.Converter;
import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.data.source.ConversionRepository;
import com.soharatech.unitconverter.data.source.UnitRepository;

import java.util.ArrayList;
import java.util.List;

class ConversionPresenter implements ConversionContract.Presenter{
	
	private ConversionRepository mConversionRepository;
	private UnitRepository mUnitRepository;
	private ConversionContract.View mConversionView;
	private String mCategory;
	private Converter mConverter;
	private Unit mSourceUnit;
	private double mMeasure;
	private List<Unit> mUnits;
	
	
	ConversionPresenter(Context ctx, ConversionContract.View view, String category){
		mCategory = category;
		mConversionRepository = new ConversionRepository(ctx, mCategory);
		mUnitRepository = new UnitRepository(ctx, mCategory);
		mUnits = mUnitRepository.getAll();
		
		mConverter = new Converter();
		mConverter.setUnits(mUnits);
		mConverter.inflate(mConversionRepository.getAll());
		mSourceUnit = mUnits.get(0);
		mMeasure = 0;
		
		mConversionView = view;
		mConversionView.setPresenter(this);
	}
	
	
	@Override
	public void start(){
		// TODO: add getAllNames to repository
		List<String> unitNames = new ArrayList<>();
		for(Unit unit : mUnits){
			unitNames.add(unit.getName());
		}
		mConversionView.setUnitNames(unitNames);
	}
	
	
	@Override
	public void notifyDecimalChange(String decimal){
		if (decimal.equals("")){
			decimal = "0";
		}
		mMeasure = Double.valueOf(decimal);
		mConversionView.showConversions(mConverter.convertAll(mMeasure, mSourceUnit));
	}
	
	
	@Override
	public void notifyUnitChange(int position){
		mSourceUnit = mUnits.get(position);
		mConversionView.showConversions(mConverter.convertAll(mMeasure, mSourceUnit));
	}
	
	
	@Override
	public void notifyUnitChange(String unitName){
	
	}
}
