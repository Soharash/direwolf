package com.soharatech.unitconverter.ui.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.soharatech.unitconverter.R;
import com.soharatech.unitconverter.data.source.CategoryRepository;
import com.soharatech.unitconverter.ui.BaseActivity;

public class CategoryActivity extends BaseActivity{
	
	private CategoryContract.FragPresenter mCategoryFragPresenter;
	private DrawerLayout mDrawerLayout;
	private ViewPager mViewPager;
	private TabLayout mTabLayout;
	
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_act);
		// toolbar
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar ab = getSupportActionBar();
		assert ab != null;
		ab.setDisplayShowHomeEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		
		// drawer layout
		mDrawerLayout = findViewById(R.id.drawer_layout);
		if(mDrawerLayout != null){
			NavigationView navView = findViewById(R.id.nav_view);
			setupDrawerContent(navView);
			ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
					toolbar, R.string.dummy_desc, R.string.dummy_desc){
				public void onDrawerClosed(View view){
					supportInvalidateOptionsMenu();
				}
				
				
				public void onDrawerOpened(View drawerView){
					supportInvalidateOptionsMenu();
				}
			};
			drawerToggle.setDrawerIndicatorEnabled(true);
			mDrawerLayout.addDrawerListener(drawerToggle);
			drawerToggle.syncState();
		}
		
		mCategoryFragPresenter = new CategoryFragPresenter(new CategoryRepository(this));
		
		mViewPager = findViewById(R.id.view_pager);
		setupViewPager();
		
		mTabLayout = findViewById(R.id.tabs);
		mTabLayout.setupWithViewPager(mViewPager);
	}
	
	
	private void setupViewPager(){
		
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
		
		CategoryFragment allCategoryFragment = CategoryFragment.newInstance(CategoryFragment.ALL);
		mCategoryFragPresenter.putView(CategoryFragment.ALL, allCategoryFragment);
		viewPagerAdapter.addFragment(allCategoryFragment, "ALL");
		
		CategoryFragment favCategoryFragment = CategoryFragment.newInstance(CategoryFragment.FAVORITE);
		mCategoryFragPresenter.putView(CategoryFragment.FAVORITE, favCategoryFragment);
		viewPagerAdapter.addFragment(favCategoryFragment, "FAVORITES");
		
		CategoryFragment recentCategoryFragment = CategoryFragment.newInstance(CategoryFragment.RECENT);
		mCategoryFragPresenter.putView(CategoryFragment.RECENT, recentCategoryFragment);
		viewPagerAdapter.addFragment(recentCategoryFragment, "RECENT");
		
		mViewPager.setAdapter(viewPagerAdapter);
	}
	
	
	private void setupDrawerContent(NavigationView navView){
		navView.setNavigationItemSelectedListener(
				new NavigationView.OnNavigationItemSelectedListener(){
					@Override
					public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
						// TODO: setup actions for navigation view
						return false;
					}
				});
	}
}
