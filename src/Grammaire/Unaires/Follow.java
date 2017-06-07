package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Follow extends Unaire{

	public String toString() {
		return "F";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec F");
	}

	@Override
	public void exec(int x, int y, Robot robot) {
		// TODO Algo de Follow:
		// le robot suit le robot allie le plus proche
		
	}
}
