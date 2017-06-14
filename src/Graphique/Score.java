package Graphique;

import Programme.Joueur;
import Graphique.Plateau;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;

import java.util.ArrayList;

import Graphique.Choix_Robot.*;
import I_O.*;

public class Score extends Parent {

	Text scorej, pieceViolette, pieceVerte, pieceRose, pieceOrange;
	Rectangle panneau;
	Joueur j;
	
	public Score(Joueur j) {
		this.j = j;

		scorej = new Text(String.valueOf(j.getPieceOrange() + j.getPieceRose() + j.getPieceVerte() + j.getPieceViolette()));
		scorej.setX(1111);
		scorej.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 40));
		scorej.setFontSmoothingType(FontSmoothingType.LCD);

		pieceViolette = new Text(String.valueOf(j.getPieceViolette()));
		pieceViolette.setX(1339);
		pieceViolette.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 20));
		pieceViolette.setFontSmoothingType(FontSmoothingType.LCD);
		
		pieceVerte = new Text(String.valueOf(j.getPieceVerte()));
		pieceVerte.setX(1339);
		pieceVerte.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 20));
		pieceVerte.setFontSmoothingType(FontSmoothingType.LCD);
		
		pieceRose = new Text(String.valueOf(j.getPieceRose()));
		pieceRose.setX(1339);
		pieceRose.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 20));
		pieceRose.setFontSmoothingType(FontSmoothingType.LCD);
		
		pieceOrange = new Text(String.valueOf(j.getPieceOrange()));
		pieceOrange.setX(1339);
		pieceOrange.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 20));
		pieceOrange.setFontSmoothingType(FontSmoothingType.LCD);
		
		int a = 0;

		if (j.Indice_joueur() == 1) {

			scorej.setFill(Color.ROYALBLUE);
			scorej.setY(420);
		}

		else {
			a = 502;
			
			scorej.setFill(Color.RED);
			scorej.setY(590);
		}
		
		pieceViolette.setFill(Color.hsb(0, .0, .2));
		pieceViolette.setY(308 + a);
		
		pieceVerte.setFill(Color.hsb(0, .0, .2));
		pieceVerte.setY(195 + a);
		
		pieceRose.setFill(Color.hsb(0, .0, .2));
		pieceRose.setY(80 + a);
		
		pieceOrange.setFill(Color.hsb(0, .0, .2));
		pieceOrange.setY(421 + a);
		
		this.getChildren().addAll(scorej, pieceViolette, pieceVerte, pieceRose, pieceOrange);
	}

	public void actuScore() { 
				
		scorej.setText(String.valueOf(j.getPieces()));
		pieceViolette.setText(String.valueOf(j.getPieceViolette()));
		pieceVerte.setText(String.valueOf(j.getPieceVerte()));
		pieceRose.setText(String.valueOf(j.getPieceRose()));
		pieceOrange.setText(String.valueOf(j.getPieceOrange()));

		if (j.Indice_joueur() == 1) {
			
			// centrage du score du joueur dans l'interface prevue
			double WS1 = scorej.getBoundsInLocal().getWidth();
			double HS1 = scorej.getBoundsInLocal().getHeight();
			scorej.relocate(1126 - WS1 / 2, 400 - HS1 / 2);
			
			double HVi = pieceViolette.getBoundsInLocal().getHeight();
			double WVi = pieceViolette.getBoundsInLocal().getWidth();
			pieceViolette.relocate(1346 - WVi / 2, 298 - HVi / 2);
			
			double HVe = pieceVerte.getBoundsInLocal().getHeight();
			double WVe = pieceVerte.getBoundsInLocal().getWidth();
			pieceVerte.relocate(1346 - WVe / 2, 185 - HVe / 2);
			
			double HRo = pieceRose.getBoundsInLocal().getHeight();
			double WRo = pieceRose.getBoundsInLocal().getWidth();
			pieceRose.relocate(1346 - WRo / 2, 70 - HRo / 2);
			
			double HOr = pieceOrange.getBoundsInLocal().getHeight();
			double WOr = pieceOrange.getBoundsInLocal().getWidth();
			pieceOrange.relocate(1346 - WOr / 2, 411 - HOr / 2);
		}

		else {
			
			// centrage du score du joueur dans l'interface prevue
			double WS2 = scorej.getBoundsInLocal().getWidth();
			double HS2 = scorej.getBoundsInLocal().getHeight();

			scorej.relocate(1126 - WS2 / 2, 570 - HS2 / 2);
			pieceViolette.relocate(1338, 815 - pieceViolette.getBoundsInLocal().getHeight());
			
			double HVi = pieceViolette.getBoundsInLocal().getHeight();
			double WVi = pieceViolette.getBoundsInLocal().getWidth();
			pieceViolette.relocate(1346 - WVi / 2, 800 - HVi / 2);
			
			double HVe = pieceVerte.getBoundsInLocal().getHeight();
			double WVe = pieceVerte.getBoundsInLocal().getWidth();
			pieceVerte.relocate(1346 - WVe / 2, 687 - HVe / 2);
			
			double HRo = pieceRose.getBoundsInLocal().getHeight();
			double WRo = pieceRose.getBoundsInLocal().getWidth();
			pieceRose.relocate(1346 - WRo / 2, 572 - HRo / 2);
			
			double HOr = pieceOrange.getBoundsInLocal().getHeight();
			double WOr = pieceOrange.getBoundsInLocal().getWidth();
			pieceOrange.relocate(1346 - WOr / 2, 913 - HOr / 2);
		}
	}
}

