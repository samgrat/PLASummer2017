package Graphique;

import javafx.scene.shape.Rectangle;
import Programme.Joueur;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;

public class End extends Parent{
	
	public End(Group root, int indice_joueur){

		Rectangle r = new Rectangle();
		r.setHeight(965);
		r.setWidth(965);
		r.setLayoutX(5);
		r.setLayoutY(5);
		r.setFill(Color.BLACK);
		r.setOpacity(.75);	
		root.getChildren().add(r);
		
		if (indice_joueur == 1) {
			Text j2win = new Text("LE JOUEUR 2 A GAGNÉ !");
			j2win.setX(390);
			j2win.setY(500);
			j2win.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			j2win.setFontSmoothingType(FontSmoothingType.LCD);
			j2win.setFill(Color.WHITE);
			root.getChildren().add(j2win);
			root.requestFocus();
		}
		
		else if (indice_joueur == 2) {
			Text j1win = new Text("LE JOUEUR 1 A GAGNÉ !");
			j1win.setX(390);
			j1win.setY(500);
			j1win.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			j1win.setFontSmoothingType(FontSmoothingType.LCD);
			j1win.setFill(Color.WHITE);
			root.getChildren().add(j1win);
			root.requestFocus();
		}
		
		else if (indice_joueur == 0) {
			Text eg = new Text("ÉGALITÉ !");
			eg.setX(390);
			eg.setY(500);
			eg.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			eg.setFontSmoothingType(FontSmoothingType.LCD);
			eg.setFill(Color.WHITE);
			root.getChildren().add(eg);
			root.requestFocus();
		}
	}
}