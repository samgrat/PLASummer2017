package Grammaire;

import Programme.Robot;

public interface Expression {

	void exec();
	
	String toString();
	
	boolean isExecutable();

	void exec(Robot robot);

	void exec(Robot r, int avancement);

	int getAvancement();
	
	void setAvancement(int a);

	int getAvancementMax();

	boolean isExecutable(Robot robot);

	boolean isExecutable(Robot r, int a);

	public void resetPassed();

}
