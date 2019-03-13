package com.soharatech.unitconverter.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.data.source.UnitRepositoryContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UnitSqliteRepository implements UnitRepositoryContract{
	
	private SQLiteDatabase mReadable;
	private String mType;
	
	
	public UnitSqliteRepository(Context ctx, String type){
		DatabaseHelper database = new DatabaseHelper(ctx);
		mReadable = database.getReadableDatabase();
		mType = type;
	}
	
	
	@Override
	public List<Unit> getAll(){
		List<Unit> units = new ArrayList<>();
		String format = "select * \n" +
				"from %s as u1 left join %s as u2 \n" +
				"where (u1.%s = u2.%s) OR (u1.%s is null AND u2.%s = u1.%s)";
		String query = String.format(format, mType, mType, Schema.UnitSchema.PRIME_ID,
				Schema.UnitSchema.ID, Schema.UnitSchema.PRIME_ID, Schema.UnitSchema.ID,
				Schema.UnitSchema.ID);
		Cursor c = mReadable.rawQuery(query, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			int id = c.getInt(0);
			String name = c.getString(1);
			String abbr = c.getString(2);
			Double rate = c.getDouble(3);
			Unit prime = null;
			int primeId = c.getInt(4);
			if(primeId > 0){
				primeId = c.getInt(6);
				String primeName = c.getString(7);
				String primeAbbr = c.getString(8);
				Double primeRate = c.getDouble(9);
				prime = new Unit(primeId, primeRate, primeName, primeAbbr, null);
			}
			
			Unit unit = new Unit(id, rate, name, abbr, prime);
			units.add(unit);
			c.moveToNext();
		}
		c.close();
		return units;
	}
	
	
	@Override
	public Unit create(){
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public Unit get(Integer k){
		Unit unit = null;
		String format = "select * \n" +
				"from %s as u1 left join %s as u2 \n" +
				"where (u1.%s = %d) and ((u1.%s = u2.%s) OR (u1.%s is null AND u2.%s = u1.%s))";
		String query = String.format(Locale.US, format, mType, mType,
				Schema.UnitSchema.ID, k,
				Schema.UnitSchema.PRIME_ID,
				Schema.UnitSchema.ID, Schema.UnitSchema.PRIME_ID, Schema.UnitSchema.ID,
				Schema.UnitSchema.ID);
		Cursor c = mReadable.rawQuery(query, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			int id = c.getInt(0);
			String name = c.getString(1);
			String abbr = c.getString(2);
			Double rate = c.getDouble(3);
			Unit prime = null;
			int primeId = c.getInt(4);
			if(primeId > 0){
				primeId = c.getInt(6);
				String primeName = c.getString(7);
				String primeAbbr = c.getString(8);
				Double primeRate = c.getDouble(9);
				prime = new Unit(primeId, primeRate, primeName, primeAbbr, null);
			}
			
			unit = new Unit(id, rate, name, abbr, prime);
			c.moveToNext();
		}
		c.close();
		return unit;
	}
	
	
	@Override
	public Unit update(Unit unit){
		throw new UnsupportedOperationException();
	}
}
