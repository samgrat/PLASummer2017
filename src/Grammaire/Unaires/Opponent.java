package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Opponent extends Unaire {
	
	int avancement;

	public String toString() {
		return "[O av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec O");
	}

	@Override
	public void exec(Robot robot) {
		// TODO Algo de Opponent:
		// le robot se dirige vers l adversaire le plus proche
		
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement)
			System.out.println("exec O avancement " + avancement);
		
	}
	
	@Override
	public void setAvancement(int a) {
		if (avancement == 0)
			avancement = a;
	}
	
	@Override
	public int getAvancement() {
		return avancement;
	}
	
	@Override
	public int getAvancementMax() {
		return avancement;
	}
}
