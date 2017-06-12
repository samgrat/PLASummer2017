package Graphique;

import Programme.Joueur;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;

public class Score extends Parent {

	Text scorej, pieceViolette, pieceVerte, pieceRose, pieceOrange;
	Rectangle panneau;
	Joueur j;

	public Score(Joueur j) {
		this.j = j;

		// TODO : scanf pour entrer le nom des joueurs en dbut de partie

		Text nomj1 = new Text("JOUEUR 1");
		nomj1.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		nomj1.setFontSmoothingType(FontSmoothingType.LCD);

		Text nomj2 = new Text("JOUEUR 2");
		nomj2.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		nomj2.setFontSmoothingType(FontSmoothingType.LCD);

		scorej = new Text(String.valueOf(j.getPieceOrange() + j.getPieceRose() + j.getPieceVerte() + j.getPieceViolette()));
		scorej.setX(1111);
		scorej.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 40));
		scorej.setFontSmoothingType(FontSmoothingType.LCD);

		pieceViolette = new Text(String.valueOf(j.getPieceViolette()));
		pieceViolette.setX(1335);
		pieceViolette.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		pieceViolette.setFontSmoothingType(FontSmoothingType.LCD);
		pieceVerte = new Text(String.valueOf(j.getPieceVerte()));
		pieceVerte.setX(1335);
		pieceVerte.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		pieceVerte.setFontSmoothingType(FontSmoothingType.LCD);
		pieceRose = new Text(String.valueOf(j.getPieceRose()));
		pieceRose.setX(1335);
		pieceRose.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		pieceRose.setFontSmoothingType(FontSmoothingType.LCD);
		pieceOrange = new Text(String.valueOf(j.getPieceOrange()));
		pieceOrange.setX(1335);
		pieceOrange.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		pieceOrange.setFontSmoothingType(FontSmoothingType.LCD);
		int a = 0;


		if (j.Indice_joueur() == 1) {

			scorej.setFill(Color.ROYALBLUE);
			scorej.setY(420);

			nomj1.setFill(Color.ROYALBLUE);
			// centrage du nom du joueur dans l'interface prvue
			double W1 = nomj1.getBoundsInLocal().getWidth();
			double H1 = nomj1.getBoundsInLocal().getHeight();
			nomj1.relocate(1125 - W1 / 2, 30 - H1 / 2);
		}

		else {
			a = 500;
			scorej.setFill(Color.RED);
			scorej.setY(590);

			nomj2.setFill(Color.RED);
			// centrage du nom du joueur dans l'interface prvue
			double W2 = nomj2.getBoundsInLocal().getWidth();
			double H2 = nomj2.getBoundsInLocal().getHeight();
			nomj2.relocate(1125 - W2 / 2, 938 - H2 / 2);
		}
		pieceViolette.setFill(Color.WHITE);
		pieceViolette.setY(311+a);
		pieceVerte.setFill(Color.WHITE);
		pieceVerte.setY(199+a);
		pieceRose.setFill(Color.WHITE);
		pieceRose.setY(84+a);
		pieceOrange.setFill(Color.WHITE);
		pieceOrange.setY(425+a);
		this.getChildren().addAll(scorej, nomj1, nomj2, pieceViolette, pieceVerte, pieceRose, pieceOrange);
	}

	public void actuScore() {
		scorej.setText(String.valueOf(j.getPieceOrange() + j.getPieceRose() + j.getPieceVerte() + j.getPieceViolette()));
		pieceViolette.setText(String.valueOf(j.getPieceViolette()));
		pieceVerte.setText(String.valueOf(j.getPieceVerte()));
		pieceRose.setText(String.valueOf(j.getPieceRose()));
		pieceOrange.setText(String.valueOf(j.getPieceOrange()));

		if (j.Indice_joueur() == 1) {
			// centrage du score du joueur dans l'interface prvue
			double WS1 = scorej.getBoundsInLocal().getWidth();
			double HS1 = scorej.getBoundsInLocal().getHeight();
			scorej.relocate(1126 - WS1 / 2, 400 - HS1 / 2);
		}

		else {
			// centrage du score du joueur dans l'interface prvue
			double WS2 = scorej.getBoundsInLocal().getWidth();
			double HS2 = scorej.getBoundsInLocal().getHeight();
			scorej.relocate(1126 - WS2 / 2, 570 - HS2 / 2);

		}

	}
}
