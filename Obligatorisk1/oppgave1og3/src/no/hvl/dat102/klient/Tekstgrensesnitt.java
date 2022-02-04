package no.hvl.dat102.klient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;


public class Tekstgrensesnitt {

	public Film lesFilm() { //Denne metoden håndterer ikke exceptions med å opprette objektet.

		Scanner input = new Scanner(System.in);
		System.out.print("Skriv inn informasjonen med komma som seperator: ");

		String inputen = input.nextLine();
		String[] split = inputen.split(", ");
		return new Film(Integer.parseInt(split[0]) , split[1], split[2], Integer.parseInt(split[3]), Sjanger.valueOf(split[4].toUpperCase()), split[5]);
	}
	public void visFilm(Film film) { 
		System.out.println(film);
	}
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmer = filma.soekTittel(delstreng);
		for (Film filmen: filmer) {
			visFilm(filmen);
		}
	}
	public void skrivUtProdusent(FilmarkivADT filma, String delstreng) {
		//Elendig og veldig lite effektiv måte:
		boolean funnet = false;
		if (filma.antall() > 0) {
			for (int i = 0; i < filma.antall(); i++) {
				Film filmen = filma.finnFilm(i);
				if (filmen != null) { //Kan ligge null-pekere i tabellen. Kan bruke try,catch.
					if (filmen.getProdusent().contains(delstreng)) {
						funnet = true;
						visFilm(filmen);
					}
				}
			}
			if (!funnet) {
				System.out.println("Fant ingen film med denne produsenten");
			}
		}
	}
	//skriv ut antall filmer og antall filmer i hver sjanger
    public void skrivUtStatistikk(FilmarkivADT filma){
        System.out.println("Totalt antall filmer: " + filma.antall());
        for (Sjanger sjanger : Sjanger.values()){
            System.out.println("Filmer av sjanger " + sjanger.toString() + ": " + filma.antall(sjanger));
        }
    }
	
}
