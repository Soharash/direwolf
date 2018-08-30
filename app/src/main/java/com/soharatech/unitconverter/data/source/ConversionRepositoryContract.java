package com.soharatech.unitconverter.data.source;

import android.util.Pair;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;

public interface ConversionRepositoryContract extends Repository<Conversion, Pair<Unit, Unit>>{
	
}
