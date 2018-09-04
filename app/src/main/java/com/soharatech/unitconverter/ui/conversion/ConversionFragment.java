package com.soharatech.unitconverter.ui.conversion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soharatech.unitconverter.R;

public class ConversionFragment extends Fragment implements ConversionContract.View{
	
	private ConversionContract.Presenter mPresenter;
	
	
	static ConversionFragment newInstance(){
		ConversionFragment conversionFrag = new ConversionFragment();
		return conversionFrag;
	}
	
	
	@Nullable
	@Override
	public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
										  @Nullable Bundle savedInstanceState){
		View mainView = inflater.inflate(R.layout.conversion_frag, container, false);
		return mainView;
	}
	
	
	@Override
	public void onResume(){
		super.onResume();
		mPresenter.start();
	}
	
	
	@Override
	public void setPresenter(ConversionContract.Presenter presenter){
		mPresenter = presenter;
	}
}
