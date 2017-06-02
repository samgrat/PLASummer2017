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
		panneau = new Rectangle();
		panneau.setArcHeight(20);
		panneau.setArcWidth(20);
		panneau.setHeight(200);
		panneau.setWidth(290);
		panneau.setX(980);
		if (j.Indice_joueur() == 1) {
			panneau.setY(100);
			panneau.setFill(Color.BLUE);
		} else {
			panneau.setY(400);
			panneau.setFill(Color.RED);
		}
		this.getChildren().add(panneau);

		piece = new Text("Pieces : " + String.valueOf(j.Nbr_piece()));
		piece.setX(985);
		if (j.Indice_joueur() == 1) {
			piece.setY(120);
		} else {
			piece.setY(420);
		}
		piece.setFill(Color.WHITE);
		this.getChildren().add(piece);
	}

	public void actuScore() {
		piece.setText("Pieces : " + String.valueOf(j.Nbr_piece()));
	}
}
