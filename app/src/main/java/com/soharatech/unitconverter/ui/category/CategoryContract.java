package com.soharatech.unitconverter.ui.category;

import android.support.annotation.NonNull;

import com.soharatech.unitconverter.ui.BasePresenter;
import com.soharatech.unitconverter.ui.BaseView;
import com.soharatech.unitconverter.ui.MultiPresenter;

import java.util.List;

interface CategoryContract{
	
	interface View extends BaseView<FragPresenter>{
		
		void showCategories(List<String> categories);
		void showConversionUi(String category);
	}
	
	
	interface FragPresenter extends MultiPresenter<View>{
		
		void categoryDetails(String type, @NonNull String category);
	}
	
	
	interface ActPresenter extends BasePresenter{
		
		void autoComplete(String str);
		void search(String str);
	}
}
