package Programme;

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
	
	public Robot(int id_joueur){
		this.indice_joueur = id_joueur;
		listeRobot = new ImageView[16][16];
	}
	
	public void addRobotBleu(int x, int y, Plateau p, Group root){
		ImageView robot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu.png")));
		robot.setFitWidth(60);
		robot.setFitHeight(60);
		robot.setLayoutX(5 + x * 60);
		robot.setLayoutY(5 + y * 60);
		listeRobot[x][y] = robot;
		root.getChildren().add(robot);
		p.setCasePlateau(x, y, indice_joueur);
	}
	
	public void addRobotRouge(int x, int y, Plateau p, Group root){
		ImageView robot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge.png")));
		robot.setFitWidth(60);
		robot.setFitHeight(60);
		robot.setLayoutX(5 + x * 60);
		robot.setLayoutY(5 + y * 60);
		listeRobot[x][y] = robot;
		root.getChildren().add(robot);
		p.setCasePlateau(x, y, indice_joueur);
	}
	
}
