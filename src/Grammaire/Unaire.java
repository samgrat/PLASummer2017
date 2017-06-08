package Grammaire;

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
}
