package Grammaire;

public class DijkException extends RuntimeException {
	
	static final long serialVersionUID = 43;
	Exception dijkException;
	
	public DijkException()
	{
		dijkException = new Exception();
	}
}