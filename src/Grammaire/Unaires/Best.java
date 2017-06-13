package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Best extends Unaire {
	
	int avancement;

	public String toString() {
		return "[B av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec B");

	}

	@Override
	public void exec(Robot robot) {
		// TODO algo de Best:
		// le robot se dirige vers la resource la plus recherchee par le joueur
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement)
			System.out.println("exec B avancement " + avancement);
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
