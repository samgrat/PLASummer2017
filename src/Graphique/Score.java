package Graphique;

import Programme.Joueur;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sun.management.resources.agent;

public class Score extends Parent {
	Text piece;
	Text joueur1;
	Text joueur2;
	Rectangle panneau;
	Rectangle j1;
	Rectangle j2;
	Rectangle scorej1;
	Rectangle scorej2;
	Joueur j;

	
	public Score(Joueur j) {
		this.j = j;

		// TODO : centrer les noms dans les cases correspondantes
		// TODO : scanf pour entrer le nom des joueurs en début de partie 
		
		joueur1 = new Text("JOUEUR 1");
		joueur2 = new Text("JOUEUR 2");
		
		joueur1.setX(1050);
		joueur1.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel.ttf"), 30));
		joueur1.setFontSmoothingType(FontSmoothingType.LCD);
		

		joueur2.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel.ttf"), 30));
		joueur2.setFontSmoothingType(FontSmoothingType.LCD);
		joueur2.setX(1050);
		
		// TODO : centrer le score dans les cases correspondantes
		
		piece = new Text(String.valueOf(j.Nbr_piece()));
		
		piece.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel.ttf"), 30));
		piece.setFontSmoothingType(FontSmoothingType.LCD);
		piece.setX(1115);
		
		if (j.Indice_joueur() == 1) {
			piece.setFill(Color.BLUE);
			piece.setY(430);
			joueur1.setFill(Color.BLUE);
			joueur1.setY(45);
		} else {
			piece.setFill(Color.RED);
			piece.setY(570);
			joueur2.setFill(Color.RED);
			joueur2.setY(950);
		}
		
		this.getChildren().addAll(piece, joueur1, joueur2);
	}

	public void actuScore() {
		piece.setText(String.valueOf(j.Nbr_piece()));
		
	}
}
