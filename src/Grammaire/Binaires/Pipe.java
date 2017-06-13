package Grammaire.Binaires;

import java.util.Random;

import Grammaire.Binaire;
import Grammaire.Expression;
import Programme.Robot;

public class Pipe extends Binaire {
	Expression head, tail;
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
	}

	public Pipe(Expression s1, Expression s2, int a) {
		head = s1;
		tail = s2;
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
			// head.exec();
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
	public void exec(Robot robot) {
		pipe().exec(robot);

	}

	@Override
	public void exec(Robot r, int a) {
		if (a >= avancement) {
			pipe().exec(r);
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
}
