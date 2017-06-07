package Grammaire;

import Programme.Robot;

public class Liste implements Expression{
	Expression head;
	Expression tail;

	public Liste() {
		tail = new Nil();
		head = new Nil();
	}
	
	public Liste(Expression s1, Expression s2) {
		head = s1;
		tail = s2;

	}

	@Override
	public void exec() {
		head.exec();
		tail.exec();
		
	}
	
	public String toString(){
		return ("{h = " + head.toString() + " ; t = " + tail.toString() + "}");
	}

	@Override
	public boolean isExecutable() {
		if(head.isExecutable() && tail.isExecutable()){
			return true;
		}
		return false;
	}

	@Override
	public void exec(int x, int y, Robot robot) {
		head.exec(x, y, robot);
		tail.exec(x, y, robot);
	}

}
