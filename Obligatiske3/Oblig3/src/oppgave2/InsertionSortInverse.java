package oppgave2;

public class InsertionSortInverse {
	// Byter om a[i] og a[j]. Antar at b�de i og j er lovlege indeksar i tabellen.
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Utvalgssortering / Plukksortering (DAT100) (Selction sort)
	// Sorterer dei f�rste n elmementa i tabellen. Kanskje litt uvanlig
	// Kunne ogs� utelatt n og sortert heile tabellen.

	

	// Sortering ved innsetting (Insertion sort)
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int n) {
		sorteringVedInssetting(a, 0, n - 1);
	}

	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		for (int i = slutt ; i > start; i--) {
			T temp = a[i];
			int j = i - 1;
			
			boolean ferdig = false;
			
			while(a[i].compareTo(a[j]) > 0 && !ferdig) {
				if (j == 0) {
					ferdig = true;
				}
				else {
					j--;
				}
			}
			a[i] = a[j];
			a[j] = temp;
			Main.print("Nytt tre: ", (Integer[]) a);
		}

			
		
		
	} 

}
