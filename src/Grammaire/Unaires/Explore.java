package Grammaire.Unaires;

import Dijkstra_explore.Dijkstra;
import Grammaire.Unaire;
import Programme.Robot;

public class Explore extends Unaire {

	public String toString() {
		return "E";
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
		if(robot.getJoueur().Indice_joueur() == 1)
			posJ = robot.getPlateau().getJoueur(2).getX() + robot.getPlateau().getJoueur(2).getY() * 16;
		else posJ = robot.getPlateau().getJoueur(1).getX() + robot.getPlateau().getJoueur(1).getY() * 16;
		Dijkstra d = new Dijkstra(robot.getPlateau(), posR, posJ);
		System.out.print("Chemin = [ ");
		for (int i = 0; i < d.chemin.size(); i++) {
			System.out.print(d.chemin.get(i) + " ");
		}
		System.out.println("]");
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
}
