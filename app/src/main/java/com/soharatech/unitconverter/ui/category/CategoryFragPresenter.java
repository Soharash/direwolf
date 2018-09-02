package com.soharatech.unitconverter.ui.category;

import android.support.annotation.NonNull;

import com.soharatech.unitconverter.data.source.CategoryRepositoryContract;

import java.util.Map;
import java.util.TreeMap;

import static android.support.v4.util.Preconditions.checkNotNull;

public class CategoryFragPresenter implements CategoryContract.FragPresenter{
	
	private CategoryRepositoryContract mCategoryRepository;
	private Map<String, CategoryContract.View> mCategoryViews = new TreeMap<>();
	
	
	public CategoryFragPresenter(CategoryRepositoryContract categoryRepository){
		mCategoryRepository = categoryRepository;
	}
	
	
	@Override
	public void putView(String type, CategoryContract.View categoryView){
		mCategoryViews.put(type, categoryView);
		categoryView.setPresenter(this);
	}
	
	
	@Override
	public void start(String type){
		if(type.equals(CategoryFragment.ALL)){
			mCategoryViews.get(type).showCategories(mCategoryRepository.getAll());
		} else if(type.equals(CategoryFragment.FAVORITE)){
		
		} else if(type.equals(CategoryFragment.RECENT)){
		
		}
	}
	
	
	@Override
	public void loadCategories(String type){
	
	}
	
	
	@Override
	public void openCategoryDetails(@NonNull String category){
	
	}
}