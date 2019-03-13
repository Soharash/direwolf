package com.soharatech.unitconverter.data.source;

import android.content.Context;

import com.soharatech.unitconverter.data.source.local.UnitSqliteRepository;
import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.data.source.memory.TemperatureUnitMemoryRepository;
import com.soharatech.unitconverter.data.source.memory.UnitMemoryRepositoryContract;

import java.util.List;

public class UnitRepository implements UnitRepositoryContract{
	
	private UnitSqliteRepository mSqliteRepository;
	private UnitMemoryRepositoryContract mMemoryRepository;
	private String mTableName;
	
	
	public UnitRepository(Context ctx, String tableName){
		this.mTableName = tableName;
		if(tableName.equals("temperature")){
			mMemoryRepository = new TemperatureUnitMemoryRepository();
		} else{
			mSqliteRepository = new UnitSqliteRepository(ctx, mTableName);
		}
	}
	
	
	public String getTableName(){
		return mTableName;
	}
	
	
	@Override
	public List<Unit> getAll(){
		if(mSqliteRepository != null){
			return mSqliteRepository.getAll();
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.getAll();
		}
		return null;
	}
	
	
	@Override
	public Unit create(){
		if(mSqliteRepository != null){
			return mSqliteRepository.create();
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.create();
		}
		return null;
	}
	
	
	@Override
	public Unit get(Integer id){
		if(mSqliteRepository != null){
			return mSqliteRepository.get(id);
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.get(id);
		}
		return null;
	}
	
	
	@Override
	public Unit update(Unit unit){
		if(mSqliteRepository != null){
			return mSqliteRepository.update(unit);
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.update(unit);
		}
		return null;
	}
}
