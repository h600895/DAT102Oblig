package no.hvl.dat102.hobby;

import java.util.Scanner;

import no.hvl.dat102.hobby.Datakontakt;

public class Tekstgrensesnitt {

	public static Medlem lesMedlem() {
		Datakontakt dataKon = new Datakontakt();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv in navnet på medlemmet: ");
		String name = input.nextLine();
		
		Medlem medlem = new Medlem(name);
		dataKon.leggTilMedlem(medlem);
		
		return medlem;
	}
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene:");
		System.out.println(medlem.getHobbyer().toString());
		
	}
	public static void skrivParListe(Datakontakt arkiv) {
		//lag en duplikat av arkviet og bruk fjern metoden får å hente ut par
		//Print dem ut. Fjern metoden vil forsikre at et par ikke blir skrevet ut flere ganger.
		
		//Bruk iterator og teller tror jeg.
		//Skriv ut antall
	}
	
	
	
}
