package Programme;

import Grammaire.*;
import Graphique.Main;
import Graphique.Plateau;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * classe d'objet Robot
 * le robot est capable de se deplacer
 */
public class Robot extends Personnage {
	private int indice_joueur;
	private ImageView[][] listeRobot;

	private Plateau plateau;
	private Expression express;

	public Robot(int id_joueur, Plateau p, Expression exp){
		this.indice_joueur = id_joueur;
		listeRobot = new ImageView[16][16];
		plateau = p;
		express = exp;
	}
	
	public void addRobotBleu(int x, int y, Plateau p, Group root){
		ImageView robot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu.png")));
		addRobot(x, y, p, root, robot);
	}
	
	
	public void addRobotRouge(int x, int y, Plateau p, Group root){
		ImageView robot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge.png")));
		addRobot(x, y, p, root, robot);
	}
	
	public void addRobot(int x, int y, Plateau p, Group root, ImageView robot){
		robot.setFitWidth(60);
		robot.setFitHeight(60);
		robot.setLayoutX(5 + x * 60);
		robot.setLayoutY(5 + y * 60);
		listeRobot[x][y] = robot;
		root.getChildren().add(robot);
		p.setCasePlateau(x, y, indice_joueur);
	}
	
	public void exec(int x, int y, Plateau p, Group root){
		this.plateau = p;
		this.x = x;
		this.y = y;
		express.exec(this);
		addRobotBleu(this.x, this.y, p, root);
	}
	
}
