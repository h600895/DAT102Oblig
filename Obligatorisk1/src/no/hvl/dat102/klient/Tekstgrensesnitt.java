package no.hvl.dat102.klient;

import java.util.ArrayList;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	public Film lesFilm() {
		return null;
	}
	public void visFilm(Film film) {
		System.out.println(film);
	}
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmer = filma.soekTittel(delstreng);
		for (Film film: filmer) {
			visFilm(film);
		}
	}
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		
	}
	public void skrivUtStatestikk(FilmarkivADT filma) {
		
	}
}
