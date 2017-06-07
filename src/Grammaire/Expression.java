package Grammaire;

import Programme.Robot;

public interface Expression {

	void exec();
	
	String toString();
	
	boolean isExecutable();

	void exec(Robot robot);

}
