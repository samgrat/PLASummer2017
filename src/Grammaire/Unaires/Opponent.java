package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Opponent extends Unaire {

	public String toString() {
		return "O";
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
}
