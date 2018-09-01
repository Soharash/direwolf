package com.soharatech.unitconverter.data.source;

import java.util.List;

public interface CategoryRepositoryContract extends Repository<String, String>{
	
	List<String> getAll(boolean favored);
	
	List<String> getRecentSorted(int max);
	
	void favor(boolean favored, String category);
}
