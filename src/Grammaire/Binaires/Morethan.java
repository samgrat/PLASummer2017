package Grammaire.Binaires;

import Grammaire.Binaire;
import Grammaire.Expression;
import Programme.Robot;

public class Morethan extends Binaire{
	Expression head, tail;
	
//	public List<Expression> getObject(){
//		return this;
//	}
	
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
		if(head.isExecutable())
			return head;
		else{
			return tail;
		}
	}
	
	@Override
	public void exec() {
		Expression header = morethan();
		if(header != head)
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

	@Override
	public void exec(Robot robot) {
		Expression header = morethan();
		if(header != head)
			morethan().exec(robot);
	}
}
