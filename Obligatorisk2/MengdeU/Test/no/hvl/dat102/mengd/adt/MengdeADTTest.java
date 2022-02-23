package no.hvl.dat102.mengd.adt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public abstract class MengdeADTTest {
	
	private MengdeADT<Integer> mengde;
	private MengdeADT<Integer> mengde2;
	private MengdeADT<Integer> testMengde;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	private Integer e6 = 6;
	private Integer e7 = 7;
	private Integer e8 = 8;

	protected abstract MengdeADT<Integer> reset();
	
	@BeforeEach
	public void setup() {
		mengde = reset();
		mengde2 = reset();
		testMengde = reset();
	}
	
	@Test
	public void union() {
		//Tester den tomme mengden (100 tomme indexer)
		assertEquals(testMengde, mengde.union(mengde2));
		
		mengde.leggTil(e1);
		mengde.leggTil(e2);
		mengde.leggTil(e4);
		mengde2.leggTil(e2);
		mengde2.leggTil(e4);
		//UnionMengde
		testMengde.leggTil(e1);
		testMengde.leggTil(e2);
		testMengde.leggTil(e4);
		
		assertEquals(testMengde, mengde.union(mengde2));
		//Legger til et nytt element
		mengde.leggTil(e8);
		testMengde.leggTil(e8);
		assertEquals(testMengde, mengde.union(mengde2));
		
	}
	@Test
	public void snitt() {
		assertEquals(testMengde, mengde.snitt(mengde2));
		
		
		mengde.leggTil(e1);
		
		System.out.println(mengde.snitt(mengde2));
		assertEquals(testMengde, mengde.snitt(mengde2));
		
		mengde.leggTil(e2);
		mengde.leggTil(e3);
		mengde2.leggTil(e1);
		
		//TestMengde
		testMengde.leggTil(e1);
		assertEquals(testMengde, mengde.snitt(mengde2));
		mengde2.leggTil(e2);
		mengde2.leggTil(e6);
		testMengde.leggTil(e2);
		assertEquals(testMengde, mengde.snitt(mengde2));
	}
	@Test
	public void differns() {
		mengde.leggTil(e1);
		mengde.leggTil(e2);
		mengde.leggTil(e3);
		
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);
		
		//Testmengde
		testMengde.leggTil(e3);
		assertEquals(testMengde, mengde.differens(mengde2));
	}
	@Test
	public void underMengde() {
		assertTrue(mengde.undermengde(mengde2));
		mengde.leggTil(e1);
		mengde.leggTil(e2);
		mengde.leggTil(e3);
		
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);
		
		//System.out.println(mengde.undermengde(mengde2));
		assertTrue(mengde.undermengde(mengde2));
		mengde2.leggTil(e8);
		assertFalse(mengde.undermengde(mengde2));
		mengde.leggTil(e8);
		mengde.leggTil(e7);
		assertTrue(mengde.undermengde(mengde2));
	}
	
 }
