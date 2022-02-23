package no.hvl.dat102.hobby;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private MengdeADT<Medlem> medlemmer;
	private int antall;

	
	public Datakontakt() {
		antall = 0;
		medlemmer = new TabellMengde<Medlem>(); //Antar dette skal være en tabell og ikke kjedet.
	}
	
	public void leggTilMedlem(Medlem person) {
		medlemmer.leggTil(person);
	}
	public int finnMedlemsIndeks(String medlemsnavn) {
		Medlem medlem = finnMedlemMedNavn(medlemsnavn);
		if (medlem == null) {
			return -1;
		}
		return medlem.getStatusIndeks();
	}
	public int finnPartnerFor(String medlemsnavn) {
		
		Iterator<Medlem> teller = medlemmer.oppramser();
		Medlem element;
		while (teller.hasNext()) {
			element = teller.next();
			if (element.passerTil(element)) {
				
			}
		}
	}
	private Medlem finnMedlemMedNavn(String medlemsnavn) {
		Iterator<Medlem> medlemmerIt = medlemmer.oppramser();
		while (medlemmerIt.hasNext()) {
			Medlem m = medlemmerIt.next();
			if (m.getNavn().equals(medlemsnavn)) {
				return m;
			}
		}
		return null;
	}
}
