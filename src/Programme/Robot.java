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
	private int indice_joueur;
	ImageView imageRobot;
	private Plateau plateau;
	private Expression express;

	public Robot(int id_joueur, Group root, Plateau p, Expression exp, int x, int y){
		this.indice_joueur = id_joueur;
		plateau = p;
		express = exp;
		setX(x);
		setY(y);
		
		if (id_joueur == 1) {
			imageRobot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu.png")));
			addRobot(x, y, plateau, root, imageRobot);
		} else {
			imageRobot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge.png")));
			addRobot(x, y, plateau, root, imageRobot);
		}
	}
	
	public void addRobot(int x, int y, Plateau p, Group root, ImageView robot){
		robot.setFitWidth(60);
		robot.setFitHeight(60);
		robot.setLayoutX(5 + x * 60);
		robot.setLayoutY(5 + y * 60);
		p.setCasePlateau(x, y, indice_joueur);
		root.getChildren().add(robot);
		
		Timeline tpsVieRobot = new Timeline(new KeyFrame(Duration.millis(5000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				imageRobot.setVisible(false);
				plateau.setCasePlateau(x, y, 0);
			}
		}));
		tpsVieRobot.play();
	}
	
	public void exec(int x, int y, Plateau p, Group root){
		this.plateau = p;
		this.x = x;
		this.y = y;
		express.exec(this);
		//addRobotBleu(this.x, this.y, root);
	}
	
}
