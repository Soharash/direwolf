package com.soharatech.unitconverter.data.source;

import java.util.List;

public interface Repository<T, K>{
	
	public List<T> getAll();
	public T create();
	public T get(K k);
	public T update(T t);
}
