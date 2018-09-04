package com.soharatech.unitconverter.ui.conversion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.soharatech.unitconverter.R;
import com.soharatech.unitconverter.ui.BaseActivity;
import com.soharatech.unitconverter.util.ActivityUtils;

public class ConversionActivity extends BaseActivity{
	
	public static final String CATEGORY_ARG = "category_argument";
	private ConversionContract.Presenter mConversionPresenter;
	
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conversion_act);
		String category = getIntent().getStringExtra(CATEGORY_ARG);
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar ab = getSupportActionBar();
		ab.setTitle(category);
		ab.setDisplayHomeAsUpEnabled(true);
		
		ConversionFragment conversionFrag = (ConversionFragment) getSupportFragmentManager().findFragmentById(
				R.id.conversion_content_frame);
		if(conversionFrag == null){
			conversionFrag = ConversionFragment.newInstance();
			ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), conversionFrag,
					R.id.conversion_content_frame);
		}
		
		mConversionPresenter = new ConversionPresenter(this, conversionFrag, category);
	}
}
