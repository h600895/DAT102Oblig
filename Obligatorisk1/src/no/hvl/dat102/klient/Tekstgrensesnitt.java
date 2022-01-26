package no.hvl.dat102.klient;

import java.util.ArrayList;
import java.util.Scanner;

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
		return new Film(Integer.parseInt(split[0]) , split[1], split[2], Integer.parseInt(split[3]), Sjanger.valueOf(split[4]), split[5]);

		
	}
	public Film visFilm(int nr, FilmarkivADT filma) { //FilmarkivADT skal ikke være paramter, men finner ikke ut hvordan løse den ellers.
		return filma.finnFilm(nr);
	}
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmer = filma.soekTittel(delstreng);
		
	}
	public void skrivUtProdusent(FilmarkivADT filma, String delstreng) {
		//Elendig og veldig lite effektiv måte:
		boolean funnet = false;
		if (filma.antall() > 0) {
			for (int i = 1; i < filma.antall(); i++) {
				
				Film filmen = filma.finnFilm(i);
				if (filmen != null) {
					if (filmen.getProdusent().contains(delstreng)) {
						funnet = true;
						System.out.println(filmen);
					}
				}
				
			}
			if (!funnet) {
				System.out.println("Fant ingen film med denne produsenten");
			}
		}
		}
		
	public void skrivUtStatestikk(FilmarkivADT filma) {
		
	}
}
