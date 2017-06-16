package Graphique;

import java.net.URL;
import I_O.fichier;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;

public class End extends Parent{
	
	final URL resource = getClass().getResource("images/Textures/starwars.mp3");
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaplayer = new MediaPlayer(media);
	
	public End(Group root, int indice_joueur, Timeline timeline){
		
		timeline.stop();
		Rectangle r = new Rectangle();
		r.setHeight(965);
		r.setWidth(965);
		r.setLayoutX(5);
		r.setLayoutY(5);
		r.setFill(Color.BLACK);
		r.setOpacity(.75);
		
		mediaplayer.play();
		
		if (indice_joueur == 1) {
			
			
			String j2 = fichier.lecture("Joueur2.txt").get(0);
			Text j2win = new Text(j2 + " A GAGN� !");
			j2win.setX(360);
			j2win.setY(500);
			j2win.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			j2win.setFontSmoothingType(FontSmoothingType.LCD);
			j2win.setFill(Color.WHITE);
			
			double W2 = j2win.getBoundsInLocal().getWidth();
			j2win.relocate(495 - W2 / 2, 460);
			
			root.getChildren().addAll(r, j2win);
			root.requestFocus();
		}
		
		else if (indice_joueur == 2) {
			
			String j1 = fichier.lecture("Joueur1.txt").get(0);
			Text j1win = new Text(j1 + " A GAGN� !");
			j1win.setX(360);
			j1win.setY(500);
			j1win.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			j1win.setFontSmoothingType(FontSmoothingType.LCD);
			j1win.setFill(Color.WHITE);
			
			double W1 = j1win.getBoundsInLocal().getWidth();
			j1win.relocate(495 - W1 / 2, 460);
			
			root.getChildren().addAll(r, j1win);
			root.requestFocus();
		}
		
		else {
			
			Text eg = new Text("�GALIT� !");
			eg.setX(390);
			eg.setY(500);
			eg.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			eg.setFontSmoothingType(FontSmoothingType.LCD);
			eg.setFill(Color.WHITE);
			
			root.getChildren().addAll(r, eg);
			root.requestFocus();		
		}	
	}
}
