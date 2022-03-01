package no.hvl.dat102.klient;

import no.hvl.dat102.parentessjekker.Parentessjekk;

public class MainParantes {

	public static void main(String[] args) {
		Parentessjekk sjekker = new Parentessjekk();
		String string = "{[]}()([}){[()]}";
		boolean svar = sjekker.erBalansert(string);
		System.out.println(svar);
	}

}
