package oppgave1;

public class Main {
	public static void main (String[] args) {
      Integer[] tab = {6, 2, 1, 3, 5, 4, 7};
      System.out.println("Tabell foer sortering: ");
      Oppg1.skrivUtTabell(tab);
      System.out.println("Tabell etter sortering: ");
      Oppg1.insettingsSorteringA(tab, 0, tab.length);
      Oppg1.skrivUtTabell(tab);
	}
}
