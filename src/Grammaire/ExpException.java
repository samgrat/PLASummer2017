package Grammaire;

public class ExpException extends RuntimeException {
	
	static final long serialVersionUID = 42;
	Exception expException;
	
	public ExpException()
	{
		expException = new Exception();
	}
}