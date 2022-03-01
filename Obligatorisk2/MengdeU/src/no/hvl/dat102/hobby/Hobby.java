package no.hvl.dat102.hobby;

import no.hvl.dat102.hobby.Hobby;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	@Override
	public String toString() {
		String resultat = "<" + this.hobbyNavn + ">";
		return resultat;
	}

	@Override
	public boolean equals(Object hobby2) {
		Hobby hobbyAndre = (Hobby)hobby2;
		return(hobbyNavn.equals(hobbyAndre.getHobbyNavn()));
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}
}
