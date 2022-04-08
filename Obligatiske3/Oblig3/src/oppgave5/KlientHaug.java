package oppgave4;

import oppgave4.TabellHaug;

public class KlientHaug {
	public static void main(String[] a) {
		// Tester haugen ved å sortere verdier i en tabell
		int tab[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		TabellHaug<Integer> h1 = new TabellHaug<Integer>();
		for (int i = 0; i < tab.length; i++) {

			h1.leggTilElement((tab[i]));
		}

		h1.leggTilElement(6);
		h1.leggTilElement(3);
		
		System.out.println("Verdiene i tabellen er nå:");
		h1.skrivTab();
		// Tar ut av haugen og skriver i sortert rekkefølge
		System.out.println("\nHaugen i sortert rekkefoelge:");
		while (!h1.erTom()) {
			Integer h =  h1.fjernMinste();
			System.out.print(h + "  ");
		}
		System.out.println();
	}
	
}
