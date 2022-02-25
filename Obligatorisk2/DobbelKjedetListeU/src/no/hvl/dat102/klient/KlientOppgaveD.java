package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;

public class KlientOppgaveD {

	public static void main(String[] args) {
		DobbelKjedetOrdnetListe<Integer> liste = new DobbelKjedetOrdnetListe<Integer>(0, 100);
		
		liste.leggTil(1);
		liste.leggTil(2);
		liste.leggTil(6);
		liste.leggTil(4);
		liste.leggTil(30);
		
		liste.visListe();
		
		liste.fjern(1);
		

	}

}
