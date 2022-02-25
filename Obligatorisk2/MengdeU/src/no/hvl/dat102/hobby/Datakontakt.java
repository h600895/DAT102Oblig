package no.hvl.dat102.hobby;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private MengdeADT<Medlem> medlemmer;
	private int antall;
	private int indeksNr;

	
	public Datakontakt() {
		antall = 0;
		indeksNr = 0;
		medlemmer = new KjedetMengde<Medlem>();
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
		Medlem medlem = finnMedlemMedNavn(medlemsnavn);
		Iterator<Medlem> teller = medlemmer.oppramser();
		Medlem element;
		while(teller.hasNext()) {
			element = teller.next();
			if (medlem.passerTil(element)) {
				medlem.setStatusIndeks(indeksNr);
				element.setStatusIndeks(indeksNr);
				indeksNr++;
				return element.getStatusIndeks();
			}
		}
		return -1;
	}
	public void tilbakestillStatusIndeks(String medelmsnavn) {
		Medlem medlem = finnMedlemMedNavn(medelmsnavn);
		medlem.setStatusIndeks(-1);
		
	}
	
	//Lager en hjelpemetide som finner medlem med hjelp av navn.
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
