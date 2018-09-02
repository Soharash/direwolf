package com.soharatech.unitconverter.ui;

public interface MultiPresenter<T>{
	
	void start(String type);
	void putView(String type, T t);
}
