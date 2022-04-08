package oppgave1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		Integer[] tab = makeList(200000); //Angi hvor mange elementer listen skal ha
		maaling(10, tab); //Angi hvor mange målinger som skal gjøres, endre sorteringsalgoritmen i metoden
	}

	private static void maaling(int antall, Integer[] tab) {

		ArrayList<Double> malinger = new ArrayList<>();
		double maling = 0;
		for (int i = 0; i < antall; i++) {
			long start = System.nanoTime();
			Oppg1.insettingsSortering(tab, 0, tab.length); // Her skrives navnet på
			long slutt = System.nanoTime();	
			double malingen = T(start, slutt);
			// sorteringalgoritmen
			maling += malingen;
			malinger.add(malingen);
		}

		System.out.println(malinger);
		System.out.println("Gjennomsnitt: " + (maling / antall) + "Sekunder");
		System.out.println("Antall målinger: " + antall);
	}
	
	private static Integer[] makeList(int len) {
		
		Integer[] list = new Integer[len];
		Random tilfeldig = new Random();
		int teller = 0;
		while (teller < len) {
			int tilfeldigTall = tilfeldig.nextInt((1000 - 0) + 1) + 0;
			list[teller] = tilfeldigTall;
			
			teller++;
		}
		
		
		return list;
		
	}
	
	private static double T(long start, long end) {
		return (end - start)/1000000000.0;
	}
}
