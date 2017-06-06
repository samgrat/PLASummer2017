package Graphique;

import Programme.Joueur;
import javafx.geometry.Pos;
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
	Text scorej;
	Text nomj1;
	Text nomj2;
	Rectangle panneau;
	Joueur j;

	
	public Score(Joueur j) {
		this.j = j;

		// TODO : centrer les noms dans les cases correspondantes
		// TODO : scanf pour entrer le nom des joueurs en début de partie 
		
		nomj1 = new Text("JOUEUR 1");
		nomj2 = new Text("JOUEUR 2");
		
		nomj1.setX(1050);
		nomj1.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel.ttf"), 30));
		nomj1.setFontSmoothingType(FontSmoothingType.LCD);
		
		nomj2.setX(1050);
		nomj2.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel.ttf"), 30));
		nomj2.setFontSmoothingType(FontSmoothingType.LCD);
		
		// TODO : centrer le score dans les cases correspondantes
		
		scorej = new Text(String.valueOf(j.Nbr_piece()));
		
		scorej.setX(1115);
		scorej.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel.ttf"), 30));
		scorej.setFontSmoothingType(FontSmoothingType.LCD);
		
		if (j.Indice_joueur() == 1) {
			scorej.setFill(Color.BLUE);
			scorej.setY(430);
			nomj1.setFill(Color.BLUE);
			nomj1.setY(45);
		} else {
			scorej.setFill(Color.RED);
			scorej.setY(570);
			nomj2.setFill(Color.RED);
			nomj2.setY(950);
		}
		
		this.getChildren().addAll(scorej, nomj1, nomj2);
	}

	public void actuScore() {
		scorej.setText(String.valueOf(j.Nbr_piece()));
		
	}
}
