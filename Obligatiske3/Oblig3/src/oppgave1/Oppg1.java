package oppgave1;

import java.util.Random;

public class Oppg1 {
	
    // Skriv ut en tabell
    public static void skrivUtTabell(Integer[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
	
	private Integer[] genererTilfeldig(int antall) {
		Random tilfeldig = new Random();
        Integer[] tabell = new Integer[antall];
        for(int i = 0; i < tabell.length; i++) {
            tabell[i] = tilfeldig.nextInt(tabell.length);
        }
        return tabell;
	}
	
	// bytter plass på a[i] og a[j]
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// Vanlig insettingssortering
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		for(int i = start+1; i <= slutt; i++) {
            T temp = a[i];
            int j = i-1;
            boolean ferdig = false;
            while(!ferdig && j >= 0) {
                if(temp.compareTo(a[j]) < 0) {
                    a[j+1] = a[j];
                    j--;
                }
                else {
                    ferdig = true;
                }
            }
            a[j+1] = temp;
        }
	} 
	
	//Innsetting med ferdig sortert indeks 0
	public static <T extends Comparable<? super T>> void insettingsSorteringA(T[] a, int start, int slutt) {

        //Først må vi finne det minste tallet og sette det først 
        for(int i = start+1; i < slutt; i++) {
            if(a[i].compareTo(a[start]) < 0) {
                swap(a, start, i);
            }
        }

        // Modifisert insettingssortering som hopper over indeks 0
        for(int i = start+1; i < slutt; i++) {
            T temp = a[i];
            int j = i-1;
            boolean ferdig = false;
            while(!ferdig && j > 0) {
                if(temp.compareTo(a[j]) < 0) {
                    a[j+1] = a[j];
                    j--;
                }
                else {
                    ferdig = true;
                }
            }
            a[j+1] = temp;
        }
    }
	
}
