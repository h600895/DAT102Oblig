package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.exceptions.EmptyCollectionException;

import org.junit.jupiter.api.BeforeEach;

public abstract class KoeADTTest {
	//Referanse til koeObjektet
	private KoeADT<Integer> koe;
	
	//Testdata
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	protected abstract KoeADT<Integer> reset();
	
	/**
	 * Hent en ny stabel for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	@Test
	public void innOgUtOgForsteKoe() {
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e1, koe.foerste());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.foerste());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.foerste());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe filet uventet" + e.getMessage());
		}
	}
	@Test
	public void innOgUtKoeOgForsteDuplikat() {
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e1, koe.foerste());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.foerste());
			assertEquals(e2, koe.utKoe());
			assertEquals(e2, koe.foerste());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.foerste());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe filet uventet" + e.getMessage());
		}
	}
	@Test
	public void utOgErTom() {
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			System.out.println(koe.utKoe());
			//assertEquals(e1, koe.foerste());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe filet uventet" + e.getMessage());
		}
		assertTrue(koe.erTom());
	}
	@Test
	public void erIkkeTom() {
		koe.innKoe(e1);
		assertFalse(koe.erTom());
		koe.innKoe(e2);
		assertFalse(koe.erTom());
	}
	public void innUtErTom() {
		try {
			koe.innKoe(e1);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("Inn- eller ut- koe feilet uventet" + e.getMessage());
		}
	}
	public void utKoeEmptryIsUnderflowed() {
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
}
