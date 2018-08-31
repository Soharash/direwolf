package com.soharatech.unitconverter.ui.category;

import android.support.annotation.NonNull;

import com.soharatech.unitconverter.ui.BasePresenter;
import com.soharatech.unitconverter.ui.BaseView;
import com.soharatech.unitconverter.ui.MultiPresenter;

import java.util.List;

interface CategoryContract{
	
	interface View extends BaseView<Presenter>{
		
		void showCategories(List<String> categories);
		void showFilteredSearch(List<String> autoCompleted);
	}
	
	
	interface Presenter extends MultiPresenter{
		
		void autoComplete(String str);
		void search(String str);
		void loadCategories(String type);
		void openCategoryDetails(@NonNull String category);
	}
}
