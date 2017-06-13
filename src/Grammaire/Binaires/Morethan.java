package Grammaire.Binaires;

import java.util.List;
import java.util.Random;

import Grammaire.Binaire;
import Grammaire.ExpException;
import Grammaire.Expression;
import Programme.Robot;

public class Morethan extends Binaire {
	Expression head, tail;
	Expression passed;

	int avancement;

	// public List<Expression> getObject(){
	// return this;
	// }

	/**
	 * @param s1
	 *            head
	 * @param s2
	 *            tail
	 */
	public Morethan(Expression s1, Expression s2) {
		head = s1;
		tail = s2;
		passed = null;
	}

	public Morethan(Expression s1, Expression s2, int a) {
		head = s1;
		tail = s2;
		passed = null;
		avancement = a;
	}

	/**
	 * Execute head si possible sinon tail
	 * 
	 * @param head
	 *            une Expression
	 * @param tail
	 *            une autre Expression
	 */
	// TODO arriver a tester l execution de head sans l'executer
	public Expression morethan() {
		if (head.isExecutable())
			return head;
		else {
			return tail;
		}
	}
	
	private Expression morethan(Robot robot) {
		if (head.isExecutable(robot))
			return head;
		else {
			return tail;
		}
	}
	
	private Expression morethan(Robot r, int a) {
		if (head.isExecutable(r, a))
			return head;
		else {
			return tail;
		}
	}

	@Override
	public void exec() {
		Expression header = morethan();
		if (header != head)
			header.exec();
	}

	@Override
	public void exec(Robot robot) {
		Expression header = morethan(robot);
		if (header != head)
			header.exec(robot);
	}

	@Override
	public void exec(Robot r, int a) {
		if (a >= avancement) {
			// si on est jamais passe par la
			if (passed == null) {
				Expression header = morethan(r, a);
				if (header != head)
					header.exec(r, a);
			} else
				passed.exec(r,a);
		}
	}

	@Override
	public String toString() {
		return ("{av(" + avancement + ") " + head.toString() + " > " + tail.toString() + "}");
	}

	@Override
	public boolean isExecutable() {
		if (this.morethan().isExecutable()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isExecutable(Robot robot) {
		if (this.morethan(robot).isExecutable(robot)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isExecutable(Robot r, int a) {
		if (this.morethan(r, a).isExecutable(r, a)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getAvancement() {
		return avancement;
	}

	@Override
	public void setAvancement(int a) {
		if (avancement == 0)
			avancement = a;
		head.setAvancement(a);
		tail.setAvancement(a);

	}

	@Override
	public int getAvancementMax() {
		if (passed == null) {
			int AvHead = head.getAvancementMax();
			int AvTail = tail.getAvancementMax();
			if (AvHead >= AvTail)
				return AvHead;
			else
				return AvTail;
		}else
			return passed.getAvancementMax();
	}

	@Override
	public void resetPassed() {
		passed = null;
		head.resetPassed();
		tail.resetPassed();
		
	}
}
