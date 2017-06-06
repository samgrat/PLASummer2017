package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Gather extends Unaire {

	public String toString() {
		return "G";
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
}
