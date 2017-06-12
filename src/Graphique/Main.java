package Graphique;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import Grammaire.Expression;
import I_O.fichier;
import Parser.ParseException;
import Parser.Reader;
import Programme.Joueur;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import Graphique.Choix_Robot.*;


public class Main extends Application {
	private int t = 120;
	Stage thestage;
	Group pane3;
	Button btnscene1, btnscene2;
	Scene scene2, scene3;
	
	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}

	
	
	@Override
	public void start(Stage primaryStage) throws ParseException {
		
		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");
		fichier.initialisation();
		thestage = primaryStage;
		pane3 = new Group();
		scene3 = new Scene(pane3, 1280, 970, Color.DARKGREY);

		
		Obstacles o = new Obstacles();

		Plateau p = new Plateau(o, pane3);

		InputStream in = new ByteArrayInputStream("{M}".getBytes());
	    Reader parser = new Reader(in);
		Expression exp = Reader.read(parser);

		Joueur joueur1 = new Joueur(1, p, pane3, exp);
		Score score1 = new Score(joueur1);
		joueur1.setScore(score1);

		Joueur joueur2 = new Joueur(2, p, pane3, exp);
		Score score2 = new Score(joueur2);
		joueur2.setScore(score2);

		Clavier clav = new Clavier(joueur2, joueur1, p, pane3);

		Text temps = new Text("temp : " + String.valueOf(this.t));
		temps.setX(1055);
		temps.setY(500);
		temps.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));

		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				compteArebour(temps, pane3);
			}
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		
		Menu menu = new Menu(clav, timeline);
		System.out.println("1");
		pane3.getChildren().addAll(p, score1, score2, o, joueur1, joueur2, menu, clav, temps);
		System.out.println("2");
		
		new Choix_Robot(primaryStage,thestage,scene3);
		
	}
	


	public void compteArebour(Text temps, Group pane3) {
		if (this.t > 0) {
			this.t--;
			temps.setText("temp : " + String.valueOf(this.t));
		} else {
			new End(pane3);
		}

	}
}
