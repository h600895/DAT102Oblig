package oppgave2;

public class QuickSort {

	
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	public static final int MIN_SIZE = 5;

	public static <T extends Comparable<? super T>> void quickSort(T[] array, int n) {
		kvikksorter(array, 0, n - 1);
		InsertionSort.sorteringVedInssetting(array, n);
	}

	public static <T extends Comparable<? super T>> void kvikksorter(T[] a, int forste, int siste) {
		if (siste - forste + 1 >= MIN_SIZE) {
			int p = partition(a, forste, siste);
			kvikksorter(a, forste, p - 1);
			kvikksorter(a, p + 1, siste);
		}
	} 

	// Partitions an array as part of quick sort into two subarrays
	// called Smaller and Larger that are separated by a single
	// entry called the pivot.
	// Entries in Smaller are <= pivot and appear before the
	// pivot in the array.
	// Entries in Larger are >= pivot and appear after the
	// pivot in the array.
	// Parameters:
	// a An array of Comparable objects.
	// first The integer index of the first array entry;
	// first >= 0 and < a.length.
	// last The integer index of the last array entry;
	// last - first >= 3; last < a.length.
	// Returns the index of the pivot.
	private static <T extends Comparable<? super T>> int partition(T[] a, int forste, int siste) {
		int midten = (forste + siste) / 2;

		// Ordnar f�rste, midterse og siste element slik at dei st�r rett i forhold til kvarandre
		sortFirstMiddleLast(a, forste, midten, siste);


		// Flyttar pivot til nest siste plass
		swap(a, midten, siste - 1);
		int pivotIndex = siste - 1;
		T pivotValue = a[pivotIndex];

		// Finn f�rste i venstre del som er mindre st�rre enn pivot
		// siste i h�gre del som er mindre enn pivot

		int fraVenstre = forste + 1;
		int fraHogre = siste - 2;

		boolean ferdig = false;
		while (!ferdig) {
			
			while (a[fraVenstre].compareTo(pivotValue) < 0) {
				fraVenstre++;
			}
			
			while (a[fraHogre].compareTo(pivotValue) > 0) {
				fraHogre--;
			}
			
			if (fraVenstre < fraHogre) {
				swap(a, fraVenstre, fraHogre);
				fraVenstre++;
				fraHogre--;
			} else
				ferdig = true;
		} 

		// Place pivotValue between the subarrays Smaller and Larger
		swap(a, pivotIndex, fraVenstre);
		pivotIndex = fraVenstre;

		return pivotIndex;
	} 

	// Sorts the first, middle, and last entries of an array into ascending order.
	// Parameters:
	// a An array of Comparable objects.
	// first The integer index of the first array entry;
	// first >= 0 and < a.length.
	// mid The integer index of the middle array entry.
	// last The integer index of the last array entry;
	// last - first >= 2, last < a.length.
	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		order(a, first, mid); // Make a[first] <= a[mid]
		order(a, mid, last); // Make a[mid] <= a[last]
		order(a, first, mid); // Make a[first] <= a[mid]
	} // end sortFirstMiddleLast

	// Orders two given array elements into ascending order
	// so that a[i] <= a[j].
	private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
		if (a[i].compareTo(a[j]) > 0)
			swap(a, i, j);
	}
}
