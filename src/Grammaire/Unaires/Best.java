package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Best extends Unaire {
	
	public String toString() {
		return "B";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec B");
		
	}

	@Override
	public void exec(int x, int y, Robot robot) {
		// TODO algo de Best:
		// le robot se dirige vers la resource la plus recherchee par le joueur
	}
}
