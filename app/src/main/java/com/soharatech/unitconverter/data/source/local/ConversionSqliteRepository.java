package com.soharatech.unitconverter.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;
import com.soharatech.unitconverter.data.source.ConversionRepositoryContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConversionSqliteRepository implements ConversionRepositoryContract{
	
	private SQLiteDatabase mReadable;
	private String mTableName;
	private String mType;
	
	
	public ConversionSqliteRepository(Context ctx, String type){
		DatabaseHelper db = new DatabaseHelper(ctx);
		mReadable = db.getReadableDatabase();
		mTableName = type + "Conversion";
		mType = type;
	}
	
	
	@Override
	public List<Conversion> getAll(){
		List<Conversion> conversions = new ArrayList<>();
		String format = "select * \n" +
				"from %s as u1 left join %s left join %s as u2 \n" +
				"where u1.%s = %s and u2.%s = %s";
		String query = String.format(format, mType, mTableName, mType,
				Schema.UnitSchema.ID, Schema.ConversionSchema.FROM,
				Schema.UnitSchema.ID, Schema.ConversionSchema.TO);
		Cursor c = mReadable.rawQuery(query, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			int srcId = c.getInt(0);
			String srcName = c.getString(1);
			String srcAbbr = c.getString(2);
			double srcRate = c.getDouble(3);
			double conversionRate = c.getDouble(7);
			int desId = c.getInt(8);
			String desName = c.getString(9);
			String desAbbr = c.getString(10);
			double desRate = c.getDouble(11);
			Unit src = new Unit(srcId, srcRate, srcName, srcAbbr, null);
			Unit des = new Unit(desId, desRate, desName, desAbbr, null);
			Conversion conversion = new Conversion(src, des, conversionRate);
			conversions.add(conversion);
			c.moveToNext();
		}
		c.close();
		return conversions;
	}
	
	
	@Override
	public Conversion create(){
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public Conversion get(Pair<Unit, Unit> k){
		Conversion conversion = null;
		String format = "select * \n" +
				"from %s as u1 left join %s left join %s as u2 \n" +
				"where u1.%s = %s and u2.%s = %s and ((u1.%s = %d and u2.%s = %d) or (u1.%s = %d and u2.%s = %d))";
		String query = String.format(Locale.US, format, mType, mTableName, mType,
				Schema.UnitSchema.ID, Schema.ConversionSchema.FROM,
				Schema.UnitSchema.ID, Schema.ConversionSchema.TO,
				Schema.UnitSchema.ID, k.first.getId(), Schema.UnitSchema.ID, k.second.getId(),
				Schema.UnitSchema.ID, k.second.getId(), Schema.UnitSchema.ID, k.first.getId());
		Cursor c = mReadable.rawQuery(query, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			int srcId = c.getInt(0);
			String srcName = c.getString(1);
			String srcAbbr = c.getString(2);
			double srcRate = c.getDouble(3);
			double conversionRate = c.getDouble(7);
			int desId = c.getInt(8);
			String desName = c.getString(9);
			String desAbbr = c.getString(10);
			double desRate = c.getDouble(11);
			Unit src = new Unit(srcId, srcRate, srcName, srcAbbr, null);
			Unit des = new Unit(desId, desRate, desName, desAbbr, null);
			conversion = new Conversion(src, des, conversionRate);
			c.moveToNext();
		}
		c.close();
		return conversion;
	}
	
	
	@Override
	public Conversion update(Conversion conversion){
		throw new UnsupportedOperationException();
	}
}
