package oppgave4;

import java.util.Iterator;

public class BS_Tre<T extends Comparable<? super T>> implements SoektreInterface<T> {
	
	private BinaerTreNode<T> rot;
	
	public BS_Tre() {
		rot = null;
	}
	
	public BS_Tre(T element) {
		rot = new BinaerTreNode<T>(element);
	}
	
	/**
	 * S�ker etter et gitt element i treet.
	 * 
	 * @param element elementet vi s�ker etter.
	 * @return true om elementet finst, false elles.
	 */
	public boolean inneholder(T element) {
		return false;
	}

	/**
	 * Henter et element i treet.
	 * 
	 * @param element elementet vi leiter etter.
	 * @return Elementet dersom det finst, elles null.
	 */
	public T finn(T element) {
		return finn(element, rot);
	}

	private T finn(T element, BinaerTreNode<T> p) {
		T svar = null;
		
		// p == null  -> tomt tre som er basistille og svar blir null
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) {
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}
		return svar;
	}
	/**
	 * Legg eit element til treet dersom det ikkje finst fr� f�r. Elles etstattar
	 * blir det gamle elementet erstatta med det nye.
	 * 
	 * @param nyElement elementet som skal leggast til
	 * @return null om elementet ikkje finst fr� f�r. Elles det element som var i
	 *         treet fr� f�r.
	 */
	public T leggTil(T nyElement) {
		return leggTil(rot, nyElement).getElement();
	}

	private BinaerTreNode<T> leggTil(BinaerTreNode<T> p, T element){
		if (p == null) {
			return new BinaerTreNode<T>(element);
		} else {
			if (element.compareTo(p.getElement()) < 0) {
				p.setVenstre(leggTil(p.getVenstre(), element));
			} else {
				// Alternativ med to kodelinjer
				BinaerTreNode<T> q = leggTil(p.getHogre(), element);
				p.setHogre(q);
			}
		}
		return p;
	}
	/**
	 * Fjernar eit element fr� treet.
	 * 
	 * @param element elementet som skal fjernast.
	 * @return elementet som vart fjerna eller null om det ikkje finst.
	 */
	public T fjern(T element) {
		return null;
	}

	/**
	 * Lagar ein iterator som g�r gjennom alle element i treet i inorden.
	 * 
	 * @return ein iterator som elementa i sortert rekkef�lge.
	 */
	public Iterator<T> getInordenIterator() {
		return null;
	}
	public int getSizeTree() {
		return sizeTree(rot);
	}
	
	private int sizeTree(BinaerTreNode<T> node) {
		
		int lengdeH = 0;
		int lengdeV = 0;
		
		if (node == null && lengdeH == 0 && lengdeV == 0) {
			return -1;
		}
		else if (node == null) {
			return 0;
		}
		
		lengdeH = sizeTree(node.getHogre()); //Høyre
		lengdeV = sizeTree(node.getVenstre()); //Venstre
		
		if (lengdeH > lengdeV) {
			return lengdeH+1;
		}
		return lengdeV+1;
		
	}

}
