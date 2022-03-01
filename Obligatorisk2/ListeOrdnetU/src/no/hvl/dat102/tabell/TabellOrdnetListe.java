package no.hvl.dat102.tabell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste();
		fjern(siste());
		
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
			}

		T resultat = liste[0];
		fjern(liste[0]);
		
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return liste[bak-1];
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		T[] hjelper = (T[]) (new Comparable[liste.length]);
		if (bak >= liste.length) {
			utvid();
		}
		if(erTom()) {
			liste[0] = element;
		} else if (element.compareTo(siste()) > 0) {
			liste[bak] = element;
		} else {
			int i = 0;
			while(liste[i].compareTo(element) <= 0){
				i++;
			}
			for(int j = 0; j < i; j++) {
				hjelper[j] = liste[j];
			}
			
			hjelper[i] = element;
			
			for(int j = i +1; j < bak+1; j++) {
				hjelper[j] = liste[j-1];
			}
			liste = hjelper;
		}
		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int indeks = finn(element);
		if (indeks == IKKE_FUNNET) {
			return null;
		}
		T resultat = liste[indeks];
		//liste[indeks] = liste[bak-1]; //Flytter bakerste element på den ledige plassen
		//bak--;
		
		for (int i = indeks; i < bak-1; i++) {
			liste[i] = liste[i+1];
		}
		bak--;
		
		return resultat;

	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		while (bak > i) {
			if (liste[i].equals(el)) {
				return i;
			}
			i++;
		}
				
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class