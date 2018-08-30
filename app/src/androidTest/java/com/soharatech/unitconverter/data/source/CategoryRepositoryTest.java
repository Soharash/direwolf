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
}
