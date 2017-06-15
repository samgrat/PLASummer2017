package Graphique;

import javafx.scene.shape.Rectangle;
import I_O.fichier;
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
		r.setOpacity(0.75);	
		root.getChildren().add(r);
		
		if (indice_joueur == 1) {
			
			String j2 = fichier.lecture("Joueur2.txt").get(0);
			Text j2win = new Text(j2 + " A GAGNÉ !");
			j2win.setX(360);
			j2win.setY(500);
			j2win.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			j2win.setFontSmoothingType(FontSmoothingType.LCD);
			j2win.setFill(Color.WHITE);
			
			double W2 = j2win.getBoundsInLocal().getWidth();
			j2win.relocate(495 - W2 / 2, 460);
			
			root.getChildren().add(j2win);
			root.requestFocus();
		}
		
		else if (indice_joueur == 2) {
			
			String j1 = fichier.lecture("Joueur1.txt").get(0);
			Text j1win = new Text(j1 + " A GAGNÉ !");
			j1win.setX(360);
			j1win.setY(500);
			j1win.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			j1win.setFontSmoothingType(FontSmoothingType.LCD);
			j1win.setFill(Color.WHITE);
			
			double W1 = j1win.getBoundsInLocal().getWidth();
			j1win.relocate(495 - W1 / 2, 460);
			
			root.getChildren().add(j1win);
			root.requestFocus();
		}
		
		else {
			
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