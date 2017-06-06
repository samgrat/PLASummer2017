package Grammaire.Unaires;

import Grammaire.Unaire;

public class Gather extends Unaire {

	public String toString() {
		return "G";
	}

	@Override
	public void exec() {
		// TODO Algo de Gather
		// le robot recolte une ressource dans un perimetre autour de lui
		System.out.println("exec G");
	}
}
