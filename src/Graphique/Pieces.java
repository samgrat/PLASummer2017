package Graphique;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pieces extends Parent {
	private ImageView[][] listePiece;
	final int indice_piece = 11;

	public ImageView getPiece(int x, int y) {
		return listePiece[x][y];
	}

	public void setPiece(int x, int y, ImageView val) {
		this.listePiece[x][y] = val;
	}

	public Pieces() {
		listePiece = new ImageView[16][16];
	}

	public void addPieces(Plateau p) {
		int x, y;
		do {
			x = (int) (Math.random() * 16);
			y = (int) (Math.random() * 16);
		} while (p.rechercher(x, y) != 0);

		ImageView piece = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/piece.png")));
		piece.setScaleX(.5);
		piece.setScaleY(.5);
		piece.setFitWidth(60);
		piece.setFitHeight(60);
		piece.setTranslateX(6 + x * 60);
		piece.setTranslateY(6 + y * 60);
		listePiece[x][y] = piece;
		this.getChildren().add(piece);
		p.setCasePlateau(x, y, indice_piece);

	}

}
