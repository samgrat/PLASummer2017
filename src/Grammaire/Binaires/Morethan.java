package Grammaire.Binaires;

import java.util.Random;

import Grammaire.Binaire;
import Grammaire.Expression;

public class Morethan extends Binaire{
	Expression head, tail;
	
	/**
	 * @param s1 head
	 * @param s2 tail
	 */
	public Morethan(Expression s1, Expression s2){
		head = s1;
		tail = s2;
	}
	
	/**
	 * Execute head si possible sinon tail
	 * @param head une Expression
	 * @param tail une autre Expression
	 */
	// TODO choose between 
	// public Expression exec(Expression head, Expression tail) {
	// or
	public Expression morethan() {
		// TODO faire un try{} catch{}
		return null;
	}
	
	@Override
	public void exec() {
		morethan().exec();
	}
	
	@Override
	public String toString() {
		return ("{h = " + head.toString() + " > t = " + tail.toString() + "}");
	}
}
