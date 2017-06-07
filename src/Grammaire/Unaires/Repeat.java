package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Repeat extends Unaire {

	public String toString() {
		return "R";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec R");
	}

	@Override
	public void exec(int x, int y, Robot robot) {
		// TODO Algo de Repeat:
		// Repete l action suivante un nombre n de fois...
	}
}
