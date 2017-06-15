package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Gather extends Unaire {
	
	int avancement;

	public String toString() {
		return "[G av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec G");
	}

	@Override
	public void exec(Robot robot) {
		// TODO Algo de Gather
		// le robot recolte une ressource dans un perimetre autour de lui
		
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement)
			System.out.println("exec G avancement " + avancement);
		
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
