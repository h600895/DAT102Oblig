package no.hvl.dat102.hobby;

import java.util.Scanner;

import no.hvl.dat102.hobby.Datakontakt;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.hobby.Hobby;
import no.hvl.dat102.hobby.Medlem;
import no.hvl.dat102.hobby.Tekstgrensesnitt;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Tekstgrensesnitt extends Datakontakt{
	public static void main (String[] args) {
		MengdeADT<Hobby> hobbyMengde1 = new TabellMengde<>();
		MengdeADT<Hobby> hobbyMengde2 = new TabellMengde<>();
		
		hobbyMengde1.leggTil(new Hobby("tegne"));
		hobbyMengde1.leggTil(new Hobby("male"));
		hobbyMengde2.leggTil(new Hobby("bryting"));
		hobbyMengde2.leggTil(new Hobby("ski"));
		
		Medlem nora = new Medlem("Nora", hobbyMengde1);
		Medlem oda = new Medlem("Oda", hobbyMengde1);
		Medlem siri = new Medlem("Siri", hobbyMengde2);
		Medlem aurora = new Medlem("Aurora", hobbyMengde2);
		
		TabellMengde<Medlem> medlemTab = new TabellMengde<>();
		medlemTab.leggTil(nora);
		medlemTab.leggTil(oda);
		medlemTab.leggTil(siri);
		medlemTab.leggTil(aurora);
		
		Datakontakt kontakt = new Datakontakt(medlemTab);
		kontakt.finnPartnerFor("Nora");
		medlemData(nora);
		medlemData(siri);
		//kontakt.tilbakestillStatusIndeks("Oda");
		medlemData(oda);
		Tekstgrensesnitt.skrivParListe(kontakt);
		

	}
	public static void medlemData(Medlem medlem) {
		System.out.println(medlem.toString());
	}
	
	public Tekstgrensesnitt(TabellMengde<Medlem> medlemTab) {
		super(medlemTab);
		// TODO Auto-generated constructor stub
	}

	public Medlem lesMedlem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Skriv inn navn på medlem: ");
		
		String medlemNavn = sc.nextLine();
		return finnMedlemMedNavn(medlemNavn);
	}
	
	public static void skrivParListe (Datakontakt arkiv) {
		//skriver ut en oversikt over medlemmer som er koblet til hverandre til enhver tid
		//Et par skal vises samlet, med hobbyer etterpå.
		TabellMengde<Medlem> hjelper = new TabellMengde<Medlem>();
		String parListe = "PARNAVN" + "\t\t" + "HOBBYER" + "\n";
		int teller = 0;
		for(Medlem m : arkiv.getMedlemTab()) {
			if(m.getStatusIndeks() != -1 && !hjelper.inneholder(m)) {
				Medlem h = 	arkiv.finnMedlemMedIndeks(m.getStatusIndeks());
				hjelper.leggTil(h);
				teller++;
				parListe += m.getNavn() + " og " + h.getNavn() + "\t" + m.getHobbyer().toString() + "\n";
			}
		}
		parListe += "Antall par funnet: " + teller;
		System.out.println(parListe);
	}
}
