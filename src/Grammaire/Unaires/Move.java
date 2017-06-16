package Grammaire.Unaires;

import java.util.Random;

import Grammaire.Unaire;

import Programme.Robot;;

public class Move extends Unaire {
	
	int avancement;

	public String toString() {
		return "[M av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
	}
	
	// TODO changer le robot en param en consequence
	public void exec(Robot r) {
		// TODO Algo de Move:
		// le robot se deplace d une case dans une direction autre que arriere
		//System.out.println("exec M(robot)");
		
		Random R = new Random();
		int valeur = R.nextInt(3); // génere soit 2, soit 1, soit 0
		
		
		switch (valeur) {
		case 0:
			// TODO modifier le test d obstacles
			r.droite();
			break;
		case 1:
			r.gauche();
			break;
		case 2:
			r.monter();
			break;
		case 3:
			r.descendre();
			break;
		default:
			break;
		}
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement){
			exec(r);
		}
		
		
	}
	
	@Override
	public void setAvancement(int a) {
		if (avancement == 0)
			avancement = a;
	}
	
	@Override
	public int getAvancement() {
		return avancement;
	}
	
	@Override
	public int getAvancementMax() {
		return avancement;
	}
}

