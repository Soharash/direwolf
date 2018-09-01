package com.soharatech.unitconverter.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.soharatech.unitconverter.data.source.CategoryRepositoryContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategorySqliteRepository implements CategoryRepositoryContract{
	
	private SQLiteDatabase mReadable;
	
	
	public CategorySqliteRepository(Context ctx){
		DatabaseHelper db = new DatabaseHelper(ctx);
		mReadable = db.getReadableDatabase();
	}
	
	
	@Override
	public List<String> getAll(){
		List<String> categories = new ArrayList<>();
		String format = "select *\n" +
				"from %s";
		String query = String.format(Locale.US, format, Schema.CategorySchema.TABLE_NAME);
		Cursor c = mReadable.rawQuery(query, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			String category = c.getString(c.getColumnIndex(Schema.CategorySchema.CATEGORY));
			categories.add(category);
			c.moveToNext();
		}
		c.close();
		return categories;
	}
	
	
	@Override
	public String create(){
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public String get(String s){
		String category = null;
		String format = "select *\n" +
				"from %s\n" +
				"where %s = '%s'";
		String query = String.format(Locale.US, format,
				Schema.CategorySchema.TABLE_NAME,
				Schema.CategorySchema.CATEGORY, s);
		Cursor c = mReadable.rawQuery(query, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			category = c.getString(c.getColumnIndex(Schema.CategorySchema.CATEGORY));
			c.moveToNext();
		}
		c.close();
		return category;
	}
	
	
	@Override
	public String update(String s){
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public List<String> getAll(boolean favored){
		List<String> categories = new ArrayList<>();
		int favoredInDb = favored ? 1 : 0;
		String format = "select *\n" +
				"from %s\n" +
				"where %s = %d";
		String query = String.format(Locale.US, format,
				Schema.CategorySchema.TABLE_NAME, Schema.CategorySchema.FAVORED, favoredInDb);
		Cursor c = mReadable.rawQuery(query, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			categories.add(c.getString(c.getColumnIndex(Schema.CategorySchema.CATEGORY)));
			c.moveToNext();
		}
		c.close();
		return categories;
	}
	
	
	@Override
	public List<String> getRecentSorted(int max){
		return null;
	}
	
	
	@Override
	public void favor(boolean favored, String category){
	
	}
}
