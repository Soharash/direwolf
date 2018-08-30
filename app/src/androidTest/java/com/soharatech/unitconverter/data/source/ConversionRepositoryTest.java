package com.soharatech.unitconverter.data.source;

import android.support.test.InstrumentationRegistry;
import android.util.Pair;

import com.soharatech.unitconverter.data.Conversion;
import com.soharatech.unitconverter.data.Unit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class ConversionRepositoryTest{
	
	private ConversionRepository mConversionRepository;
	
	
	@Before
	public void setupConverionRepository(){
		mConversionRepository = new ConversionRepository(InstrumentationRegistry.getTargetContext(),
				"length");
	}
	
	
	@Test
	public void getAll(){
		List<Conversion> conversions = mConversionRepository.getAll();
		assertEquals(1, conversions.size());
		assertEquals(39.37007874, conversions.get(0).getRate(), 0);
		assertEquals(3, conversions.get(0).getFrom().getId());
		assertEquals(9, conversions.get(0).getTo().getId());
	}
	
	
	@Test
	public void get(){
		Unit a = new Unit(3, 0, "", "", null);
		Unit b = new Unit(9, 0, "", "", null);
		Conversion conversion = mConversionRepository.get(new Pair<>(a, b));
		assertEquals(39.37007874, conversion.getRate(), 0);
		assertEquals(3, conversion.getFrom().getId());
		assertEquals(9, conversion.getTo().getId());
		// in reverse answer must be the same
		conversion = mConversionRepository.get(new Pair<>(b, a));
		assertEquals(39.37007874, conversion.getRate(), 0);
		assertEquals(3, conversion.getFrom().getId());
		assertEquals(9, conversion.getTo().getId());
	}
}
