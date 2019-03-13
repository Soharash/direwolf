package com.soharatech.unitconverter.data.source;

import android.support.test.InstrumentationRegistry;

import com.soharatech.unitconverter.data.Unit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class UnitRepositoryTest{
	
	private UnitRepository mUnitRepository;
	
	
	@Before
	public void setupUnitRepository(){
		mUnitRepository = new UnitRepository(InstrumentationRegistry.getTargetContext(), "length");
	}
	
	
	@Test
	public void getAll(){
		List<Unit> units = mUnitRepository.getAll();
		assertEquals(37, units.size());
		assertEquals(4, units.get(1).getId());
		assertTrue("centimeter".equals(units.get(1).getName()));
		assertTrue("cm".equals(units.get(1).getAbbr()));
		assertEquals(3, units.get(1).getPrime().getId());
		assertEquals(1.0, units.get(1).getPrime().getRate(), 0);
		assertNull(units.get(1).getPrime().getPrime());
		assertTrue("m".equals(units.get(1).getPrime().getAbbr()));
		assertTrue("meter".equals(units.get(1).getPrime().getName()));
		assertEquals(0.01, units.get(1).getRate(), 0);
	}
	
	
	@Test
	public void get(){
		Unit unit = mUnitRepository.get(10);
		assertEquals(10, unit.getId());
		assertTrue("foot".equals(unit.getName()));
		assertTrue("ft".equals(unit.getAbbr()));
		assertEquals(9, unit.getPrime().getId());
		assertEquals(1.0, unit.getPrime().getRate(), 0);
		assertNull(unit.getPrime().getPrime());
		assertTrue("in".equals(unit.getPrime().getAbbr()));
		assertTrue("inch".equals(unit.getPrime().getName()));
		assertEquals(12.0, unit.getRate(), 0);
	}
}
