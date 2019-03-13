package com.soharatech.unitconverter.data.source;

import android.content.Context;
import android.util.Pair;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.data.source.local.ConversionSqliteRepository;
import com.soharatech.unitconverter.data.source.memory.TemperatureConversionMemoryRepository;

import java.util.List;

public class ConversionRepository implements ConversionRepositoryContract{
	
	private ConversionSqliteRepository mSqliteRepository;
	private ConversionRepositoryContract mMemoryRepository;
	private String mType;
	
	
	public ConversionRepository(Context ctx, String type){
		mType = type;
		if(mType.equals("temperature")){
			mMemoryRepository = new TemperatureConversionMemoryRepository();
		} else{
			mSqliteRepository = new ConversionSqliteRepository(ctx, mType);
		}
	}
	
	
	@Override
	public List<Conversion> getAll(){
		if(mSqliteRepository != null){
			return mSqliteRepository.getAll();
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.getAll();
		}
		return null;
	}
	
	
	@Override
	public Conversion create(){
		if(mSqliteRepository != null){
			return mSqliteRepository.create();
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.create();
		}
		return null;
	}
	
	
	@Override
	public Conversion get(Pair<Unit, Unit> unitUnitPair){
		if(mSqliteRepository != null){
			return mSqliteRepository.get(unitUnitPair);
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.get(unitUnitPair);
		}
		return null;
	}
	
	
	@Override
	public Conversion update(Conversion conversion){
		if(mSqliteRepository != null){
			return mSqliteRepository.update(conversion);
		}
		if(mMemoryRepository != null){
			return mMemoryRepository.update(conversion);
		}
		return null;
	}
}
