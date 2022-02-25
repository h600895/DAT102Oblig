package no.hvl.dat102.hobby;

import java.util.Scanner;

public class klientDatakontakt {

	public static void main(String[] args) {
		Tekstgrensesnitt ui = new Tekstgrensesnitt();
		
		int action = 1;
		while (action != 0) {
			
			action = Integer.parseInt(input("0: Avslutt\\n1: Legg til medlem\\n2: Skriv ut medlemmer\\n: "));
			if (action == 1) {
				ui.lesMedlem();
			}
			else if (action == 2) {
				ui.
				ui.skrivHobbyListe();
				
			}
			
			
		}
		
	}
	private static String input(String message) {
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		
		return input.nextLine();
	}

}
