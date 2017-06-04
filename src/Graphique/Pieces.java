package Graphique;

import Programme.Joueur;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pieces extends Parent {
	ImageView[][] listePiece;
	Plateau p;

	public Pieces(Plateau p) {
		listePiece = new ImageView[16][16];
		this.addPieces();
		this.addPieces();
		this.p = p;
	}
	

	public void addPieces() {

		int x = (int) (Math.random() * 16);
		int y = (int) (Math.random() * 16);
		ImageView piece = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/piece.png")));
		piece.setFitWidth(60);
		piece.setFitHeight(60);
		piece.setTranslateX(5 + x * 60);
		piece.setTranslateY(5 + y * 60);
		listePiece[x][y] = piece;
		this.getChildren().add(piece);

	}

	public ImageView rechercher(int x, int y) {
		if (listePiece[x][y] != null) {
			return listePiece[x][y];
		}

		return null;
	}

	public void ramasser(int x, int y, Joueur j) {
		listePiece[x][y].setVisible(false);
		listePiece[x][y] = null;
		j.incrPiece();
		addPieces();
	}
	
}


