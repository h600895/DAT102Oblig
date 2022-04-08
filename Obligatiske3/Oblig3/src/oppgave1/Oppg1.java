package oppgave1;

import java.util.Random;

public class Oppg1 {
	
	public static void main(String[] args) {
		int[][] tab = genererTilfeldig(10,10);
		for(int i = 0; i < tab.length; i++) {
			sorteringVedInssetting(tab[i]);
			for(int j : tab[i]) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] genererTilfeldig(int antall, int kjoringer) {
		Random tilfeldig= new Random();
		int n = antall; 
		int kjoring = kjoringer;
		
		int[][] a = new int[kjoring][n];
		
		for (int i=0; i<kjoring; i++) {
			for(int j=0; j<n; j++) {
				a[i][j]= tilfeldig.nextInt();
			}
		}
		return a;
	}
	
	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static void sorteringVedInssetting(int[] a) {
		int i = a.length-1;
		
		while(i < 0) {
			int temp = a[i];
			int j;
			
			for(j = i + 1; j < a.length && a[j]<temp; j++) {
				a[j-1] = a[j];
			}
			
			a[j-1] = temp;
		}
	} 
	
}
