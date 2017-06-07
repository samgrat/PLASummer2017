package Programme;

import Grammaire.*;
import Graphique.Main;
import Graphique.Plateau;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * classe d'objet Robot
 * le robot est capable de se deplacer
 */
public class Robot extends Personnage {
	private int pv = 1;
	private int indice_robot;
	private ImageView[][] listeRobot;
	private Plateau p;
	private Expression express;
	Rectangle vie1;
	
	public Robot(int id_joueur, Plateau p, Expression exp){
		System.out.println("constructeur robot");
		this.indice_robot = id_joueur+2;
		listeRobot = new ImageView[16][16];
		this.p = p;
		express = exp;
	}
	
	public void addRobotBleu(int x, int y, Plateau p, Group root){
		System.out.println("robot bleu");
		ImageView robot = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu.png")));
		addRobot(x, y, p, root, robot);
	}
	
	public void addRobotRouge(int x, int y, Plateau p, Group root){
		System.out.println("robot rouge");
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
		p.setCasePlateau(x, y, indice_robot);
		int test = 0;
		while(test < 100){
			this.exec(x, y, root);
			test++;
		}
	}
	
	public void exec(int x, int y, Group root){
		//test
		this.x = x;
		this.y = y;
		express.exec(this);
	}
	
	public void afficherVie() {
		vie1 = new Rectangle();
		vie1.setWidth(15);
		vie1.setHeight(8);
		vie1.setArcWidth(5);
		vie1.setArcHeight(5);
		vie1.setFill(Color.LIGHTGREEN);
		vie1.setLayoutX(12);
		vie1.setLayoutY(56);
		this.getChildren().add(vie1);
	}
	
	public void actualiserVie() {
		switch (this.pv) {
		case 0:
			vie1.setVisible(false);
			break;
		case 1:
			vie1.setVisible(true);
			break;
		default:
			this.pv = 1;
			vie1.setVisible(true);
			break;
		}
	}
	
	public void perdVie() {
		this.pv--;
		actualiserVie();
	}

	public void droite() {
		// on recupere la position locale
		int x = (int) this.getTranslateX() / 60;
		int y = (int) this.getTranslateY() / 60;
		// on recupere l indice de la case (x,y)
		int indice = p.rechercher(x, y);
		System.out.println("indice =" +p.getCasePlateau(x,y));
		// si l indice recupere est different de l indice du joueur
//		if (indice != indice_robot-2) {
//			p.setCasePlateau(x, y, 0);
//			System.out.println(p.getCasePlateau(x,y));
//		}
		// si on sort du donut
		if (this.getTranslateX() + 60 > 959) {
			x = 0;
			y = (int) this.getTranslateY() / 60;
			indice = p.rechercher(x, y);
			// si la case vise est vide ou n a pas d obstacle
			if (indice > 10 || indice == 0) {

				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateX(0);

			} else {
				//this.perdVie();
			}

		} else {
			x = (int) this.getTranslateX() / 60 + 1;
			y = (int) (this.getTranslateY() / 60);
			indice = p.rechercher(x, y);
			if (indice > 10 || indice == 0) {

				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateX(this.getTranslateX() + 60);

			} else {
				//this.perdVie();
			}

		}
	}

	public void gauche() {
		int x = (int) this.getTranslateX() / 60;
		int y = (int) this.getTranslateY() / 60;
		int indice = p.rechercher(x, y);
		if (indice != indice_robot-2) {
			p.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateX() - 60 < 0) {
			x = 15;
			y = (int) this.getTranslateY() / 60;
			indice = p.rechercher(x, y);
			if (indice > 10 || indice == 0) {

				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateX(900);

			} else {
				//this.perdVie();
			}

		} else {
			x = (int) this.getTranslateX() / 60 - 1;
			y = (int) (this.getTranslateY() / 60);
			indice = p.rechercher(x, y);
			if (indice > 10 || indice == 0) {

				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateX(this.getTranslateX() - 60);

			} else {
				//this.perdVie();
			}

		}
	}

	public void monter() {

		int x = (int) this.getTranslateX() / 60;
		int y = (int) this.getTranslateY() / 60;
		int indice = p.rechercher(x, y);
		if (indice != indice_robot-2) {
			p.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateY() - 60 < 0) {
			x = (int) this.getTranslateX() / 60;
			y = 15;
			indice = p.rechercher(x, y);
			if (indice > 10 || indice == 0) {
				
				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateY(900);

			} else {
				//this.perdVie();
			}

		} else {
			x = (int) this.getTranslateX() / 60;
			y = (int) (this.getTranslateY() / 60) - 1;
			indice = p.rechercher(x, y);
			if (indice > 10 || indice == 0) {

				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateY(this.getTranslateY() - 60);

			} else {
				//this.perdVie();
			}

		}
	}

	public void descendre() {
		int x = (int) this.getTranslateX() / 60;
		int y = (int) this.getTranslateY() / 60;
		int indice = p.rechercher(x, y);
		if (indice != indice_robot-2) {
			p.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateY() + 60 > 959) {
			x = (int) this.getTranslateX() / 60;
			y = 0;
			indice = p.rechercher(x, y);
			if (indice > 10 || indice == 0) {

				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateY(0);

			} else {
				//this.perdVie();
			}

		} else {
			x = (int) this.getTranslateX() / 60;
			y = (int) (this.getTranslateY() / 60) + 1;
			indice = p.rechercher(x, y);
			if (indice > 10 || indice == 0) {

				p.setCasePlateau(x, y, indice_robot);
				this.setTranslateY(this.getTranslateY() + 60);

			} else {
				//this.perdVie();
			}

		}

	}
	
}
