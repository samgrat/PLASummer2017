package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;


public class Hit extends Unaire {
	
	int avancement;

	public String toString() {
		return "[H av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec H");
	}

	@Override
	public void exec(Robot robot) {
		int a;
		int x = robot.getX() ;
		int y = robot.getY() ; 
		if (robot.getJoueur().Indice_joueur() == 1) {
			a = 2;
		} else if (robot.getJoueur().Indice_joueur() == 2) {
			a = 1;
		} else {
			a = 0;
			System.out.println("erreur, a=0");
		}

		int x1 = x + 1, y1 = y + 1, x2 = x - 1, y2 = y - 1;

		if (x + 1 > 15) {
			x1 = 0;
		} else if (x - 1 < 0) {
			x2 = 15;
		}

		if (y + 1 > 15) {
			y1 = 0;
		} else if (y - 1 < 0) {
			y2 = 15;
		}

		if (robot.getPlateau().rechercher(x1, y) == a || robot.getPlateau().rechercher(x2, y) == a || robot.getPlateau().rechercher(x, y1) == a
				|| robot.getPlateau().rechercher(x, y2) == a) {
			robot.getPlateau().getJoueur(a).perdVie();}
		
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement){
			System.out.println("exec H avancement " + avancement);
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
