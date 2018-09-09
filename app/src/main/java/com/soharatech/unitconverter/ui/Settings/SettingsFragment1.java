package com.soharatech.unitconverter.ui.Settings;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.soharatech.unitconverter.R;

public class SettingsFragment1 extends PreferenceFragmentCompat{
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	
	@Override
	public void onCreatePreferences(Bundle bundle, String s){
		addPreferencesFromResource(R.xml.settings_1);
	}
}
