package no.hvl.dat102.tabell;

public class Main {

	public static void main(String[] args) {
		TabellOrdnetListe<Integer> liste = new TabellOrdnetListe<Integer>();
		for(int i = 1; i < 10; i++) {
			liste.leggTil(i);
		}
		System.out.println("Første element er: " + liste.foerste());
		System.out.println("Siste element er: " + liste.siste());
		System.out.println("Det er " + liste.antall() + " elementer i samlingen");
		

	}

}
