package com.soharatech.unitconverter.ui.conversion;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soharatech.unitconverter.R;
import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;

import java.util.ArrayList;
import java.util.List;

class ConversionRecyclerViewAdapter extends RecyclerView.Adapter<ConversionView>{
	
	private List<Conversion> mDataSource = new ArrayList<>();
	
	
	@NonNull
	@Override
	public ConversionView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.conversion_recycler_row, viewGroup, false);
		return new ConversionView(view);
	}
	
	
	@Override
	public void onBindViewHolder(@NonNull ConversionView conversionView, int i){
		conversionView.setMeasure(mDataSource.get(i).getRate());
		conversionView.setUnitAbbr(mDataSource.get(i).getTo().getAbbr());
	}
	
	
	@Override
	public int getItemCount(){
		return mDataSource.size();
	}
	
	
	public void setDataSource(List<Conversion> dataSource){
		mDataSource = dataSource;
	}
}


class ConversionView extends RecyclerView.ViewHolder{
	
	private TextView mMeasure;
	private TextView mUnitAbbr;
	
	
	public ConversionView(@NonNull View itemView){
		super(itemView);
		mMeasure = itemView.findViewById(R.id.text_view_conversion_value);
		mUnitAbbr = itemView.findViewById(R.id.text_view_conversion_unit);
	}
	
	
	public void setMeasure(Double d){
		String measure = String.valueOf(d);
		mMeasure.setText(measure);
	}
	
	
	public void setUnitAbbr(String abbr){
		mUnitAbbr.setText(Html.fromHtml(abbr));
	}
}

