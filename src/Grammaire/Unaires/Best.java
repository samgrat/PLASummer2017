package Grammaire.Unaires;

import Grammaire.Unaire;

public class Best extends Unaire {
	
	public String toString() {
		return "B";
	}

	@Override
	public void exec() {
		// TODO algo de Best:
		// le robot se dirige vers la resource la plus recherchee par le joueur
		System.out.println("exec B");
		
	}
}
