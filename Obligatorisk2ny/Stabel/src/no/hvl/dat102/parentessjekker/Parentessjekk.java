package no.hvl.dat102.parentessjekker;

import no.hvl.dat102.adt.Parentessjekker;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetStabel;

public class Parentessjekk implements Parentessjekker {
	private char[][] paranteser = {{'(', '[', '{'}, {')', ']', '}'}};
	private KjedetStabel<Character> stack = new KjedetStabel<Character>();
	private KjedetStabel<Character> tmpStack = new KjedetStabel<Character>();

	@Override
	public boolean erVenstreparentes(char p) {
		return erParantes(p, paranteser[0]);
	}

	@Override
	public boolean erHogreparentes(char p) {
		return erParantes(p, paranteser[1]);
	}

	@Override
	public boolean erParentes(char p) {
		return erVenstreparentes(p) || erHogreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {

			if ('{' == venstre && '}' == hogre) {
				return true;
			}
			if ('(' == venstre && ')' == hogre) {
				return true;
			}
			if ('[' == venstre && ']' == hogre) {
				return true;
			}
		return false;
	}

	@Override
	public boolean erBalansert(String s) {
		char c;
		char venstre, hoyre, forste;
		int teller = 0;
		for (int i = s.length()-1; i >= 0; i--) {
			c = s.charAt(i);
			if (erParentes(c)) {
				stack.push((Character) c);
				teller++;
			}
		}//Legt til alle parantesene
		if(teller%2 == 1) { //En av paratesene har ingen partner
			return false;
		}

		while(!stack.erTom()) {
			venstre = stack.pop();
			while(erVenstreparentes(venstre) && erVenstreparentes(stack.peek())) {
				tmpStack.push(venstre);
				venstre = stack.pop();
			}
			if(!erPar(venstre, stack.peek())) {
				return false;
			}
			stack.pop();
			if(!tmpStack.erTom()) {
				stack.push(tmpStack.pop());
			}
		}
		return true;
	}
	private boolean erParantes(char p, char[] liste) {
		for(char i: liste) {
			if (p == i) {
				return true;
			}
		}
		return false;
	}	
}
