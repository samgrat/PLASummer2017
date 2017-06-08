package Programme;

import Grammaire.Expression;
import Graphique.End;
import Graphique.Main;
import Graphique.Plateau;
import Graphique.Score;
import Parser.ParseException;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Joueur extends Personnage {
	private Score s;
	private Plateau p;
	private Expression exp;
	private int pv = 3;
	private int indice_joueur;

	private int nbr_boulon;
	private int nbr_planche;
	private int nbr_vis;
	private int nbr_piece;

	Rectangle vie1;
	Rectangle vie2;
	Rectangle vie3;
	Group root;
	

	public Score getScore() {
		return this.s;
	}

	public void setScore(Score s) {
		this.s = s;
	}

	// accesseur indice_joueur
	public int Indice_joueur() {
		return indice_joueur;
	}

	// accesseur nbr_boulon
	public int Nbr_boulon() {
		return nbr_boulon;
	}

	// accesseur nbr_planche
	public int Nbr_planche() {
		return nbr_planche;
	}

	// accesseur niveau_attaque
	public int Nbr_vis() {
		return nbr_vis;
	}

	// accesseur nbr_piece
	public int Nbr_piece() {
		return nbr_piece;
	}

	public void incrPiece() {
		nbr_piece++;
	}

	/**
	 * creation d'un joueur
	 * 
	 * @param indice
	 *            1 si joueur 1 ou 2 si joueur 2
	 * @throws ParseException 
	 */
	public Joueur(int indice_joueur, Plateau p, Group root, Expression exp) { 
		nbr_boulon = 0;
		nbr_planche = 0;
		nbr_vis = 0;
		nbr_piece = 0;
		this.exp = exp;
		this.root = root;
		this.indice_joueur = indice_joueur;
		this.p = p;

		if (indice_joueur == 1) {
			setX(0);
			setY(0);
			p.setCasePlateau(indice_joueur, x, y);
			creeJoueur("images/Textures/persobleu.png");
		} else if (indice_joueur == 2) {
			setX(15);
			setY(15);
			p.setCasePlateau(indice_joueur, x, y);
			creeJoueur("images/Textures/persorouge.png");
		}
	}

	public void creeJoueur(String file) {
		ImageView joueur = new ImageView(new Image(Main.class.getResourceAsStream(file)));
		joueur.setFitWidth(60);
		joueur.setFitHeight(60);
		joueur.setLayoutX(5);
		joueur.setLayoutY(5);
		this.getChildren().add(joueur);

		Rectangle r = new Rectangle();
		r.setWidth(50);
		r.setHeight(10);
		r.setArcWidth(10);
		r.setArcHeight(10);
		r.setFill(Color.TRANSPARENT);
		r.setLayoutX(10);
		r.setLayoutY(55);
		r.setStroke(Color.TRANSPARENT);
		this.getChildren().add(r);

		afficherVie();
	}

	public void afficherVie() {
		vie1 = new Rectangle();
		vie1.setWidth(15);
		vie1.setHeight(8);
		vie1.setArcWidth(5);
		vie1.setArcHeight(5);
		
		if (indice_joueur == 1) {
			vie1.setFill(Color.ROYALBLUE);
		} else if (indice_joueur == 2) {
			vie1.setFill(Color.RED);
		}
		
		vie1.setLayoutX(12);
		vie1.setLayoutY(56);
		this.getChildren().add(vie1);
		vie2 = new Rectangle();
		vie2.setWidth(15);
		vie2.setHeight(8);
		vie2.setArcWidth(5);
		vie2.setArcHeight(5);

		if (indice_joueur == 1) {
			vie2.setFill(Color.ROYALBLUE);
		} else if (indice_joueur == 2) {
			vie2.setFill(Color.RED);
		}
		
		vie2.setLayoutX(12 + 15.5);
		vie2.setLayoutY(56);
		this.getChildren().add(vie2);

		vie3 = new Rectangle();
		vie3.setWidth(15);
		vie3.setHeight(8);
		vie3.setArcWidth(5);
		vie3.setArcHeight(5);

		if (indice_joueur == 1) {
			vie3.setFill(Color.ROYALBLUE);
		} else if (indice_joueur == 2) {
			vie3.setFill(Color.RED);
		}
		
		vie3.setLayoutX(12 + 31);
		vie3.setLayoutY(56);
		this.getChildren().add(vie3);
	}

	public void actualiserVie() {
		switch (this.pv) {
		case 0:
			vie1.setVisible(false);
			vie2.setVisible(false);
			vie3.setVisible(false);
			new End(root);
			break;
		case 1:
			vie1.setVisible(true);
			vie2.setVisible(false);
			vie3.setVisible(false);
			break;
		case 2:
			vie1.setVisible(true);
			vie2.setVisible(true);
			vie3.setVisible(false);
			break;
		default:
			this.nbr_piece = 0;
			this.pv = 3;
			vie1.setVisible(true);
			vie2.setVisible(true);
			vie3.setVisible(true);
			s.actuScore();
			break;
		}
	}

	public void perdVie() {
		this.pv--;
		actualiserVie();
	}

	public void droite() {
		int indice = p.rechercher(x, y);
		if (indice != indice_joueur + 2) {
			p.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateX() + 60 > 959) {
			indice = p.rechercher(0, y);
			if (indice > 10 || indice == 0) {
				setX(0);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateX(0);
			} else {
				this.perdVie();
				p.setCasePlateau(15, y, indice_joueur);
			}
		} else {
			indice = p.rechercher(x + 1, y);
			if (indice > 10 || indice == 0) {
				setX(getX() + 1);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateX(this.getTranslateX() + 60);
			} else {
				this.perdVie();
				p.setCasePlateau(x, y, indice_joueur);
			}
		}
	}

	public void gauche() {
		int indice = p.rechercher(x, y);
		if (indice != indice_joueur + 2) {
			p.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateX() - 60 < 0) {
			indice = p.rechercher(15, y);
			if (indice > 10 || indice == 0) {
				setX(15);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateX(900);
			} else {
				this.perdVie();
				p.setCasePlateau(0, y, indice_joueur);
			}
		} else {
			indice = p.rechercher(x - 1, y);
			if (indice > 10 || indice == 0) {
				setX(getX() - 1);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateX(this.getTranslateX() - 60);
			} else {
				this.perdVie();
				p.setCasePlateau(x, y, indice_joueur);
			}
		}
	}

	public void monter() {
		int indice = p.rechercher(x, y);
		if (indice != indice_joueur + 2) {
			p.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateY() - 60 < 0) {
			indice = p.rechercher(x, 15);
			if (indice > 10 || indice == 0) {
				setY(15);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateY(900);
			} else {
				this.perdVie();
				p.setCasePlateau(x, 0, indice_joueur);
			}
		} else {
			indice = p.rechercher(x, y - 1);
			if (indice > 10 || indice == 0) {
				setY(getY() - 1);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateY(this.getTranslateY() - 60);
			} else {
				this.perdVie();
				p.setCasePlateau(x, y, indice_joueur);
			}
		}
	}

	public void descendre() {
		int indice = p.rechercher(x, y);
		if (indice != indice_joueur + 2) {
			p.setCasePlateau(x, y, 0);
		}
		if (this.getTranslateY() + 60 > 959) {
			indice = p.rechercher(x, 0);
			if (indice > 10 || indice == 0) {
				setY(0);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateY(0);
			} else {
				this.perdVie();
				p.setCasePlateau(x, 15, indice_joueur);
			}
		} else {
			indice = p.rechercher(x, y + 1);
			if (indice > 10 || indice == 0) {
				setY(getY() + 1);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateY(this.getTranslateY() + 60);
			} else {
				this.perdVie();
				p.setCasePlateau(x, y, indice_joueur);
			}
		}
	}

	public void invoquerRobot1(Group root) {
		if (this.nbr_piece >= 2) {
			this.nbr_piece -= 2;
			new Robot(this, root, p, exp, x, y);
		}
	}

	public void invoquerRobot2(Group root) {

	}

	public void invoquerRobot3(Group root) {

	}

	public void invoquerRobot4(Group root) {

	}
}
