package com.soharatech.unitconverter.ui.conversion;

import android.content.Context;

import com.soharatech.unitconverter.data.source.ConversionRepository;

class ConversionPresenter implements ConversionContract.Presenter{
	
	private ConversionRepository mConversionRepository;
	private ConversionContract.View mConversionView;
	private String mCategory;
	
	
	ConversionPresenter(Context ctx, ConversionContract.View view, String category){
		mCategory = category;
		mConversionRepository = new ConversionRepository(ctx, mCategory);
		mConversionView = view;
		mConversionView.setPresenter(this);
	}
	
	
	@Override
	public void start(){
	
	}
}
