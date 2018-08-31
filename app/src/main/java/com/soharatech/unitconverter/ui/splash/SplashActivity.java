package com.soharatech.unitconverter.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.soharatech.unitconverter.ui.category.CategoryActivity;

public class SplashActivity extends AppCompatActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		Intent intent = new Intent(this, CategoryActivity.class);
		startActivity(intent);
		finish();
	}
}
