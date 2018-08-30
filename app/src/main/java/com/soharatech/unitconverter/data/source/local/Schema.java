package com.soharatech.unitconverter.data.source.local;

class Schema{
	
	final static class CategorySchema{
		
		static final String TABLE_NAME = "categories";
		static final String CATEGORY = "category";
	}
	
	
	final static class UnitSchema{
		
		static final String ID = "_id";
		static final String NAME = "name";
		static final String ABBRIVATION = "abbrivation";
		static final String RATE = "rate";
		static final String PRIME_ID = "primeId";
	}
	
	
	final static class ConversionSchema{
		
		static final String FROM = "source";
		static final String TO = "destination";
		static final String RATE = "rate";
	}
}
