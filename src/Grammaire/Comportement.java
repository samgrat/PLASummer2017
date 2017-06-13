package Grammaire;

import Programme.Robot;

public class Comportement {
	private int avancement;
	private Expression exp;
	
	public Comportement(Expression e){
		exp = e;
		avancement = 0;
	}
	
	public void exec(Robot r){
		exp.exec(r, avancement);
		// lorsquon atteint l avancement max on boucle
		if( avancement < exp.getAvancementMax())
			avancement++;
		else
			avancement = 0;
	}
	
	public String toString(){
		return ("Comportement: "+exp.toString()+" av = "+avancement);
	}

}
