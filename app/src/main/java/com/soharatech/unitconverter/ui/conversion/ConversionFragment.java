package com.soharatech.unitconverter.ui.conversion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.soharatech.unitconverter.R;
import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;

import java.util.ArrayList;
import java.util.List;

public class ConversionFragment extends Fragment implements ConversionContract.View{
	
	private ConversionContract.Presenter mPresenter;
	private RecyclerView mRecyclerView;
	private AppCompatEditText mEditText;
	private AppCompatSpinner mSpinner;
	private ArrayAdapter<String> mSpinnerAdapter;
	private ConversionRecyclerViewAdapter mRecyclerAdapter;
	
	
	static ConversionFragment newInstance(){
		ConversionFragment conversionFrag = new ConversionFragment();
		return conversionFrag;
	}
	
	
	@Nullable
	@Override
	public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
										  @Nullable Bundle savedInstanceState){
		View mainView = inflater.inflate(R.layout.conversion_frag, container, false);
		mRecyclerView = mainView.findViewById(R.id.recycler_view_conversion);
		setupRecyclerView();
		mEditText = mainView.findViewById(R.id.edit_text_source_value);
		setupEditText();
		mSpinner = mainView.findViewById(R.id.spinner_source_unit);
		setupSpinner();
		return mainView;
	}
	
	
	@Override
	public void onResume(){
		super.onResume();
		mPresenter.start();
	}
	
	
	private void setupRecyclerView(){
		mRecyclerAdapter = new ConversionRecyclerViewAdapter();
		mRecyclerView.setAdapter(mRecyclerAdapter);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
	}
	
	
	private void setupEditText(){
		mEditText.addTextChangedListener(new TextWatcher(){
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after){
			
			}
			
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count){
			
			}
			
			
			@Override
			public void afterTextChanged(Editable s){
				String decimal = s.toString();
				mPresenter.notifyDecimalChange(decimal);
			}
		});
	}
	
	
	private void setupSpinner(){
		setupSpinner(new ArrayList<String>());
	}
	
	
	private void setupSpinner(@NonNull List<String> units){
		mSpinnerAdapter = new ArrayAdapter<>(getContext(),
				android.R.layout.simple_spinner_item, units);
		mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(mSpinnerAdapter);
		mSpinnerAdapter.notifyDataSetChanged();
		mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
				mPresenter.notifyUnitChange(position);
			}
			
			
			@Override
			public void onNothingSelected(AdapterView<?> parent){
			
			}
		});
	}
	
	
	@Override
	public void setPresenter(ConversionContract.Presenter presenter){
		mPresenter = presenter;
	}
	
	
	@Override
	public void setUnitNames(List<String> unitNames){
		setupSpinner(unitNames);
	}
	
	
	@Override
	public void showConversions(List<Conversion> conversions){
		mRecyclerAdapter.setDataSource(conversions);
		mRecyclerAdapter.notifyDataSetChanged();
	}
}
