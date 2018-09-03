package com.soharatech.unitconverter.ui.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soharatech.unitconverter.R;

import java.util.List;

public class CategoryFragment extends Fragment implements CategoryContract.View{
	
	private static final String TYPE_ARG = "type";
	public static final String RECENT = "recent";
	public static final String FAVORITE = "favorite";
	public static final String ALL = "all";
	
	private String mType;
	private CategoryContract.FragPresenter mCategoryFragPresenter;
	private RecyclerView mRecyclerView;
	private CategoriesRecyclerViewAdapter mAdapter;
	
	
	static CategoryFragment newInstance(@NonNull String type){
		CategoryFragment frag = new CategoryFragment();
		Bundle args = new Bundle();
		args.putString(TYPE_ARG, type);
		frag.setArguments(args);
		return frag;
	}
	
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState){
		View mainView = inflater.inflate(R.layout.category_frag, container, false);
		assert getArguments() != null;
		mType = getArguments().getString(TYPE_ARG);
		mRecyclerView = mainView.findViewById(R.id.recycler_view_categoies);
		setupRecyclerView();
		return mainView;
	}
	
	
	@Override
	public void onResume(){
		super.onResume();
		mCategoryFragPresenter.start(mType);
	}
	
	
	private void setupRecyclerView(){
		mAdapter = new CategoriesRecyclerViewAdapter();
		RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mAdapter);
	}
	
	
	@Override
	public void setPresenter(CategoryContract.FragPresenter fragPresenter){
		mCategoryFragPresenter = fragPresenter;
	}
	
	
	@Override
	public void showCategories(List<String> categories){
		mAdapter.setDateSource(categories);
	}
	
	
	@Override
	public void showFilteredSearch(List<String> autoCompleted){
	
	}
}
