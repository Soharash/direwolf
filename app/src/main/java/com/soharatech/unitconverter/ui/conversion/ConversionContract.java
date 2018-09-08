package com.soharatech.unitconverter.ui.conversion;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.ui.BasePresenter;
import com.soharatech.unitconverter.ui.BaseView;

import java.util.List;

interface ConversionContract{
	
	interface View extends BaseView<Presenter>{
		
		void setUnitNames(List<String> unitNames);
		
		void showConversions(List<Conversion> conversions);
	}
	
	
	interface Presenter extends BasePresenter{
		
		void notifyDecimalChange(String decimal);
		
		void notifyUnitChange(int position);
		
		void notifyUnitChange(String unitName);
	}
}
