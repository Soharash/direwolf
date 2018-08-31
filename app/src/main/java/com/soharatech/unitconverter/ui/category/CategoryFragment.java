package com.soharatech.unitconverter.ui.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
	private CategoryContract.Presenter mCategoryPresenter;
	private RecyclerView mRecyclerView;
	private CategoriesRecyclerViewAdapter mAdapter;
	private SearchView mSearchView;
	
	
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
		mType = getArguments().getString(TYPE_ARG);
		mRecyclerView = mainView.findViewById(R.id.recycler_view_categoies);
		setupRecyclerView();
		setHasOptionsMenu(true);
		return mainView;
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
		inflater.inflate(R.menu.menu_category_frag, menu);
//		mSearchView = (SearchView) menu.findItem(R.id.menu_search);
//
//		mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
//			@Override
//			public boolean onQueryTextSubmit(String s){
//				mCategoryPresenter.search(s);
//				return false;
//			}
//
//
//			@Override
//			public boolean onQueryTextChange(String s){
//				mCategoryPresenter.autoComplete(s);
//				return false;
//			}
//		});
	}
	
	
	@Override
	public void onResume(){
		super.onResume();
		mCategoryPresenter.start(mType);
	}
	
	
	private void setupRecyclerView(){
		mAdapter = new CategoriesRecyclerViewAdapter();
		RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mAdapter);
	}
	
	
	@Override
	public void setPresenter(CategoryContract.Presenter presenter){
		mCategoryPresenter = presenter;
	}
	
	
	@Override
	public void showCategories(List<String> categories){
		mAdapter.setDateSource(categories);
	}
	
	
	@Override
	public void showFilteredSearch(List<String> autoCompleted){
	
	}
}
