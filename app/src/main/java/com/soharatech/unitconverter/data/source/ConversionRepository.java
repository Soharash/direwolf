package com.soharatech.unitconverter.data.source;

import android.content.Context;
import android.util.Pair;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.data.source.local.ConversionSqliteRepository;

import java.util.List;

public class ConversionRepository implements ConversionRepositoryContract{
	
	private ConversionSqliteRepository mSqliteRepository;
	private String mType;
	
	
	public ConversionRepository(Context ctx, String type){
		mType = type;
		mSqliteRepository = new ConversionSqliteRepository(ctx, mType);
	}
	
	
	@Override
	public List<Conversion> getAll(){
		return mSqliteRepository.getAll();
	}
	
	
	@Override
	public Conversion create(){
		return mSqliteRepository.create();
	}
	
	
	@Override
	public Conversion get(Pair<Unit, Unit> unitUnitPair){
		return mSqliteRepository.get(unitUnitPair);
	}
	
	
	@Override
	public Conversion update(Conversion conversion){
		return mSqliteRepository.update(conversion);
	}
}
