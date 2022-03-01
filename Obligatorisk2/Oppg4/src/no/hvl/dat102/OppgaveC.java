package no.hvl.dat102;

public class OppgaveC {
	public static int fobonacci(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		int nEn = fobonacci(n-1); // n-1 leddet
		int nTo = fobonacci(n-2); //n-2 leddet
		return nEn + nTo;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": " + fobonacci(i));
		}
	}
}
