package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Protect extends Unaire {

	public String toString() {
		return "P";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec P");
	}

	@Override
	public void exec(int x, int y, Robot robot) {
		// TODO Algo de Protect:
		// le robot se protege contre un attaque
	}
}
