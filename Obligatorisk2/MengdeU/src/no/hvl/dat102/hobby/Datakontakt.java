package no.hvl.dat102.hobby;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.klient.Medlem;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private TabellMengde<Medlem> medlemTab;
	
	public TabellMengde<Medlem> getMedlemTab() {
		return medlemTab;
	}

	public void setMedlemTab(TabellMengde<Medlem> medlemTab) {
		this.medlemTab = medlemTab;
	}

	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}

	public void setAntallMedlemmer(int antallMedlemmer) {
		this.antallMedlemmer = antallMedlemmer;
	}

	private int antallMedlemmer;
	
	public Datakontakt (TabellMengde<Medlem> medlemTab) {
		this.medlemTab = medlemTab;
		this.antallMedlemmer = medlemTab.antall();
	}//end constructor
	
	public void leggTilMedlem (Medlem person) {
		//Legger til et ny medlem i medlemstabellen
		this.medlemTab.leggTil(person);
		antallMedlemmer++;
	}//end leggTilMedlem
	
	public Medlem finnMedlemMedNavn (String medlemsnavn) {
		//Hjelpemetode som finner medlem med gitt navn i tabellmengden
		for(Medlem m : medlemTab) {
			if(m.getNavn() == medlemsnavn) {
				return m;
			}
		}
		return null;
	}//end finnMedlemMedNavn
	
	public int finnMedlemsIndeks(String medlemsnavn) {
		int indeks = -1;
		int iterator = 0;
		for(Medlem m : medlemTab) {
			if(m.getNavn() == medlemsnavn) {
				indeks = iterator;
				break;
			}
			iterator++;
		}
		return indeks;
	}//finnMedlemsIndeks
	
	public Medlem finnMedlemMedIndeks(int statusIndeks) {
		int indeks = -1;
		int iterator = 0;
		for(Medlem m : medlemTab) {
			if(iterator == statusIndeks) {
				return m;
			}
			iterator++;
		}
		return null;
	}//finnMedlemMedIndeks
	
	
	public int finnPartnerFor (String medlemsnavn) {
		//Sjekker om et medlem passer med et annet, de passer hvis de har samme hobbyer og ikke er
		//koblet fra foer.
		//StatusIndeks blir satt til indeksen til partneren
		int indeks = -1;
		Medlem medlem = finnMedlemMedNavn(medlemsnavn);
		if (medlem.getStatusIndeks() != -1) {
			return indeks;
		} else {
			int iterator = 0;
			for(Medlem m : medlemTab) {
				if(m.getStatusIndeks() == -1 && m.passerTil(medlem) && m != medlem) {
					m.setStatusIndeks(finnMedlemsIndeks(medlem.getNavn()));
					medlem.setStatusIndeks(finnMedlemsIndeks(m.getNavn()));
					indeks = iterator;
					break;
				}
				iterator++;
			}
		}
		return indeks;
	}//end finnPartnerFor
	
	public void tilbakestillStatusIndeks (String medlemsnavn) {
		//bryt koblingen mellom to medlemmer
		Medlem medlem = finnMedlemMedNavn(medlemsnavn);
		if(medlem.getStatusIndeks() != -1) {
			for(Medlem m : medlemTab) {
				if(m.getStatusIndeks() == finnMedlemsIndeks(medlemsnavn)) {
					m.setStatusIndeks(-1);
					medlem.setStatusIndeks(-1);
				}
			}
		}
	}
}
