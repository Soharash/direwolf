package com.soharatech.unitconverter.ui.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
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
	
	private CategoryPresenter mCategoryPresenter;
	private DrawerLayout mDrawerLayout;
	private ViewPager mViewPager;
	private TabLayout mTabLayout;
	
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_act);
		// toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar ab = getSupportActionBar();
		ab.setDisplayShowHomeEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		
		// drawer layout
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		if(mDrawerLayout != null){
			NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
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
		
		mCategoryPresenter = new CategoryPresenter(new CategoryRepository(this));
		
		mViewPager = findViewById(R.id.view_pager);
		setupViewPager();
		
		mTabLayout = findViewById(R.id.tabs);
		mTabLayout.setupWithViewPager(mViewPager);

//		CategoryFragment categoryFrag = (CategoryFragment) getSupportFragmentManager().findFragmentById(
//				R.id.content_frame);
//		if(categoryFrag == null){
//			categoryFrag = CategoryFragment.newInstance();
//			ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), categoryFrag,
//					R.id.content_frame);
//		}

//		mCategoryPresenter = new CategoryPresenter(new CategoryRepository(this), categoryFrag);
	}
	
	
	private void setupViewPager(){
		
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
		
		CategoryFragment allCategoryFragment = CategoryFragment.newInstance(CategoryFragment.ALL);
		mCategoryPresenter.putView(CategoryFragment.ALL, allCategoryFragment);
		viewPagerAdapter.addFragment(allCategoryFragment, "ALL");
		
		CategoryFragment favCategoryFragment = CategoryFragment.newInstance(CategoryFragment.FAVORITE);
		mCategoryPresenter.putView(CategoryFragment.FAVORITE, favCategoryFragment);
		viewPagerAdapter.addFragment(favCategoryFragment, "FAVORITES");
		
		CategoryFragment recentCategoryFragment = CategoryFragment.newInstance(CategoryFragment.RECENT);
		mCategoryPresenter.putView(CategoryFragment.RECENT, recentCategoryFragment);
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
