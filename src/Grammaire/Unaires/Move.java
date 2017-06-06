package Grammaire.Unaires;

import Grammaire.Unaire;

import Programme.Robot;;

public class Move extends Unaire {

	public String toString() {
		return "M";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec M");
	}
	
	// TODO changer le robot en param en consequence
	public void exec(Robot r) {
		// TODO Algo de Move:
		// le robot se deplace d une case dans une direction autre que arriere
		
		System.out.println("exec M(robot)");
	}
}

