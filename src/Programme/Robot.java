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
 * classe d'objet Robot
 * le robot est capable de se deplacer
 */
public class Robot extends Personnage {
	private Joueur joueur;
	ImageView imageRobot;
	private Plateau plateau;
	private Expression express;

	public Robot(Joueur j, Group root, Plateau p, Expression exp, int x, int y){
		joueur = j;
		plateau = p;
		express = exp;
		setX(x);
		setY(y);
		
		if (j.Indice_joueur() == 1) {
			imageRobot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu.png")));
			addRobot(x, y, plateau, root, imageRobot, exp);
		} else {
			imageRobot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge.png")));
			addRobot(x, y, plateau, root, imageRobot, exp);
		}
	}
	
	public void addRobot(int x, int y, Plateau p, Group root, ImageView robot, Expression exp){
		robot.setFitWidth(60);
		robot.setFitHeight(60);
		robot.setLayoutX(5 + x * 60);
		robot.setLayoutY(5 + y * 60);
		p.setCasePlateau(x, y, joueur.Indice_joueur());
		root.getChildren().add(robot);
		Robot r = this;
		Timeline tpsVieRobot = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int count = 0;
				if(count==5){
					imageRobot.setVisible(false);
					plateau.setCasePlateau(x, y, 0);
				}else {
					count++;
					exp.exec(r);
				}
			}
		}));
		tpsVieRobot.setCycleCount(5);
		tpsVieRobot.play();
	}
	
	public void droite() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur() + 2) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateX() + 60 > 959) {
			indice = plateau.rechercher(0, y);
			if (indice > 10 || indice == 0) {
				setX(0);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateX(0);
			} else {
				plateau.setCasePlateau(15, y, joueur.Indice_joueur());
			}
		} else {
			indice = plateau.rechercher(x + 1, y);
			if (indice > 10 || indice == 0) {
				setX(getX() + 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateX(this.getTranslateX() + 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
			}
		}
	}

	public void gauche() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur() + 2) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateX() - 60 < 0) {
			indice = plateau.rechercher(15, y);
			if (indice > 10 || indice == 0) {
				setX(15);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateX(900);
			} else {
				plateau.setCasePlateau(0, y, joueur.Indice_joueur());
			}
		} else {
			indice = plateau.rechercher(x - 1, y);
			if (indice > 10 || indice == 0) {
				setX(getX() - 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateX(this.getTranslateX() - 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
			}
		}
	}

	public void monter() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur() + 2) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateY() - 60 < 0) {
			indice = plateau.rechercher(x, 15);
			if (indice > 10 || indice == 0) {
				setY(15);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateY(900);
			} else {
				plateau.setCasePlateau(x, 0, joueur.Indice_joueur());
			}
		} else {
			indice = plateau.rechercher(x, y - 1);
			if (indice > 10 || indice == 0) {
				setY(getY() - 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateY(this.getTranslateY() - 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
			}
		}
	}

	public void descendre() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur() + 2) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateY() + 60 > 959) {
			indice = plateau.rechercher(x, 0);
			if (indice > 10 || indice == 0) {
				setY(0);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateY(0);
			} else {
				plateau.setCasePlateau(x, 15, joueur.Indice_joueur());
			}
		} else {
			indice = plateau.rechercher(x, y + 1);
			if (indice > 10 || indice == 0) {
				setY(getY() + 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				this.setTranslateY(this.getTranslateY() + 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
			}
		}
	}
	
	public void exec(int x, int y, Plateau p){
		this.plateau = p;
		this.x = x;
		this.y = y;
		express.exec(this);
		//addRobotBleu(this.x, this.y, root);
	}
	
}
