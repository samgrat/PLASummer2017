package Grammaire.Unaires;

import Grammaire.Unaire;

public class Repeat extends Unaire {

	public String toString() {
		return "R";
	}

	@Override
	public void exec() {
		// TODO Algo de Repeat:
		// Repete l action suivante un nombre n de fois...
		System.out.println("exec R");
	}
}
