package Graphique;

import Programme.Joueur;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sun.management.resources.agent;

public class Score extends Parent {
	Text piece;
	Text joueur;
	Rectangle panneau;
	Joueur j;

	
	public Score(Joueur j) {
		this.j = j;
		
		joueur = new Text("NOM JOUEUR");
		
		// TODO : centrer les noms dans les cases correspondantes
		// TODO : scanf pour entrer le nom des joueurs en début de partie 
		
		joueur.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		joueur.setX(1025);
		
		piece = new Text(String.valueOf(j.Nbr_piece()));

		// TODO : centrer le score dans les cases correspondantes
		
		piece.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 20));
		piece.setX(1120);
		
		if (j.Indice_joueur() == 1) {
			piece.setFill(Color.BLUE);
			piece.setY(425);
			joueur.setFill(Color.BLUE);
			joueur.setY(45);
		} else {
			piece.setFill(Color.RED);
			piece.setY(565);
			
			joueur.setFill(Color.RED);
			joueur.setY(950);
		}
		
		this.getChildren().add(piece);
		this.getChildren().add(joueur);
	}

	public void actuScore() {
		piece.setText(String.valueOf(j.Nbr_piece()));
		
	}
}
