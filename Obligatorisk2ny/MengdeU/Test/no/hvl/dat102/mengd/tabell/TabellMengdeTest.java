package no.hvl.dat102.mengd.tabell;

import no.hvl.dat102.mengd.adt.MengdeADTTest;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class TabellMengdeTest extends MengdeADTTest {

	@Override
	protected MengdeADT<Integer> reset() {
		return new TabellMengde<Integer>();
	}

}
