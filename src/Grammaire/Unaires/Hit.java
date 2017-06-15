package Grammaire.Unaires;

import Grammaire.ExpException;
import Grammaire.Unaire;
import Graphique.Plateau;
import Programme.Robot;

public class Hit extends Unaire {

	int avancement;

	public String toString() {
		return "[H av(" + avancement + ")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec H");
	}

	@Override
	public void exec(Robot robot) {

		// le robot frappe autour de lui
		Plateau p = robot.getPlateau();

		int X = robot.getX();
		int X2 = robot.getX();
		int Y = robot.getY();
		int Y2 = robot.getY();

		if (robot.getX() + 1 > 15) {
			X = -1;
		} else if (robot.getX() - 1 < 0) {
			X2 = 16;
		}

		else {
			X = robot.getX();
		}

		if (robot.getY() + 1 > 15) {
			Y = -1;
			System.out.println("Y+1>15");
		} else if (robot.getY() - 1 < 0) {
			Y2 = 16;
			System.out.println("Y-1<0");
		}

		// Si le robot appartient au joueur1

		if (robot.getJoueur().Indice_joueur() == 1) {
			if (p.rechercher(X + 1, robot.getY()) != 2) {
				if (p.rechercher(robot.getX(), Y + 1) != 2) {
					if (p.rechercher(X2 - 1, robot.getY()) != 2) {
						if (p.rechercher(robot.getX(), Y2 - 1) != 2) {
							throw new ExpException();
						} else {
							robot.getPlateau().getJoueur(2).perdVie();
						}
					} else {
						robot.getPlateau().getJoueur(2).perdVie();
					}
				} else {
					robot.getPlateau().getJoueur(2).perdVie();
					// System.out.println("Taper coordonné : X ="+robot.getX()
					// +"Y =" + (Y+1) );

				}
			} else {
				robot.getPlateau().getJoueur(2).perdVie();
				// System.out.println("Taper coordonné : X ="+ (X+1) +"Y ="+
				// robot.getY() );
			}
		}

		// Si le robot apaprtient au joueur2
		else {
			if (p.rechercher(X + 1, robot.getY()) != 1) {
				if (p.rechercher(robot.getX(), Y + 1) != 1) {
					if (p.rechercher(X2 - 1, robot.getY()) != 1) {
						if (p.rechercher(robot.getX(), Y2 - 1) != 1) {
							throw new ExpException();
						} else {
							robot.getPlateau().getJoueur(1).perdVie();
						}
					} else {
						robot.getPlateau().getJoueur(1).perdVie();
					}
				} else {
					robot.getPlateau().getJoueur(1).perdVie();
				}
			} else {
				robot.getPlateau().getJoueur(1).perdVie();
			}
		}
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement) {
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
		// TODO Algo de Hit:$

	}
}
