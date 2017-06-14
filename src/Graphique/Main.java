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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	private int t = 120;
	Stage thestage;
	Group pane3;
	Button btnscene1, btnscene2;
	Scene scene2, scene3;
	String nomJ1,nomJ2;
	
	
	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws ParseException {
		

		
		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");
		thestage = primaryStage;
		pane3 = new Group();
		scene3 = new Scene(pane3, 1280, 970, Color.DARKGREY);
	
		Choix_Robot c1 = new Choix_Robot(primaryStage,thestage,scene3,pane3);	
		System.out.println("NOMNONM = "+c1.j1.get(0));

		Obstacles o = new Obstacles();

		Plateau p = new Plateau(o, pane3);

		InputStream in = new ByteArrayInputStream("{M}".getBytes());
	    Reader parser = new Reader(in);
		Expression exp = Reader.read(parser);

		Joueur joueur1 = new Joueur(1, p, pane3, exp);
	
		
		Score score1 = new Score(joueur1,c1.GetNom1());
		joueur1.setScore(score1);

		Joueur joueur2 = new Joueur(2, p, pane3, exp);
		Score score2 = new Score(joueur2,c1.GetNom2());
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
		
		primaryStage.setTitle("Game");
		
		

		
		pane3.getChildren().addAll(p, score1, score2, o, joueur1, joueur2, menu, clav, temps);	
		
		
		System.out.println("NIQUE TA MERE1 : "+ c1.GetNom1());
		//System.out.println("NIQUE TA MERE2.0 : "+ c1.nomJ1);
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
