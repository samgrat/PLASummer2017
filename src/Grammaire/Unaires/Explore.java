package Grammaire.Unaires;

import Dijkstra_explore.Dijkstra;
import Grammaire.DijkException;
import Grammaire.Unaire;
import Programme.Robot;

public class Explore extends Unaire {

	int avancement;
	int direction;

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
		int posJX, posJY, indpos;
		int newpos;
		direction = 0;
		Dijkstra d = new Dijkstra();

		int posR = robot.getX() + robot.getY() * 16;
		int posJ;
		if (robot.getJoueur().Indice_joueur() == 1)
			posJ = robot.getPlateau().getJoueur(2).getX() + robot.getPlateau().getJoueur(2).getY() * 16;
		else
			posJ = robot.getPlateau().getJoueur(1).getX() + robot.getPlateau().getJoueur(1).getY() * 16;

		do {
			newpos = lookAround(posJ, direction);

			posJX = postoX(newpos);
			posJY = postoY(newpos);
			indpos = robot.getPlateau().rechercher(posJX, posJY);
			//System.out.println("case X = " + posJX + " Y = " + posJY + " indpos = " + indpos);

			direction++;
		} while (indpos != 0 && indpos <= 10);

		try {
			d = new Dijkstra(robot.getPlateau(), posR, newpos);
		} catch (DijkException e1) {
			newpos = lookAround(posJ, direction);

			posJX = postoX(newpos);
			posJY = postoY(newpos);
			indpos = robot.getPlateau().rechercher(posJX, posJY);
			//System.out.println("case X = " + posJX + " Y = " + posJY + " indpos = " + indpos);
			
			direction++;
			try {
				d = new Dijkstra(robot.getPlateau(), posR, newpos);
			} catch (DijkException e2) {

				newpos = lookAround(posJ, direction);

				posJX = postoX(newpos);
				posJY = postoY(newpos);
				indpos = robot.getPlateau().rechercher(posJX, posJY);
				//System.out.println("case X = " + posJX + " Y = " + posJY + " indpos = " + indpos);

				direction++;
				try {
					d = new Dijkstra(robot.getPlateau(), posR, newpos);
				} catch (DijkException e3) {

					newpos = lookAround(posJ, direction);

					posJX = postoX(newpos);
					posJY = postoY(newpos);
					indpos = robot.getPlateau().rechercher(posJX, posJY);
					//System.out.println("case X = " + posJX + " Y = " + posJY + " indpos = " + indpos);

					direction++;
					try {
						d = new Dijkstra(robot.getPlateau(), posR, newpos);
					} catch (DijkException e4) {
						System.out.println("Erreur: le robot ne peut pas bouger près du joueur");
					}
				}
			}
		}

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

	private int lookAround(int posJ, int dir) {
		int newpos;

		switch (dir) {
		// on regarde a gauche
		case 0:
			newpos = posJ - 1;
			if (newpos <= 0 || newpos > 255)
				newpos = posJ + 15;
			return newpos;
		// on regarde en haut
		case 1:
			newpos = posJ - 16;
			if (newpos <= 0 || newpos > 255)
				newpos = posJ + 240;
			return newpos;
		// on regarde a droite
		case 2:
			newpos = posJ + 1;
			if (newpos <= 0 || newpos > 255)
				newpos = posJ - 15;
			return newpos;
		// on regarde en bas
		case 3:
			newpos = posJ + 16;
			if (newpos <= 0 || newpos > 255)
				newpos = posJ - 240;
			return newpos;
		default:
			System.out.println("Erreur: la cible est entouree");
			direction = 0;
			return posJ;
		}
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement) {
			//System.out.println("exec E avancement " + avancement);
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

	public int postoX(int pos) {
		return (pos % 16);
	}

	public int postoY(int pos) {
		return (pos - (pos % 16)) / 16;
	}
}
