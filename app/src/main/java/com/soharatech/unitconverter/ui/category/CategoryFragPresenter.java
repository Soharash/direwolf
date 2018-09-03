package com.soharatech.unitconverter.ui.category;

import android.support.annotation.NonNull;

import com.soharatech.unitconverter.data.source.CategoryRepositoryContract;

import java.util.Map;
import java.util.TreeMap;

import static android.support.v4.util.Preconditions.checkNotNull;

public class CategoryFragPresenter implements CategoryContract.FragPresenter{
	
	private CategoryRepositoryContract mCategoryRepository;
	private Map<String, CategoryContract.View> mCategoryViews = new TreeMap<>();
	private static int sRecentMax = 100;
	
	
	public CategoryFragPresenter(CategoryRepositoryContract categoryRepository){
		mCategoryRepository = categoryRepository;
	}
	
	
	@Override
	public void putView(String type, CategoryContract.View categoryView){
		mCategoryViews.put(type, categoryView);
		categoryView.setPresenter(this);
	}
	
	
	public static void setRecentMax(int max){
		sRecentMax = max;
	}
	
	
	@Override
	public void start(String type){
		if(type.equals(CategoryFragment.ALL)){
			mCategoryViews.get(type).showCategories(mCategoryRepository.getAll());
		} else if(type.equals(CategoryFragment.FAVORITE)){
			mCategoryViews.get(type).showCategories(mCategoryRepository.getAll(true));
		} else if(type.equals(CategoryFragment.RECENT)){
			mCategoryViews.get(type).showCategories(mCategoryRepository.getRecentSorted(sRecentMax));
		}
	}
	
	
	@Override
	public void openCategoryDetails(@NonNull String category){
	
	}
}
