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
	private int count = 0;

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
		p.setCasePlateau(x, y, joueur.Indice_joueur()+2);
		root.getChildren().add(robot);
		//Robot r = this;
		
		Timeline tpsVieRobot = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(count == 5){
					imageRobot.setVisible(false);
					plateau.setCasePlateau(x, y, 0);
				} else {
					count++;
					exec();
				}
			}
		}));
		tpsVieRobot.setCycleCount(6);
		tpsVieRobot.play();
	}
	
	public void droite() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (getX() + 1 > 15) {
			indice = plateau.rechercher(0, y);
			if (indice > 10 || indice == 0) {
				setX(0);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur());
				imageRobot.setTranslateX(0);
			} else {
				plateau.setCasePlateau(15, y, joueur.Indice_joueur());
			}
		} else {
			indice = plateau.rechercher(x + 1, y);
			if (indice > 10 || indice == 0) {
				setX(getX() + 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
				imageRobot.setTranslateX(imageRobot.getTranslateX() + 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
			}
		}
	}

	public void gauche() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (getX() - 1 < 0) {
			indice = plateau.rechercher(15, y);
			if (indice > 10 || indice == 0) {
				setX(15);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
				imageRobot.setTranslateX(900);
			} else {
				plateau.setCasePlateau(0, y, joueur.Indice_joueur()+2);
			}
		} else {
			indice = plateau.rechercher(x-1, y);
			if (indice > 10 || indice == 0) {
				setX(getX() - 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
				imageRobot.setTranslateX(imageRobot.getTranslateX() - 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
			}
		}
	}

	public void monter() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (getY() - 1 < 0) {
			indice = plateau.rechercher(x, 15);
			if (indice > 10 || indice == 0) {
				setY(15);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
				imageRobot.setTranslateY(900);
			} else {
				plateau.setCasePlateau(x, 0, joueur.Indice_joueur()+2);
			}
		} else {
			indice = plateau.rechercher(x, y - 1);
			if (indice > 10 || indice == 0) {
				setY(getY() - 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
				imageRobot.setTranslateY(imageRobot.getTranslateY() - 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
			}
		}
	}

	public void descendre() {
		int indice = plateau.rechercher(x, y);
		if (indice != joueur.Indice_joueur()) {
			plateau.setCasePlateau(x, y, 0);
		}
		if (getY() + 1 > 15) {
			indice = plateau.rechercher(x, 0);
			if (indice > 10 || indice == 0) {
				setY(0);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
				imageRobot.setTranslateY(0);
			} else {
				plateau.setCasePlateau(x, 15, joueur.Indice_joueur()+2);
			}
		} else {
			indice = plateau.rechercher(x, y + 1);
			if (indice > 10 || indice == 0) {
				setY(getY() + 1);
				plateau.ramasser(x, y, joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
				imageRobot.setTranslateY(imageRobot.getTranslateY() + 60);
			} else {
				plateau.setCasePlateau(x, y, joueur.Indice_joueur()+2);
			}
		}
	}
	
	public void exec(){
		express.exec(this);
	}
	
}
