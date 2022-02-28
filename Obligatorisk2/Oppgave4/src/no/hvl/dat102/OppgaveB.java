package no.hvl.dat102;

public class OppgaveB {
	public static int tallFolge(int n) {
		if (n == 1) {
			return 5;
		}
		if (n == 0) {
			return 2;
		}
		int nEn = tallFolge(n-1); // n-1 leddet
		int nTo = tallFolge(n-2); //n-2 leddet
		return 5 * nEn - 6 * nTo + 2;
	}
	public static void main(String[] args) {
		System.out.println(tallFolge(7));
	}
}
