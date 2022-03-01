package no.hvl.dat102.hobby;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.hobby.Hobby;
import no.hvl.dat102.hobby.Medlem;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks; //-1 hvis ikke koblet

	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;
	}
	
	public boolean passerTil (Medlem medlem2){
		//to medlemmer passer til hverandre hvis de har like hobbyer, altsaa like mengder
		if(this == medlem2) {
			return true;
		}
		if(medlem2 == null || this.getClass() != medlem2.getClass()) {
			return false;
		}
		
		boolean passer = true;
		if(this.getHobbyer().antall() != medlem2.getHobbyer().antall()) {
			passer = false;
		} else {
			for(Hobby h : medlem2.getHobbyer()) {
				if(!this.getHobbyer().inneholder(h)) {
					passer = false;
				}
			}
		}
		return passer;
	}//end passerTil

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
	
	@Override
	public String toString() {
		String harpar = "";
		if(statusIndeks != -1) {
			harpar = "Ja";
		} else {
			harpar = "Nei";
		}
		String resultat = "Navn: " + navn + "\n" + "Hobby(er): " + hobbyer.toString() + "\n" +
						"Har par: " + harpar;
		return resultat;
	}
}
