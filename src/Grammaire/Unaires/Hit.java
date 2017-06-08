package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Hit extends Unaire {

	public String toString() {
		return "H";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec H");
	}

	@Override
	public void exec(Robot robot) {
		// TODO Algo de Hit:
		// le robot frappe en face de lui
		
	}
}
