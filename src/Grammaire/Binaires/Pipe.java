package Grammaire.Binaires;

import java.util.Random;

import Grammaire.Binaire;
import Grammaire.Expression;

public class Pipe extends Binaire {
	Expression head, tail;
	
	/**
	 * @param s1 head
	 * @param s2 tail
	 */
	public Pipe(Expression s1, Expression s2){
		head = s1;
		tail = s2;
	}
	
	/**
	 * Execute aleatoirement head ou tail
	 * @param head une Expression
	 * @param tail une autre Expression
	 */
	// TODO choose between 
	// public Expression exec(Expression head, Expression tail) {
	// or
	public Expression pipe(){
		
		// TODO rand(0,1)
		// si 0 exec(head)
		// si 1 exec(tail)
		
		Random r = new Random();
		int valeur = r.nextInt(2); // génere soit 1, soit 0
		
		switch (valeur) {
		case 0:
			//head.exec();
			return head;
		case 1:
			return tail;
			
		default:
			break;
		}
		return null;

	}

	@Override
	public void exec() {
		pipe().exec();
		
	}

	@Override
	public String toString() {
		return ("{h = " + head.toString() + " | t = " + tail.toString() + "}");
	}
}
