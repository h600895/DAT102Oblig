package no.hvl.dat102;

public class OppgaveD {
	public static int fobonacci(int n) {
		int teller = 0;
		int nEn = 0;
		int nTo = 1;
		int tmp;
		while (teller < n) {
			if (teller > 0) { //To eller større
				tmp = nEn + nTo;
				//System.out.println(teller + ": " + nEn + " + " + nTo + " = " + tmp);
				nEn = nTo;
				nTo = tmp;
			}
			teller++;
			//System.out.println(teller+": " + nTo);
		}
		
		return nTo;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": " + fobonacci(i));
		}
	}
}
