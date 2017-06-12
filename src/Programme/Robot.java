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
	private Plateau plateau;
	private Expression express;
	private int count = 0;
	ImageView imageRobot;
	
	public Robot(Joueur j, Group root, Plateau p, Expression exp, int x, int y, int difficulte){
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
	
	public void addRobot(int x, int y, Plateau p, Group root, ImageView robot, Expression exp, int difficulte){
		
		robot.setScaleX(1.2);
		robot.setScaleY(1.2);
		robot.setFitWidth(60);
		robot.setFitHeight(60);
		robot.setLayoutX(5 + x * 60);
		robot.setLayoutY(5 + y * 60);
		p.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
		root.getChildren().add(robot);
		
		Timeline tpsVieRobot = new Timeline(new KeyFrame(Duration.millis(1000/difficulte), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(count == 50*difficulte){
					imageRobot.setVisible(false);
					plateau.setCasePlateau(getX(), getY(), 0);
				} else {
					count++;
					exec();
				}
			}
		}));
		tpsVieRobot.setCycleCount(50*difficulte+1);
		tpsVieRobot.play();
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
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutX(0);
			} else {
				if(indice == 2 && joueur.Indice_joueur() == 1)
				{
					
				} else if(indice == 1 && joueur.Indice_joueur() == 2) {
					
				}
				plateau.setCasePlateau(15, getY(), joueur.Indice_joueur()+2);
			}
		} else {
			indice = plateau.rechercher(getX() + 1, getY());
			if (indice > 10 || indice == 0) {
				setX(getX() + 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutX(imageRobot.getLayoutX() + 60);
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
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
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutX(900);
			} else {
				plateau.setCasePlateau(0, getY(), joueur.Indice_joueur()+2);
			}
		} else {
			indice = plateau.rechercher(getX()-1, getY());
			if (indice > 10 || indice == 0) {
				setX(getX() - 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutX(imageRobot.getLayoutX() - 60);
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
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
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutY(900);
			} else {
				plateau.setCasePlateau(getX(), 0, joueur.Indice_joueur()+2);
			}
		} else {
			indice = plateau.rechercher(getX(), getY() - 1);
			if (indice > 10 || indice == 0) {
				setY(getY() - 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutY(imageRobot.getLayoutY() - 60);
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
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
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutY(0);
			} else {
				plateau.setCasePlateau(getX(), 15, joueur.Indice_joueur()+2);
			}
		} else {
			indice = plateau.rechercher(getX(), getY() + 1);
			if (indice > 10 || indice == 0) {
				setY(getY() + 1);
				plateau.ramasser(getX(), getY(), joueur, indice);
				joueur.getScore().actuScore();
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
				imageRobot.setLayoutY(imageRobot.getLayoutY() + 60);
			} else {
				plateau.setCasePlateau(getX(), getY(), joueur.Indice_joueur()+2);
			}
		}
	}
	
	public void exec(){
		express.exec(this);
	}
	
}
