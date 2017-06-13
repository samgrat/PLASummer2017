package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Explore extends Unaire {
	
	int avancement;

	public String toString() {
		return "[E av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec E");
	}

	@Override
	public void exec(Robot robot) {
		// TODO Algo de Explore:
		// le robot se dirige vers une case non exploree en prenant un chemin aleatoire
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement)
			System.out.println("exec E avancement " + avancement);
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
}
