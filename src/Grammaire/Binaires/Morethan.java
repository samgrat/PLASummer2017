package Grammaire.Binaires;

import java.util.Random;

import Grammaire.Binaire;
import Grammaire.ExpException;
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
	// TODO arriver a tester l execution de head sans l'executer
	public Expression morethan() {
		Expression head_2;
		head_2 = head;
		if(head_2.isExecutable())
			return head;
		else{
			return tail;
		}
	}
	
	@Override
	public void exec() {
		morethan().exec();
	}
	
	@Override
	public String toString() {
		return ("{h = " + head.toString() + " > t = " + tail.toString() + "}");
	}

	@Override
	public boolean isExecutable() {
		if(this.morethan().isExecutable()){
			return true;
		}
		else{
			return false;
		}
	}
}
