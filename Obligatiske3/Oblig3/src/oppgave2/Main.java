package oppgave2;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Integer[] tab = makeList(320000); //Angi hvor mange elementer listen skal ha
		maaling(50); //Angi hvor mange målinger som skal gjøres, endre sorteringsalgoritmen i metoden
		
	}
	
	private static void quickEnVerdi() {
		int antall = 128000;
		Integer[] tab = new Integer[antall];
		int teller = 0;
		while (teller < antall) {
			tab[teller] = 1;
			teller++;
		}
		quickSort(tab);
	}
	private static void maaling(int antall) {
		
		ArrayList<Double> malinger = new ArrayList<>();
		double maling = 0;
		for(int i = 0; i < antall; i++) {
			Integer[] tab = makeList(10000);
			double malingen = insertionSort(tab); //Her skrives navnet på sorteringalgoritmen
			maling += malingen;
			malinger.add(malingen);
		}
		
		System.out.println(malinger);
		System.out.println("Gjennomsnitt: " + (maling / antall) + "Sekunder");
		System.out.println("Antall målinger: " + antall);
	}
	
	private static double insertionSort(Integer[] tabell) {
		Integer[] tab = tabell;
		long start = System.nanoTime();
		InsertionSort.sorteringVedInssetting(tab, tab.length);
		long end = System.nanoTime();
		//print("Insertion sort" ,tab);
		//Tprint(start, end);
		return T(start, end);
	}
	
	private static double selectionSort(Integer[] tabell) {
		Integer[] tab = tabell;
		long start = System.nanoTime();
		SelectionSort.utvalgssortering(tab, tab.length);
		long end = System.nanoTime();
		//print("Selection sort", tab);
		//Tprint(start, end);
		return T(start, end);
	}
	
	private static double mergeSort(Integer[] tabell) {
		Integer[] tab = tabell;
		long start = System.nanoTime();
		MergeSort.flettesortering(tab, tab.length);
		long end = System.nanoTime();
		//print("Merge sort", tab);
		//Tprint(start, end);
		return T(start, end);
	}
	
	private static double quickSort(Integer[] tabell) {
		Integer[] tab = tabell;
		long start = System.nanoTime();
		QuickSort.quickSort(tab, tab.length);
		long end = System.nanoTime();
		//print("Quick sort", tab);
		//Tprint(start, end);
		return T(start, end);

	}
	
	
	private static void print(String type, Integer[] tab) {
		System.out.print(type + ": ");
		/*for (Integer i: tab) {
			System.out.print(i + " ");
		}*/
		System.out.println();
		
	}
	
	private static void Tprint(long start, long end) {
		System.out.println(T(start, end) + " Sekunder");
	}
	
	private static double T(long start, long end) {
		return (end - start)/1000000000.0;
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
	
	
	
	

}
