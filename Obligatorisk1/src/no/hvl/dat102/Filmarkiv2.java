package no.hvl.dat102;


import java.util.ArrayList;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> node = start;
		
		int teller = 0;
		//Gir alltid neste node i kjedet.
		
		while (teller <= antall) {
			//Sjekker om dette er den bakerste noden
			if (node.getElement() == null) {
				return null;
			}
			if (node.getElement().getFilmnr() == nr) {
				return node.getElement();
			}
			//Hvis elementet ikke er det rette henter den neste i kjedet.
			node = node.getNeste();
			teller++;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		int teller = 0;
		//Gir alltid neste node i kjedet.
		LinearNode<Film> element, elementNeste;
		element = start.getNeste(); //Neste
		
		while (teller <= antall) {
			//Sjekker om dette er den bakerste noden
			if (element.getElement() == null) {
				return false;
			}
			elementNeste = element.getNeste(); //Neste sin neste
			if (elementNeste.getElement().getFilmnr() == filmnr) {
				//Hvis nestes neste er null, betyr dette at neste er siste node
				if (elementNeste.getNeste() == null) {
					element.setNeste(null);
				}
				else {
					element.setNeste(elementNeste.getNeste());
				}
				antall--;
				return true;
			}
			//Hvis elementet ikke er det rette henter den neste i kjedet.
			element = element.getNeste();
			teller++;
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		int teller = 0;
		ArrayList<Film> filmer = new ArrayList<>();
		LinearNode<Film> node = start;
		while (teller <= antall) {
			//Sjekker om dette er den bakerste noden
			if (node.getElement() == null) {
				return null;
			}
			if (node.getElement().getTittel().contains(delstreng)) {
				filmer.add(node.getElement());
			}
			node = node.getNeste();
			teller++;
		}
		return (Film[]) filmer.toArray();
	}

	public Film[] soekProdusent(String delstreng) {
		int teller = 0;
		ArrayList<Film> filmer = new ArrayList<>();
		LinearNode<Film> node = start;
		while (teller <= antall) {
			//Sjekker om dette er den bakerste noden
			if (node.getElement() == null) {
				return null;
			}
			if (node.getElement().getProdusent().contains(delstreng)) {
				filmer.add(node.getElement());
			}
			node = node.getNeste();
			teller++;
		}
		return (Film[]) filmer.toArray();
	}


	@Override
	public int antall(Sjanger sjanger) {
		int teller = 0; //While loop telleren
		int antallet = 0; //Taller antall forekomster av sjangeren
		LinearNode<Film> node = start;
		while (teller <= antall) {
			//Sjekker om dette er den bakerste noden
			if (node.getElement() == null) {
				return antallet;
			}
			if (node.getElement().getSjanger().equals(sjanger)) {
				antallet++;
			}
			node = node.getNeste();
			teller++;
		}
		return antallet;
	}

	@Override
	public int antall() {
		return antall;
	}
}
