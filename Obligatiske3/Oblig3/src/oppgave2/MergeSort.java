package oppgave2;

public class MergeSort {
	
	
	
	
	public static <T extends Comparable<? super T>> void flettesortering(T[] a, int n) {
		flettesortering(a, 0, n - 1);
	}

	public static <T extends Comparable<? super T>> void flettesortering(T[] a, int first, int last) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable<?>[a.length]; // unchecked cast
		flettesortering(a, tempArray, first, last);
	}

	private static <T extends Comparable<? super T>> void flettesortering(T[] a, T[] tempTab, int forste, int siste) {
		if (forste < siste) {
			int midten = (forste + siste) / 2;
			flettesortering(a, tempTab, forste, midten);
			flettesortering(a, tempTab, midten + 1, siste);
			flette(a, tempTab, forste, midten, siste);
			
		}
	}

	private static <T extends Comparable<? super T>> void flette(T[] a, T[] tempTab, int forste, int midten,
			int siste) {
		// Flettar saman to deler som ligg ved sida av kvaranre
		// forste, ..., midten og midten + 1, ..., siste
		int fV = forste;
		int sluttV = midten;
		int fH = midten + 1;
		int sluttH = siste;

		// S� lenge det er element att i begge delane, flytt over den minste til tempTab
		int index = fV; // Next available location in tempArray
		for (; (fV <= sluttV) && (fH <= sluttH); index++) {
			if (a[fV].compareTo(a[fH]) < 0) {
				tempTab[index] = a[fV];
				fV++;
			} else {
				tempTab[index] = a[fH];
				fH++;
			}
		}

		// No vil ein av delane vere to. Kopierer over resten i den andr eedelen

		// Venstre del, kan vere tom
		for (; fV <= sluttV; fV++, index++) {
			tempTab[index] = a[fV];
		}

		// H�gre del, kan vere tom
		for (; fH <= sluttH; fH++, index++) {
			tempTab[index] = a[fH];
		}

		// Kopier den sorterte delen tilbake
		for (index = forste; index <= siste; index++) {
			a[index] = tempTab[index];
		}
	}
}
