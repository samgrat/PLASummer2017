package Grammaire;

import Programme.Robot;

public interface Operateur extends Expression{

	public String toString();
	
	@Override
	public void exec();

}
