package no.hvl.dat102.mengde.tabell;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.LinearNode;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}
	
	@Override
	public String toString() {
		String resultat = "";
		Iterator<T> it = this.iterator();
		T element = null;
		while(it.hasNext()) {
			element = it.next();
			resultat += element.toString() + "\t";
		}
		return resultat;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall-1]= null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		// Søker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		for(int i = 0; (i < antall && !funnet);i++) {
			if(tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall-1];
				//tab[antall-1] = null;
				antall--;
				funnet = true;

			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	/*
	 * Når vi overkjører (override) equals- meteoden er det anbefalt at vi også
	 * overkjører hascode-metoden da en del biblioterker burker hascode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hascode senere i faget.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object m2) {
		//sjekker om objektene er: like, om m2 ikke eksisterer og om de har forskjellige klasser.
		if (this == m2) {
			return true;
		}
		if ((m2 == null) || (m2.getClass() != this.getClass())) {
			return false;
		}

		boolean likeMengder = true;
		//typetvinger objektet m2 til å være en tabellmengde
		MengdeADT<T> tab = (TabellMengde<T>) m2;
		//tabellene må ha like mange elementer for å være lik
		if (this.antall() != tab.antall()) {
			likeMengder = false;
		} else {
			//lager en iterator som teller over elementene i tabellen m2
			Iterator<T> teller = tab.iterator();
			while(teller.hasNext() && likeMengder) {
				T element = teller.next();
				if(!this.inneholder(element)) {
					likeMengder = false;
				}
			}
		}
		return likeMengder;
	}//end equals

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		//union er this-mengden og m2-mengden lagt sammen
		MengdeADT<T> begge = new TabellMengde<>();
		begge.leggTilAlle(this);
		begge.leggTilAlle(m2);

		return begge;
	}//end union

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<>();
		T element = null;
		Iterator<T> teller = m2.iterator();
		while(teller.hasNext()) {
			element = teller.next();
			if(this.inneholder(element)) {
				((TabellMengde<T>)snittM).settInn(element);
			}
		}
		return snittM;
	}//end snitt

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		//this uten m2-mengden
		MengdeADT<T> differensM = new TabellMengde<>();
		T element;
		Iterator<T> teller = this.iterator();
		while(teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}

		return differensM;
	}//end differens

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		Iterator<T> teller = this.iterator();
		while(teller.hasNext() && erUnderMengde) {
			T element = teller.next();
			if(!m2.inneholder(element)) {
				erUnderMengde = false;
			}
		}
		return erUnderMengde;
	}//end undermengde

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<>(tab, antall);
	}

	public T[] getTab() {
		return tab;
	}

	public void setTab(T[] tab) {
		this.tab = tab;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}



}// class
