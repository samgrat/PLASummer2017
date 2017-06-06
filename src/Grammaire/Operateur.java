package Grammaire;

public interface Operateur extends Expression{

	public String toString();
	
	@Override
	public void exec();

}
