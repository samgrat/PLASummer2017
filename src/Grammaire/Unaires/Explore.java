package Grammaire.Unaires;

import Dijkstra_explore.Dijkstra;
import Grammaire.Unaire;
import Programme.Robot;

public class Explore extends Unaire {

	int avancement;

	public String toString() {
		return "[E av(" + avancement + ")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec E");
	}

	@Override
	public void exec(Robot robot) {
		int posR = robot.getX() + robot.getY() * 16;
		int posJ;
		if (robot.getJoueur().Indice_joueur() == 1)
			posJ = robot.getPlateau().getJoueur(2).getX() + robot.getPlateau().getJoueur(2).getY() * 16;
		else
			posJ = robot.getPlateau().getJoueur(1).getX() + robot.getPlateau().getJoueur(1).getY() * 16;

		Dijkstra d = new Dijkstra(robot.getPlateau(), posR, posJ);
		if (d.chemin.size() > 1) {
			switch (d.chemin.get(1) - d.chemin.get(0)) {
			case 16:
				robot.descendre();
				break;
			case -16:
				robot.monter();
				break;
			case 1:
				robot.droite();
				break;
			case -1:
				robot.gauche();
				break;
			case 240:
				robot.monter();
				break;
			case -240:
				robot.descendre();
				break;
			case 15:
				robot.gauche();
				break;
			case -15:
				robot.droite();
				break;
			default:
				System.out.println(d.chemin.get(1) + " - " + d.chemin.get(0));
				break;
			}
		}
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement) {
			System.out.println("exec E avancement " + avancement);
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
