package Programme;

import Grammaire.Comportement;
import Grammaire.Expression;
import Graphique.End;
import Graphique.Main;
import Graphique.Plateau;
import Graphique.Score;
import Parser.ParseException;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Joueur extends Personnage {
	private Score s;
	private Plateau p;
	private Comportement comport1;
	private Comportement comport2;
	private Comportement comport3;
	private Comportement comport4;
	private int[] coutrobot1;
	private int[] coutrobot2;
	private int[] coutrobot3;
	private int[] coutrobot4;
	private int pv = 3;
	private int indice_joueur;

	private int pieceViolette = 0;
	private int pieceVerte = 0;
	private int pieceRose = 0;
	private int pieceOrange = 0;

	Rectangle vie1;
	Rectangle vie2;
	Rectangle vie3;
	Rectangle cache1;
	Rectangle cache3;
	Group root;
    
	private int difficulte;
	MediaPlayer mediaplayer;

	public int getPieceViolette() {
		return pieceViolette;
	}

	public void setPieceViolette(int pieceViolette) {
		this.pieceViolette = pieceViolette;
	}

	public int getPieceVerte() {
		return pieceVerte;
	}

	public void setPieceVerte(int pieceVerte) {
		this.pieceVerte = pieceVerte;
	}

	public int getPieceRose() {
		return pieceRose;
	}

	public void setPieceRose(int pieceRose) {
		this.pieceRose = pieceRose;
	}

	public int getPieceOrange() {
		return pieceOrange;
	}

	public void setPieceOrange(int pieceOrange) {
		this.pieceOrange = pieceOrange;
	}

	public void setDifficulte(int d) {
		this.difficulte = d;
	}

	public Score getScore() {
		return this.s;
	}

	public void setScore(Score s) {
		this.s = s;
	}

	public int Indice_joueur() {
		return indice_joueur;
	}

	public void incrPiece(int indice) {
		switch (indice) {
		case 11:
			this.pieceViolette++;
			break;
		case 12:
			this.pieceVerte++;
			break;
		case 13:
			this.pieceRose++;
			break;
		case 14:
			this.pieceOrange++;
			break;
		}
	}

	/**
	 * creation d'un joueur
	 * @param tabCoutRVBj1 
	 * 
	 * @param indice
	 *            1 si joueur 1 ou 2 si joueur 2
	 * @throws ParseException
	 */

	public Joueur(int indice_joueur, Plateau p, Group root, Comportement[] compj, int[][] tabCoutRVBj, MediaPlayer mediaplayer) {
		this.mediaplayer = mediaplayer;
		this.comport1 = compj[0];
		this.comport2 = compj[1];
		this.comport3 = compj[2];
		this.comport4 = compj[3];
		this.coutrobot1 = tabCoutRVBj[0];
		this.coutrobot2 = tabCoutRVBj[1];
		this.coutrobot3 = tabCoutRVBj[2];
		this.coutrobot4 = tabCoutRVBj[3];
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
		joueur.setScaleX(1.2);
		joueur.setScaleY(1.2);
		joueur.setFitWidth(p.getSize());
		joueur.setFitHeight(p.getSize());
		joueur.setLayoutX(5);
		joueur.setLayoutY(5);
		this.getChildren().add(joueur);

		Rectangle r = new Rectangle();
		r.setFill(Color.WHITE);
		r.setWidth(47);
		r.setHeight(10);
		r.opacityProperty().set(.35);
		r.setArcWidth(10);
		r.setArcHeight(10);
		r.setLayoutX(11);
		r.setLayoutY(55);
		this.getChildren().add(r);

		afficherVie();
	}

	public void afficherVie() {
		vie1 = new Rectangle();
		vie1.setWidth(10);
		vie1.setHeight(8);
		vie1.setArcWidth(10);
		vie1.setArcHeight(10);
		vie1.setLayoutX(12);
		vie1.setLayoutY(56);
		
		cache1 = new Rectangle();
		cache1.setWidth(12);
		cache1.setHeight(8);
		cache1.setLayoutX(16);
		cache1.setLayoutY(56);
		
		
		if (indice_joueur == 1) {
			vie1.setFill(Color.ROYALBLUE);
			cache1.setFill(Color.ROYALBLUE);
		}
		
		else {
			vie1.setFill(Color.RED);
			cache1.setFill(Color.RED);
		}
		
		this.getChildren().addAll(vie1, cache1);

		vie2 = new Rectangle();
		vie2.setWidth(14);
		vie2.setHeight(8);
		vie2.setLayoutX(12 + 15.5);
		vie2.setLayoutY(56);
		
		if (indice_joueur == 1) {
			vie2.setFill(Color.ROYALBLUE);
		}
		
		else {
			vie2.setFill(Color.RED);
		}
		
		this.getChildren().add(vie2);

		vie3 = new Rectangle();
		vie3.setWidth(14);
		vie3.setHeight(8);
		vie3.setArcWidth(10);
		vie3.setArcHeight(10);
		vie3.setLayoutX(12 + 31);
		vie3.setLayoutY(56);
		
		cache3 = new Rectangle();
		cache3.setWidth(10);
		cache3.setHeight(8);
		cache3.setLayoutX(40);
		cache3.setLayoutY(56);
		
		if (indice_joueur == 1) {
			vie3.setFill(Color.ROYALBLUE);
			cache3.setFill(Color.ROYALBLUE);
		}
		
		else {
			vie3.setFill(Color.RED);
			cache3.setFill(Color.RED);
		}
		
		this.getChildren().addAll(vie3, cache3);
	}

	public void actualiserVie() {
		switch (this.pv) {
		case 0:
			vie1.setVisible(false);
			cache1.setVisible(false);
			vie2.setVisible(false);
			vie3.setVisible(false);
			cache3.setVisible(false);
			new End(root);
			break;
		case 1:
			vie1.setVisible(true);
			cache1.setVisible(true);
			vie2.setVisible(false);
			vie3.setVisible(false);
			cache3.setVisible(false);
			break;
		case 2:
			vie1.setVisible(true);
			cache1.setVisible(true);
			vie2.setVisible(true);
			vie3.setVisible(false);
			cache3.setVisible(false);
			break;
		default:
			this.pv = 3;
			vie1.setVisible(true);
			cache1.setVisible(true);
			vie2.setVisible(true);
			vie3.setVisible(true);
			cache3.setVisible(true);
			s.actuScore();
			break;
		}
	}

	public void perdVie() {
		this.pv--;
        mediaplayer.play();
		actualiserVie();
	}

	public void droite() {
		int indice = p.rechercher(x, y);
		if (indice != indice_joueur + 2) {
			p.setCasePlateau(x, y, 0);
		}
		if (getX()+1  > 15) {
			indice = p.rechercher(0, y);
			if (indice > 10 || indice == 0) {
				setX(0);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateX(0);
			} else if (indice == this.indice_joueur + 2) {

				p.setCasePlateau(15, y, indice_joueur);
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
			} else if (indice == this.indice_joueur + 2) {

				p.setCasePlateau(x, y, indice_joueur);
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

		if (getX() - 1 < 0) {
			indice = p.rechercher(15, y);
			if (indice > 10 || indice == 0) {
				setX(15);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateX(15*p.getSize());

			} else if (indice == this.indice_joueur + 2) {
				p.setCasePlateau(0, y, indice_joueur);
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
				this.setTranslateX(this.getTranslateX() - p.getSize());
			} else if (indice == this.indice_joueur + 2) {
				p.setCasePlateau(x, y, indice_joueur);
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
		if (getY() - 1 < 0) {
			indice = p.rechercher(x, 15);
			if (indice > 10 || indice == 0) {
				setY(15);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateY(15*p.getSize());
			} else if (indice == this.indice_joueur + 2) {
				p.setCasePlateau(x, 0, indice_joueur);
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
				this.setTranslateY(this.getTranslateY() - p.getSize());
			} else if (indice == this.indice_joueur + 2) {
				p.setCasePlateau(x, y, indice_joueur);
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
		if (getY() + 1 > 15) {
			indice = p.rechercher(x, 0);
			if (indice > 10 || indice == 0) {
				setY(0);
				p.ramasser(x, y, this, indice);
				this.getScore().actuScore();
				p.setCasePlateau(x, y, indice_joueur);
				this.setTranslateY(0);
			} else if (indice == this.indice_joueur + 2) {
				p.setCasePlateau(x, 15, indice_joueur);
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
				this.setTranslateY(this.getTranslateY() + p.getSize());
			} else if (indice == this.indice_joueur + 2) {
				p.setCasePlateau(x, y, indice_joueur);
			} else {
				this.perdVie();
				p.setCasePlateau(x, y, indice_joueur);
			}
		}
	}

	public void invoquerRobot1(Group root) {
		new Robot(this, root, p, comport1, x, y, difficulte, coutrobot1);	
	}

	public void invoquerRobot2(Group root) {
		new Robot(this, root, p, comport2, x, y, difficulte);
	}

	public void invoquerRobot3(Group root) {
		new Robot(this, root, p, comport3, x, y, difficulte);
	}

	public void invoquerRobot4(Group root) {
		new Robot(this, root, p, comport4, x, y, difficulte);
	}
}