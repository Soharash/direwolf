package com.soharatech.unitconverter.ui.Settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.soharatech.unitconverter.R;
import com.soharatech.unitconverter.ui.BaseActivity;
import com.soharatech.unitconverter.ui.conversion.ConversionFragment;
import com.soharatech.unitconverter.util.ActivityUtils;

import java.util.List;

public class SettingsActivity extends BaseActivity{
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_act);
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar ab = getSupportActionBar();
		ab.setTitle(R.string.settings_title);
		ab.setDisplayHomeAsUpEnabled(true);
		
		SettingsFragment1 settingsFrag = (SettingsFragment1) getSupportFragmentManager().findFragmentById(
				R.id.settings_content_frame);
		if(settingsFrag == null){
			settingsFrag = new SettingsFragment1();
			ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), settingsFrag,
					R.id.settings_content_frame);
		}
	}
}
