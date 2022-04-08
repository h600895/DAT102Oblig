package oppgave4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
	int antallNoder;
		
	public Main(int antallNoder) {
		this.antallNoder = antallNoder;
	}

	

	public static void main(String[] args) {
		Main ui = new Main(1024);
		int antallTrer = 10000;
		
		ArrayList<BS_Tre<Integer>> trer = ui.generererTrer(antallTrer);
		System.out.print("Antall Noder: ");
		System.out.println(ui.antallNoder);//Antall noder
		System.out.print("Minste teoretiske hoyden: ");
		System.out.println(ui.minTeoHoyde(ui.antallNoder)); //Minste teorietiske høyde
		System.out.print("Maks teoretiske hoyden: ");
		System.out.println(ui.maxTeoHoyde(antallTrer));//Maks teoretiske høyde
		System.out.print("Minste høyden i listen: ");
		System.out.println(ui.finnMinTre(trer));//Minste høyden i arraylisten
		System.out.print("Største høyden i listen: ");
		System.out.println(ui.finnMaxTre(trer));//Største høyden i arraylisten
		System.out.print("Gjennsomsnittlig høyde i listen: ");
		System.out.println(ui.gjennomsnittHoyde(trer)); //Gjennomsnittlig høyde

		
		
		
	}
	//ii)
	public int minTeoHoyde(int antallNoder) {
		return (int)(Math.log(antallNoder) / Math.log(2)); //Log2(antall)
	}
	//iii)
	public int maxTeoHoyde(int antall) {
		return antall;
	}
	public int finnMinTre(ArrayList<BS_Tre<Integer>> trer) {
		int teller = 1;
		int lengde = trer.size();
		int min = 0;
		if (lengde < 1) {
			return -1;
		}
		min = trer.get(teller).getSizeTree();
		int nyLengde;
		while (teller < trer.size()) {
			nyLengde = trer.get(teller).getSizeTree();
			if (nyLengde < min) {
				min = nyLengde;
			}
			teller++;
			
		}
		return min;
	}
	public int finnMaxTre(ArrayList<BS_Tre<Integer>> trer) {
		int teller = 0;
		int max = -2;
		
		while (teller < trer.size()) {
			
			if (max < trer.get(teller).getSizeTree()) {
				max = trer.get(teller).getSizeTree();
			}
			teller++;
		}
		return max;
	}
	public int gjennomsnittHoyde(ArrayList<BS_Tre<Integer>> trer) {
		
		int teller = 0;
		int totHoyde = 0;
		while (teller < trer.size()) {
			totHoyde += trer.get(teller).getSizeTree();
			
			
			
			teller++;
		}
		return totHoyde/trer.size();
		
		
	}
	
	public ArrayList<BS_Tre<Integer>> generererTrer(int antall) {
		ArrayList<BS_Tre<Integer>> trer = new ArrayList<>(0);
		for (int i = 0; i < antall; i++) {
			trer.add(lagTre(antallNoder));
		}
		return trer;
	}
	
	
	private static BS_Tre lagTre(int antallNoder) {
		int antall = antallNoder-1;
		int min = 0;
		int max = 1000;
		Random tilfeldig = new Random();
		BS_Tre<Integer> tre = new BS_Tre(tilfeldig.nextInt((1000 - 0) + 1) + 0);
		for (int i = 0; i < antall; i++) {
			
			tre.leggTil(tilfeldig.nextInt((1000 - 0) + 1) + 0);
		}
		return tre;
	}

}
