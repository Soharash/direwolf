package com.soharatech.unitconverter.data.source;

import android.content.Context;

import com.soharatech.unitconverter.data.source.local.CategorySqliteRepository;

import java.util.List;

public class CategoryRepository implements CategoryRepositoryContract{
	
	CategorySqliteRepository mSqliteRepository;
	
	
	public CategoryRepository(Context ctx){
		mSqliteRepository = new CategorySqliteRepository(ctx);
	}
	
	
	@Override
	public List<String> getAll(){
		return mSqliteRepository.getAll();
	}
	
	
	@Override
	public String create(){
		return mSqliteRepository.create();
	}
	
	
	@Override
	public String get(String s){
		return mSqliteRepository.get(s);
	}
	
	
	@Override
	public String update(String s){
		return mSqliteRepository.update(s);
	}
	
	
	/**
	 * return all categories that are favorite
	 * @param favored
	 */
	@Override
	public List<String> getAll(boolean favored){
		return mSqliteRepository.getAll(favored);
	}
	
	
	/**
	 * return recent categories sorted from last seen to first
	 * this method may return less than max number of categories
	 * @param max maximum number of recents returned
	 */
	@Override
	public List<String> getRecentSorted(int max){
		return mSqliteRepository.getRecentSorted(max);
	}
	
	
	@Override
	public void favor(boolean favored, String category){
		mSqliteRepository.favor(favored, category);
	}
}
