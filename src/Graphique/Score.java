package Graphique;

import Programme.Joueur;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

import Graphique.Choix_Robot.*;
import I_O.*;

public class Score extends Parent {
	Text piece;
	Rectangle panneau;
	Joueur j;
	
	public Score(Joueur j, String nom) {
		this.j = j;
		String nomJ;
		
		if(j.Indice_joueur() == 1){
			nomJ = nom;
		}
		else{
			nomJ = nom;
		}
		
		
		piece = new Text(String.valueOf(j.Nbr_piece()));

		// TODO : centrer le score dans les cases correspondantes
		
		piece.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 20));
		piece.setX(1120);
		
		if (j.Indice_joueur() == 1) {
		piece.setFill(Color.BLUE);
		piece.setY(425);
		}else{
		piece.setFill(Color.RED);
		piece.setY(565);
		}
		}

	public void actuScore() {
		piece.setText(String.valueOf(j.Nbr_piece()));
	}
}
