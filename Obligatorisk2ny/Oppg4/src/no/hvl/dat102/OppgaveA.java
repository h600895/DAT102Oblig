package no.hvl.dat102;

public class OppgaveA {

	public static int sumAvHeltall(int n) {
		int sum = 0;
		if (n == 0) {
			return sum;
		}
		sum = n + sumAvHeltall(n-1);
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sumAvHeltall(100));
	}
	
}
