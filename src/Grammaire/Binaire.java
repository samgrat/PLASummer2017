package Grammaire;

public class Binaire extends Operateur {

	/**
	 * Execute head si possible sinon tail
	 * @param head une Expression
	 * @param tail une autre Expression
	 */
	public static Expression morethan(Expression head, Expression tail){
		
		return head;
	}
	
	/**
	 * Execute aleatoirement head ou tail
	 * @param head une Expression
	 * @param tail une autre Expression
	 */
	public static Expression pipe(Expression head, Expression tail){
		// TODO rand(0,1)
		// si 0 exec(head)
		// si 1 exec(tail)
		return head;
	}
}
