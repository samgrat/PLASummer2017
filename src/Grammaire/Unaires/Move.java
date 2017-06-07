package Grammaire.Unaires;

import java.util.Random;

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
	public void exec(int x, int y, Robot r) {
		// TODO Algo de Move:
		// le robot se deplace d une case dans une direction autre que arriere
		//System.out.println("exec M(robot)");
		
		Random R = new Random();
		int valeur = R.nextInt(3); // génere soit 2, soit 1, soit 0
		int valtest = 0;
		
		switch (valtest) {
		case 0:
			// TODO modifier le test d obstacles
			r.droite(x, y);
			break;
		case 1:
			r.gauche();
			break;
		case 2:
			r.monter();
			break;
		default:
			break;
		}
	}
}

