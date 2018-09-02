package com.soharatech.unitconverter.data.source;

import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryRepositoryTest{
	
	private CategoryRepository mCategoryRepository;
	
	
	@Before
	public void setupCategoryRepository(){
		mCategoryRepository = new CategoryRepository(InstrumentationRegistry.getTargetContext());
	}
	
	
	@Test
	public void getAll(){
		List<String> categories = mCategoryRepository.getAll();
		assertEquals(1, categories.size());
		assertTrue("length".equals(categories.get(0)));
	}
	
	
	@Test
	public void get(){
		String category = mCategoryRepository.get("length");
		assertTrue("length".equals(category));
	}
	
	
	@Test
	public void getAllFavored(){
		List<String> categories = mCategoryRepository.getAll();
		int all = categories.size();
		categories = mCategoryRepository.getAll(true);
		int favored = categories.size();
		categories = mCategoryRepository.getAll(false);
		int notFavored = categories.size();
		assertEquals(all, favored + notFavored);
	}
	
	
	@Test
	public void getLastSeen(){
		// TODO: write a test that is valid in all cases even after database changes.
//		List<String> categories = mCategoryRepository.getRecentSorted(2);
//		assertEquals(1, categories.size());
	}
}
