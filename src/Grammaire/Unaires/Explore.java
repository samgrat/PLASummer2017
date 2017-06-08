package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Explore extends Unaire {

	public String toString() {
		return "E";
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
}
