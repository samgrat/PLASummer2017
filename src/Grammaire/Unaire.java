package Grammaire;

import Programme.Robot;

public abstract class Unaire implements Operateur {
	
	public abstract String toString();
	
	public boolean isExecutable(){
		try{
			exec();
			return true;
		}catch(ExpException e){
			return false;
		}
	}
	
	public boolean isExecutable(Robot robot){
		try{
			exec(robot);
			return true;
		}catch(ExpException e){
			return false;
		}
	}
	
	public boolean isExecutable(Robot r, int a){
		try{
			exec(r, a);
			return true;
		}catch(ExpException e){
			return false;
		}
	}
	
	public void resetPassed(){
		// pas de passed a reset dans un unaire
	}
	
	public String typeObject(){
		return "Unaire";
	}

	public abstract void setAvancement(int a);
	
	public abstract int getAvancement();
}
