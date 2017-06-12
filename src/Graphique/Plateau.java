package Graphique;

import Programme.Joueur;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plateau extends Parent {
	private Group root;
	private Integer[][] casePlateau;
	private Pieces[] listePiece;
	private int compteurPiece = 0;

	public void delListePiece(int indiceTableau){
		listePiece[indiceTableau] = null;
	}
	
	public Integer getCasePlateau(int x, int y) {
		return casePlateau[x][y];
	}

	public void setCasePlateau(int x, int y, int value) {
		if (x < 16 && x >= 0 && y < 16 && y >= 0) {
			this.casePlateau[x][y] = value;
		}
	}

	public void setListePiece(Pieces piece) {
		this.listePiece[compteurPiece] = piece;
	}

	public Plateau(Group root) {
		this.root = root;
		casePlateau = new Integer[16][16];
		for (int i = 0; i < casePlateau.length; i++) {
			for (int j = 0; j < casePlateau.length; j++) {
				casePlateau[i][j] = 0;
			}
		}
		this.listePiece = new Pieces[256];

		ImageView bck = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/interface.png")));

		this.getChildren().add(bck);
		int j = 0;
		for (int i = 0; i < 16; i++) {
			Rectangle rectangle = new Rectangle();
			rectangle.setX(5 + j * 60);
			rectangle.setY(5 + i * 60);
			rectangle.setWidth(60);
			rectangle.setHeight(60);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setStroke(Color.TRANSPARENT);
			rectangle.setStrokeWidth(1);
			this.getChildren().add(rectangle);
			if (i == 15) {
				i = -1;
				j++;
			}
			if (j == 16) {
				i = 15;
			}
		}

		new Obstacles(this);
		new Pieces(this, root);
		new Pieces(this, root);
	}

	public void ramasser(int x, int y, Joueur j, int indice) {
			System.out.println("x = " + x + " y = " + y);
			int i = rechercherPiece(x, y);
			System.out.println("i =" + i);
			if (i != -1) {
				casePlateau[x][y] = 0;
				System.out.println("IndiceCouleur = " + listePiece[i].getIndiceCouleur());
				j.incrPiece(listePiece[i].getIndiceCouleur());
				listePiece[i].stopTimeline();
				listePiece[i].delPiece(listePiece[i].getImagePiece(), x, y, this, root);
				listePiece[i] = null;
			}
	}

	public int rechercherPiece(int x, int y) {
		int i = 0, xP = -1, yP = -1;
		for (int j = 0; j < 256; j++) {
			if (listePiece[j] != null) {
				xP = listePiece[j].getX();
				yP = listePiece[j].getY();
			}
			if (x == xP && y == yP) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public int rechercher(int x, int y) {
		return casePlateau[x][y];
	}

	public void incrCompteurPiece() {
		this.compteurPiece++;
	}
}
