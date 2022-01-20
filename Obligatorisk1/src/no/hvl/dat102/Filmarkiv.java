package no.hvl.dat102;

import java.util.ArrayList;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmsamling;
	int antall;
	
	public Filmarkiv(int n) {
		filmsamling = new Film[n];
		antall = 0;
	}
	
	@Override
	public void visFilm(int nr) {
		for(int i = 0; i < antall; i++ ) {
			if (filmsamling[i].getFilmnr() == nr) {
				System.out.println(filmsamling[i]);
				break;
			}
		}
		System.out.println("Finne filmen finnes ikke i arkivet!");
		
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (filmsamling.length <= antall) {
			Film[] temp = filmsamling;
			filmsamling = new Film[antall*2];
			for (int i = 0; i < antall; i++) {
				filmsamling[i] = temp[i];
			}
		}
		filmsamling[antall] = nyFilm;
		antall++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for(int i = 0; i < antall; i++ ) {
			if (filmsamling[i].getFilmnr() == filmnr) {
				for (int j = i; j < antall-1; j++) { //Flytter alle elementer et hakk mot start får å slippe null hull i listen
					filmsamling[j] = filmsamling[j+1]; 
				}
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		ArrayList<Film> filmer = new ArrayList<>();
		for (int i = 0; i < antall; i++) {
			if (filmsamling[i].getTittel().contains(delstreng)) {
				filmer.add(filmsamling[i]);
			}
		}
		return (Film[]) filmer.toArray();
	}
	
	public Film[] soekProdusent(String delstreng) {
		ArrayList<Film> filmer = new ArrayList<>();
		for (int i = 0; i < antall; i++) {
			if (filmsamling[i].getProdusent().contains(delstreng) ) {
				filmer.add(filmsamling[i]);
			}
		}
		return (Film[]) filmer.toArray();
	}

	@Override
	public int antall(Sjanger sjanger) {
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (filmsamling[i].getSjanger() == sjanger) {
				teller++;
			}
		}
		return teller;
	}

	@Override
	public int antall() {
		return filmsamling.length;
	}
	
}
