package oppgave4;

public class RekusivtTre {

	public static void main(String[] args) { //Sjekker høyden til et tre.
		int antallNoder = 10;
		BinaerTreNode<Integer> rot = new BinaerTreNode<>(1);
		rot.setHogre(new BinaerTreNode<Integer>(1));
		rot.getHogre().setHogre(new BinaerTreNode<Integer>(2));
		
		BinaerTreNode<Integer> aktuell = rot;
		for (int i = 0; i < antallNoder; i++) {
			BinaerTreNode<Integer> nyNode = new BinaerTreNode<Integer>(i);
			
			aktuell.setVenstre(nyNode);
			aktuell = aktuell.getVenstre();
		}
		System.out.println(sizeTree(rot));

	}
	
	public static int sizeTree(BinaerTreNode node) {
		
		if (node == null) {
			return 0;
		}
		int lengdeH = sizeTree(node.getHogre()); //Høyre
		int lengdeV = sizeTree(node.getVenstre()); //Venstre
		
		if (lengdeH > lengdeV) {
			return lengdeH+1;
		}
		return lengdeV+1;
		
	}

}
