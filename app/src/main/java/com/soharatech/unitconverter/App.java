package com.soharatech.unitconverter;

import android.app.Application;

public class App extends Application{
	
	private static App sInstance;
	
	
	public App getsInstance(){
		return sInstance;
	}
	
	
	@Override
	public void onCreate(){
		super.onCreate();
		sInstance = this;
	}
}
