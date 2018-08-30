package com.soharatech.unitconverter.data.source;

import android.content.Context;

import com.soharatech.unitconverter.data.source.local.UnitSqliteRepository;
import com.soharatech.unitconverter.data.Unit;

import java.util.List;

public class UnitRepository implements UnitRepositoryContract{
	
	private UnitSqliteRepository mSqliteRepository;
	private String mTableName;
	
	
	public UnitRepository(Context ctx, String tableName){
		this.mTableName = tableName;
		mSqliteRepository = new UnitSqliteRepository(ctx, mTableName);
	}
	
	public String getTableName() {
		return mTableName;
	}
	
	
	@Override
	public List<Unit> getAll(){
		return mSqliteRepository.getAll();
	}
	
	
	@Override
	public Unit create(){
		return mSqliteRepository.create();
	}
	
	
	@Override
	public Unit get(Integer id){
		return mSqliteRepository.get(id);
	}
	
	
	@Override
	public Unit update(Unit unit){
		return mSqliteRepository.update(unit);
	}
}
