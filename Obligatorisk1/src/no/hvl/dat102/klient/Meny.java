package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		filmarkiv.leggTilFilm(new Film(1, "George Lucas", "Star Wars: A New Hope", 1977, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(2, "Irvin Kershner", "Star Wars: The Empire Strikes Back", 1980, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(3, "Richard Marquand", "Star Wars: Return of the Jedi", 1983, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(4, "George Lucas", "Star Wars: The Phantom Menace", 1999, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(5, "George Lucas", "Star Wars: Attack of the Clones", 2002, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(6, "George Lucas", "Star Wars: Recenge of the Sith", 2005, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(7, "George Lucas", "Star Wars: The Force Awakence", 1915, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(8, "George Lucas", "Star Wars: The Last Jedi", 2017, Sjanger.SCIFI, "Lucasfilm"));
		filmarkiv.leggTilFilm(new Film(9, "George Lucas", "Star Wars: The Rise of Skywalker", 2019, Sjanger.SCIFI, "Lucasfilm"));
		
		
	}
}
