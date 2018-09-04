package com.soharatech.unitconverter.ui.conversion;

import android.content.Context;

import com.soharatech.unitconverter.data.Conversion;
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
	
	
	ConversionPresenter(Context ctx, ConversionContract.View view, String category){
		mCategory = category;
		mConversionRepository = new ConversionRepository(ctx, mCategory);
		mUnitRepository = new UnitRepository(ctx, mCategory);
		mConversionView = view;
		mConversionView.setPresenter(this);
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
