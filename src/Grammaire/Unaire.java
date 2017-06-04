package Grammaire;

import java.util.HashMap;
import java.util.Map;

public class Unaire extends Operateur {
	private String sym;
	static Map<String, Unaire> contexteSym = new HashMap<String, Unaire>();
	
	public Unaire()
	{
		sym = "";
	}
	
	//public Unaire(String sym)
	//{
	//	this.sym = sym;
	//}
	
	public String toString(){
		return sym;
	}

//	static public Unaire NewSymbole(String sym)
//	{
//		if(contexteSym.containsKey(sym)) return contexteSym.get(sym);
//		Unaire s = new Unaire(sym);
//		contexteSym.put(sym, s);
//		return s;
//	}

	public static Expression Unaire(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
