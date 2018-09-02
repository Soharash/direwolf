package com.soharatech.unitconverter.ui.category;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soharatech.unitconverter.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoryView>{
	
	private List<String> mDataSource = new ArrayList<>();
	
	
	void setDateSource(List<String> dataSource){
		mDataSource = dataSource;
		notifyDataSetChanged();
	}
	
	
	@NonNull
	@Override
	public CategoryView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_card, viewGroup, false);
		return new CategoryView(view);
	}
	
	
	@Override
	public void onBindViewHolder(@NonNull CategoryView categoryView, int i){
		categoryView.setText(mDataSource.get(i));
	}
	
	
	@Override
	public int getItemCount(){
		return mDataSource.size();
	}
}


class CategoryView extends RecyclerView.ViewHolder{
	
	private TextView mTextView;
	
	
	CategoryView(@NonNull View itemView){
		super(itemView);
		mTextView = itemView.findViewById(R.id.text_view);
	}
	
	
	public void setText(String str){
		mTextView.setText(str);
	}
}
