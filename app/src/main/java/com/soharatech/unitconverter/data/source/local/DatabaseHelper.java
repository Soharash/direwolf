package com.soharatech.unitconverter.data.source.local;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.soharatech.unitconverter.BuildConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class DatabaseHelper extends SQLiteOpenHelper{
	
	private Context mContext;
	private static int DB_VERSION = 3;
	private static String DB_NAME = "conversion.sqlite";
	@SuppressLint("SdCardPath")
	private static String DB_DIR = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases";
	private static String DB_PATH = DB_DIR + File.separator + DB_NAME;
	
	
	DatabaseHelper(Context context){
		super(context, DB_NAME, null, DB_VERSION);
		this.mContext = context;
		if(isDatabaseEmpty())
			createdatabase();
	}
	
	
	private void createdatabase(){
		if(isDatabaseEmpty()){
			this.getReadableDatabase(); // create database in data/data/application_id/databases
			copyDatabase();
		}
	}
	
	
	private boolean isDatabaseEmpty(){
		File databaseFile = new File(DB_PATH);
		return !databaseFile.exists();
	}
	
	
	private void copyDatabase(){
		try{
			InputStream input = mContext.getAssets()
					.open(DB_NAME); //Open your local mDatabase as the input stream
			OutputStream output = new FileOutputStream(
					DB_PATH); //Open the empty mDatabase as the output stream
			
			// transfer byte to inputfile to outputfile
			byte[] buffer = new byte[1024];
			int length;
			while((length = input.read(buffer)) > 0){
				output.write(buffer, 0, length);
			}
			
			//Close the streams
			output.flush();
			output.close();
			input.close();
		} catch(IOException e){
			// TODO: add firebase
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db){
		// no need to create db because it exists beforehand
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		if(oldVersion < newVersion){
			copyDatabase();
		}
	}
}
