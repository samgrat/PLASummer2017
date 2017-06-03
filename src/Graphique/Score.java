package Graphique;

import Programme.Joueur;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Score extends Parent {
	Text piece;
	Rectangle panneau;
	Joueur j;

	public Score(Joueur j) {
		this.j = j;
		piece = new Text("Pieces : " + String.valueOf(j.Nbr_piece()));
		piece.setX(1030);
		if (j.Indice_joueur() == 1) {
			piece.setY(120);
			piece.setFill(Color.BLUE);
		} else {
			piece.setY(720);
			piece.setFill(Color.RED);
		}
		this.getChildren().add(piece);
	}

	public void actuScore() {
		piece.setText("Pieces : " + String.valueOf(j.Nbr_piece()));
	}
}
