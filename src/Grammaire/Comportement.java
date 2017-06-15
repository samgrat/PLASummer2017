package Grammaire;

import Programme.Robot;

public class Comportement {
	private int avancement;
	private Expression exp;
	
	public Comportement(Expression e){
		e.setAvancement(0);
		exp = e;
		avancement = 0;
	}
	
	public void exec(Robot r){
		try{
		exp.exec(r, avancement);
		}catch(ExpException e){
			
		}
		// lorsquon atteint l avancement max on boucle
		if( avancement < exp.getAvancementMax())
			avancement++;
		else{
			avancement = 0;
			exp.resetPassed();
		}
	}
	
	public String toString(){
		return ("Comportement: "+exp.toString()+" av = "+avancement);
	}

}
