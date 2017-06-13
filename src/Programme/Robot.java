package Programme;

import Grammaire.*;
import Graphique.Main;
import Graphique.Plateau;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * classe d'objet Robot le robot est capable de se deplacer
 */
public class Robot extends Personnage {
	private Joueur joueur;
	private Plateau plateau;
	private Expression express;
	private int count = 0;
	ImageView imageRobot;
	
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	public Robot(Joueur j, Group root, Plateau p, Expression exp, int x, int y, int difficulte) {
		joueur = j;
		plateau = p;
		express = exp;
		setX(x);
		setY(y);

		if (j.Indice_joueur() == 1) {
			imageRobot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu.png")));
			addRobot(getX(), getY(), plateau, root, imageRobot, exp, difficulte);
		} else {
			imageRobot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge.png")));
			addRobot(getX(), getY(), plateau, root, imageRobot, exp, difficulte);
		}
	}

	public void addRobot(int x, int y, Plateau p, Group root, ImageView robot, Expression exp, int difficulte) {

		robot.setScaleX(1.2);
		robot.setScaleY(1.2);
		robot.setFitWidth(plateau.getSize());
		robot.setFitHeight(plateau.getSize());
		robot.setLayoutX(5 + x * plateau.getSize());
		robot.setLayoutY(5 + y * plateau.getSize());
		// p.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
		root.getChildren().add(robot);

		Timeline tpsVieRobot = new Timeline(
				new KeyFrame(Duration.millis(1000 / difficulte), new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if (count == 50 * difficulte) {
							imageRobot.setVisible(false);
							plateau.setCasePlateau(getX(), getY(), 0);
						} else {
							count++;
							exec();
						}
					}
				}));
		tpsVieRobot.setCycleCount(50 * difficulte + 1);
		tpsVieRobot.play();
	}

	public void hit(int x, int y) {
		int a;
		if (joueur.Indice_joueur() == 1) {
			a = 2;
		} else if (joueur.Indice_joueur() == 2) {
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

		if (plateau.rechercher(x1, y) == a || plateau.rechercher(x2, y) == a || plateau.rechercher(x, y1) == a
				|| plateau.rechercher(x, y2) == a) {
			plateau.getJoueur1(a).perdVie();
		}

	}

	public void droite() {
		int indice = plateau.rechercher(getX(), getY());
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(getX(), getY(), 0);
		}
		if (getX() + 1 > 15) {
			indice = plateau.rechercher(0, getY());
			if (indice > 10 || indice == 0) {
				setX(0);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutX(0);
			} else {
				plateau.setCasePlateau(15, getY(), joueur.Indice_joueur() + 2);
			}
		} else {
			indice = plateau.rechercher(getX() + 1, getY());
			if (indice > 10 || indice == 0) {
				setX(getX() + 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutX(imageRobot.getLayoutX() + plateau.getSize());
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
			}
		}
	}

	public void gauche() {
		int indice = plateau.rechercher(getX(), getY());
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(getX(), getY(), 0);
		}
		if (getX() - 1 < 0) {
			indice = plateau.rechercher(15, getY());
			if (indice > 10 || indice == 0) {
				setX(15);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutX(15*plateau.getSize());
			} else {
				plateau.setCasePlateau(0, getY(), joueur.Indice_joueur() + 2);
			}
		} else {
			indice = plateau.rechercher(getX() - 1, getY());
			if (indice > 10 || indice == 0) {
				setX(getX() - 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutX(imageRobot.getLayoutX() - plateau.getSize());
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
			}
		}
	}

	public void monter() {
		int indice = plateau.rechercher(getX(), getY());
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(getX(), getY(), 0);
		}
		if (getY() - 1 < 0) {
			indice = plateau.rechercher(getX(), 15);
			if (indice > 10 || indice == 0) {
				setY(15);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutY(15*plateau.getSize());
			} else {
				plateau.setCasePlateau(getX(), 0, joueur.Indice_joueur() + 2);
			}
		} else {
			indice = plateau.rechercher(getX(), getY() - 1);
			if (indice > 10 || indice == 0) {
				setY(getY() - 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutY(imageRobot.getLayoutY() - plateau.getSize());
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
			}
		}
	}

	public void descendre() {
		int indice = plateau.rechercher(getX(), getY());
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(getX(), getY(), 0);
		}
		if (getY() + 1 > 15) {
			indice = plateau.rechercher(getX(), 0);
			if (indice > 10 || indice == 0) {
				setY(0);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutY(0);
			} else {
				plateau.setCasePlateau(getX(), 15, joueur.Indice_joueur() + 2);
			}
		} else {
			indice = plateau.rechercher(getX(), getY() + 1);
			if (indice > 10 || indice == 0) {
				setY(getY() + 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				hit(getX(), getY());
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
				imageRobot.setLayoutY(imageRobot.getLayoutY() + plateau.getSize());
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur() + 2);
			}
		}
	}

	public void exec() {
		express.exec(this);
	}

}
