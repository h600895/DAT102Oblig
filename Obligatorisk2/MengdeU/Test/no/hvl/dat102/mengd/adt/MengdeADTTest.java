package no.hvl.dat102.mengd.adt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;

public abstract class MengdeADTTest {

	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> fasit;

	//Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;
	private Integer e7 = 8;
	private Integer e8 = 9;
	private Integer e9 = 10;

	protected abstract MengdeADT<Integer> reset();

	@BeforeEach
	public final void setup() {
		m1 = reset();
		m2 = reset();
		fasit = reset();
	}

	@Test
	void testUnionDisjunkte() {
		fasit.leggTil(e0);
		fasit.leggTil(e1);
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		fasit.leggTil(e4);
		fasit.leggTil(e5);
		fasit.leggTil(e6);
		fasit.leggTil(e7);
		fasit.leggTil(e8);
		fasit.leggTil(e9);

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		m2.leggTil(e7);
		m2.leggTil(e8);
		m2.leggTil(e9);
		MengdeADT<Integer> begge = m1.union(m2);
		assertTrue(fasit.equals(begge));
	}

	@Test
	void testUnionFelles() {
		fasit.leggTil(e0);
		fasit.leggTil(e1);
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		fasit.leggTil(e4);
		fasit.leggTil(e5);
		fasit.leggTil(e6);

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		MengdeADT<Integer> begge = m1.union(m2);
		assertTrue(fasit.equals(begge));
	}

	@Test
	void testSnittDisjunkte() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		m2.leggTil(e7);
		m2.leggTil(e8);
		m2.leggTil(e9);
		MengdeADT<Integer> snitt = m1.snitt(m2);
		assertTrue(fasit.equals(snitt));
	}
	@Test
	void testSnittFelles() {
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		fasit.leggTil(e4);

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		MengdeADT<Integer> snitt = m1.snitt(m2);
		assertTrue(fasit.equals(snitt));
	}

	@Test
	void testDifferensDisjunkt() {
		fasit.leggTil(e0);
		fasit.leggTil(e1);
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		fasit.leggTil(e4);

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		m2.leggTil(e7);
		m2.leggTil(e8);
		m2.leggTil(e9);
		MengdeADT<Integer> differens = m1.differens(m2);
		assertTrue(fasit.equals(differens));
	}
	@Test
	void testDifferensFelles() {
		fasit.leggTil(e0);
		fasit.leggTil(e1);

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		MengdeADT<Integer> differens = m1.differens(m2);
		assertTrue(fasit.equals(differens));
	}
}
