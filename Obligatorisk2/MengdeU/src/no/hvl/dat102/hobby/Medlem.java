package no.hvl.dat102.hobby;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	//Konstruktør
	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = new TabellMengde<Hobby>();
		statusIndeks = -1;
	}
	
	//Andre metoder
	
	
	
	
	public boolean passerTil(Medlem medlem2) {
		return getHobbyer().equals(medlem2.getHobbyer());
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
}
