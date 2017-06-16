package Programme;

import Grammaire.Comportement;
import Graphique.End;
import Graphique.Main;
import Graphique.Plateau;
import Graphique.Score;
import Parser.ParseException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Joueur extends Personnage {
	private Score s;
	private Plateau p;
	private Comportement comport1;
	private Comportement comport2;
	private Comportement comport3;
	private Comportement comport4;
	private Comportement comport5;
	private Comportement comport6;
	private Comportement comport7;
	private Comportement comport8;

	private int pv = 3;
	private int scoreint = 0;
	private int[] coutrobot1;
	private int[] coutrobot2;
	private int[] coutrobot3;
	private int[] coutrobot4;
	private int[] coutrobot5;
	private int[] coutrobot6;
	private int[] coutrobot7;
	private int[] coutrobot8;

	private int indice_joueur;

	private int pieceViolette = 0;
	private int pieceVerte = 0;
	private int pieceRose = 0;
	private int pieceOrange = 0;

	ImageView imageRobot1;
	ImageView imageRobot2;
	ImageView imageRobot3;
	ImageView imageRobot4;

	Rectangle vie1;
	Rectangle vie2;
	Rectangle vie3;
	Rectangle cache1;
	Rectangle cache3;
	Group root;
	Group pane3;

	private int difficulte;
	MediaPlayer mediaplayer;
	Timeline timeline;

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}

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

	public int getPieces() {
		return scoreint;
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

	public void setPV(int pv) {
		this.pv = pv;
	}

	public int getPV() {
		return this.pv;
	}

	public void incrPiece(int indice) {
		switch (indice) {
		case 11:
			this.pieceViolette++;
			scoreint++;
			break;
		case 12:
			this.pieceVerte++;
			scoreint++;
			break;
		case 13:
			this.pieceRose++;
			scoreint++;
			break;
		case 14:
			this.pieceOrange++;
			scoreint++;
			break;
		}
	}


	public void ChangerComport() {
		this.comport1 = this.comport5;
		// System.out.println("comport1 changer : [" + comport1 + "]" );
		this.comport2 = this.comport6;
		this.comport3 = this.comport7;
		this.comport4 = this.comport8;

		this.coutrobot1 = this.coutrobot5;
		this.coutrobot2 = this.coutrobot6;
		this.coutrobot3 = this.coutrobot7;
		this.coutrobot4 = this.coutrobot8;
	}

	/**
	 * creation d'un joueur
	 * 
	 * @param indice
	 *            1 si joueur 1 ou 2 si joueur 2
	 * @throws ParseException
	 */

	public Joueur(int indice_joueur, Plateau p, Group root, Comportement[] compj, int[][] tabCoutRVPj,
			MediaPlayer mediaplayer) {
		this.mediaplayer = mediaplayer;

		this.comport1 = compj[0];
		// System.out.println("Comportement 1 : [" + comport1+"]");
		this.comport2 = compj[1];
		this.comport3 = compj[2];
		this.comport4 = compj[3];
		this.comport5 = compj[4];
		this.comport6 = compj[5];
		// System.out.println("Comportement 5" + compj[5]);
		this.comport7 = compj[6];
		this.comport8 = compj[7];

		this.coutrobot1 = tabCoutRVPj[0];
		this.coutrobot2 = tabCoutRVPj[1];
		this.coutrobot3 = tabCoutRVPj[2];
		this.coutrobot4 = tabCoutRVPj[3];
		this.coutrobot5 = tabCoutRVPj[4];
		this.coutrobot6 = tabCoutRVPj[5];
		this.coutrobot7 = tabCoutRVPj[6];
		this.coutrobot8 = tabCoutRVPj[7];
		this.root = root;
		this.indice_joueur = indice_joueur;
		this.p = p;

		if (this.indice_joueur == 1) {
			imageRobot1 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu1.png")));
			imageRobot2 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu2.png")));
			imageRobot3 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu3.png")));
			imageRobot4 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotbleu4.png")));
			imageRobot1.setY(75);
			imageRobot2.setY(75);
			imageRobot3.setY(190);
			imageRobot4.setY(190);
		} else {
			imageRobot1 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge1.png")));
			imageRobot2 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge2.png")));
			imageRobot3 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge3.png")));
			imageRobot4 = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/robotrouge4.png")));
			imageRobot1.setY(628);
			imageRobot2.setY(628);
			imageRobot3.setY(743);
			imageRobot4.setY(743);
		}
		imageRobot1.setX(987);
		imageRobot1.prefWidth(0.7);
		imageRobot1.setVisible(false);
		imageRobot2.setX(1113);
		imageRobot2.prefWidth(0.7);
		imageRobot2.setVisible(false);
		imageRobot3.setX(987);
		imageRobot3.prefWidth(0.7);
		imageRobot3.setVisible(false);
		imageRobot4.setX(1113);
		imageRobot4.prefWidth(0.7);
		imageRobot4.setVisible(false);
		root.getChildren().addAll(imageRobot1, imageRobot2, imageRobot3, imageRobot4);

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
		if (pv == 0) {
			this.pv--;
			new End(root, indice_joueur, timeline);
			timeline.stop();
		}
		Timeline degat = new Timeline(new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaplayer.stop();
			}
		}));
		degat.play();
	}

	public void droite() {
		int indice = p.rechercher(x, y);
		if (indice != indice_joueur + 2) {
			p.setCasePlateau(x, y, 0);
		}
		if (getX() + 1 > 15) {
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
				this.setTranslateX(15 * p.getSize());

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
				this.setTranslateY(15 * p.getSize());
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
		if (pieceRose >= coutrobot1[0] && pieceVerte >= coutrobot1[1] && pieceViolette >= coutrobot1[2]
				&& pieceOrange >= 1) {

			setPieceRose(pieceRose - coutrobot1[0]);
			setPieceVerte(pieceVerte - coutrobot1[1]);
			setPieceViolette(pieceViolette - coutrobot1[2]);
			setPieceOrange(pieceOrange - 1);

			p.setCasePlateau(x, y, Indice_joueur() + 2);
			Robot r1 = new Robot(this, root, p, comport1, x, y, difficulte, coutrobot1);
			r1.setComportement(comport1);
			actuPanel();
		}

	}

	public void invoquerRobot2(Group root) {
		if (pieceRose >= coutrobot2[0] && pieceVerte >= coutrobot2[1] && pieceViolette >= coutrobot2[2]
				&& pieceOrange >= 1) {

			setPieceRose(pieceRose - coutrobot2[0]);
			setPieceVerte(pieceVerte - coutrobot2[1]);
			setPieceViolette(pieceViolette - coutrobot2[2]);
			setPieceOrange(pieceOrange - 1);

			p.setCasePlateau(x, y, Indice_joueur()+2);
			Robot r2 =new Robot(this, root, p, comport2, x, y, difficulte, coutrobot2);
			r2.setComportement(comport2);
			actuPanel();
		}
	}

	public void invoquerRobot3(Group root) {
		if (pieceRose >= coutrobot3[0] && pieceVerte >= coutrobot3[1] && pieceViolette >= coutrobot3[2]
				&& pieceOrange >= 1) {

			setPieceRose(pieceRose - coutrobot3[0]);
			setPieceVerte(pieceVerte - coutrobot3[1]);
			setPieceViolette(pieceViolette - coutrobot3[2]);
			setPieceOrange(pieceOrange - 1);

			p.setCasePlateau(x, y, Indice_joueur()+2);
			Robot r3 =new Robot(this, root, p, comport3, x, y, difficulte, coutrobot3);
			r3.setComportement(comport3);
			actuPanel();
		}
	}

	public void invoquerRobot4(Group root) {
		if (pieceRose >= coutrobot4[0] && pieceVerte >= coutrobot4[1] && pieceViolette >= coutrobot4[2]
				&& pieceOrange >= 1) {

			setPieceRose(pieceRose - coutrobot4[0]);
			setPieceVerte(pieceVerte - coutrobot4[1]);
			setPieceViolette(pieceViolette - coutrobot4[2]);
			setPieceOrange(pieceOrange - 1);
			
			p.setCasePlateau(x, y, Indice_joueur()+2);
			Robot r4 = new Robot(this, root, p, comport4, x, y, difficulte, coutrobot4);
			r4.setComportement(comport4);
			actuPanel();
		}
	}

	public void actuPanel() {
		if (this.indice_joueur == 1) {
			if (pieceRose >= coutrobot1[0] && pieceVerte >= coutrobot1[1] && pieceViolette >= coutrobot1[2]
					&& pieceOrange >= 1) {
				imageRobot1.setVisible(true);
			} else {
				imageRobot1.setVisible(false);
			}
			if (pieceRose >= coutrobot2[0] && pieceVerte >= coutrobot2[1] && pieceViolette >= coutrobot2[2]
					&& pieceOrange >= 1) {
				imageRobot2.setVisible(true);
			} else {
				imageRobot2.setVisible(false);
			}
			if (pieceRose >= coutrobot3[0] && pieceVerte >= coutrobot3[1] && pieceViolette >= coutrobot3[2]
					&& pieceOrange >= 1) {
				imageRobot3.setVisible(true);
			} else {
				imageRobot3.setVisible(false);
			}
			if (pieceRose >= coutrobot4[0] && pieceVerte >= coutrobot4[1] && pieceViolette >= coutrobot4[2]
					&& pieceOrange >= 1) {
				imageRobot4.setVisible(true);
			} else {
				imageRobot4.setVisible(false);
			}
		} else {
			if (pieceRose >= coutrobot1[0] && pieceVerte >= coutrobot1[1] && pieceViolette >= coutrobot1[2]
					&& pieceOrange >= 1) {
				imageRobot1.setVisible(true);
			} else {
				imageRobot1.setVisible(false);
			}
			if (pieceRose >= coutrobot2[0] && pieceVerte >= coutrobot2[1] && pieceViolette >= coutrobot2[2]
					&& pieceOrange >= 1) {
				imageRobot2.setVisible(true);
			} else {
				imageRobot2.setVisible(false);
			}
			if (pieceRose >= coutrobot3[0] && pieceVerte >= coutrobot3[1] && pieceViolette >= coutrobot3[2]
					&& pieceOrange >= 1) {
				imageRobot3.setVisible(true);
			} else {
				imageRobot3.setVisible(false);
			}
			if (pieceRose >= coutrobot3[0] && pieceVerte >= coutrobot3[1] && pieceViolette >= coutrobot3[2]
					&& pieceOrange >= 1) {
				imageRobot4.setVisible(true);
			} else {
				imageRobot4.setVisible(false);
			}
		}
	}
}
