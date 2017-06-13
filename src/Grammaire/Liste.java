package Grammaire;

import Programme.Robot;

public class Liste implements Expression {
	Expression head;
	Expression tail;
	int avancement;

	public Liste() {
		tail = new Nil();
		head = new Nil();
	}

	public Liste(Expression s1, Expression s2) {
		head = s1;
		tail = s2;

	}

	public Liste(Expression s1, Expression s2, int a) {
		head = s1;
		tail = s2;
		avancement = a;

	}

	@Override
	public void exec() {
		head.exec();
		tail.exec();

	}

	public String toString() {
		return ("{av(" + avancement + ") " + head.toString() + " ; " + tail.toString() + "}");
	}

	@Override
	public boolean isExecutable() {
		if (head.isExecutable() && tail.isExecutable()) {
			return true;
		}
		return false;
	}

	@Override
	public void exec(Robot robot) {
		head.exec(robot);
		tail.exec(robot);
	}

	public String typeObject() {
		return "Liste";
	}

	@Override
	public void exec(Robot r, int a) {
		if (a >= avancement) {
			head.exec(r, a);
			tail.exec(r, a);
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
		tail.setAvancement(a + 1);
	}

	@Override
	public int getAvancementMax() {
		int AvHead = head.getAvancementMax();
		int AvTail = tail.getAvancementMax();
		
		if(AvHead >= AvTail)
			return AvHead;
		else
			return AvTail;
	}

}
