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
}
