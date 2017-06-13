package Grammaire.Binaires;

import java.util.Random;

import Grammaire.Binaire;
import Grammaire.Expression;
import Programme.Robot;

public class Pipe extends Binaire {
	Expression head, tail;
	Expression passed;
	int avancement;

	/**
	 * @param s1
	 *            head
	 * @param s2
	 *            tail
	 */
	public Pipe(Expression s1, Expression s2) {
		head = s1;
		tail = s2;
		passed = null;
	}

	public Pipe(Expression s1, Expression s2, int a) {
		head = s1;
		tail = s2;
		passed = null;
		avancement = a;
	}

	/**
	 * Execute aleatoirement head ou tail
	 * 
	 * @param head
	 *            une Expression
	 * @param tail
	 *            une autre Expression
	 */

	public Expression pipe() {

		Random r = new Random();
		int valeur = r.nextInt(2); // génere soit 1, soit 0

		switch (valeur) {
		case 0:
			passed = head;
			return head;
		case 1:
			passed = tail;
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
		return ("{av(" + avancement + ") " + head.toString() + " | " + tail.toString() + "}");
	}

	@Override
	public boolean isExecutable() {
		if (this.pipe().isExecutable()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isExecutable(Robot robot) {
		if (this.pipe().isExecutable(robot)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isExecutable(Robot r, int a) {
		if (this.pipe().isExecutable(r, a)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void exec(Robot robot) {
		pipe().exec(robot);

	}

	@Override
	public void exec(Robot r, int a) {
		if (a >= avancement) {
			// si on a jamais execute l arbre
			if(passed == null)
				pipe().exec(r, a);
			else
				passed.exec(r, a);
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
