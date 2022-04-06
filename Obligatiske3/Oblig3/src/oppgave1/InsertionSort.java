package oppgave1;

import java.util.Random;

public class InsertionSort {
	
	public static void main(String[] args) {
		Random tilfeldig= new Random();
		int n=32000; 
		int antall= 10;
		
		Integer[][] a = new Integer[antall][n];
		
		for (int i=0; i<antall; i++) {
			for(int j=0; j<n; j++) {
				a[i][j]= tilfeldig.nextInt();
			}
		}
	}
	
}
