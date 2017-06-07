package Graphique;

import Programme.Joueur;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	private int t = 5;

	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");

		Group root = new Group();
		Scene scene = new Scene(root, 1280, 970, Color.DARKGREY);

		Pieces listePiece = new Pieces();
		Obstacles o = new Obstacles();
		Plateau p = new Plateau(listePiece, o);

		Joueur joueur1 = new Joueur(1, p, root);
		Score score1 = new Score(joueur1);
		joueur1.setScore(score1);

		Joueur joueur2 = new Joueur(2, p, root);
		Score score2 = new Score(joueur2);
		joueur2.setScore(score2);

		Clavier clav = new Clavier(joueur2, joueur1, p);

		
		
		Text temps = new Text("temp : " + String.valueOf(this.t));
		temps.setX(1055);
		temps.setY(500);
		temps.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				compteArebour(temps, root);
			}
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		
		Menu menu = new Menu(clav, timeline);
		
		root.getChildren().addAll(p, score1, score2, listePiece, o, joueur1, joueur2, menu, clav, temps);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void compteArebour(Text temps, Group root) {
		if(this.t>0){
			this.t--;
			temps.setText("temp : " + String.valueOf(this.t));
		}
		else {
			Rectangle fin = new Rectangle();
			fin.setX(300);
			fin.setY(400);
			fin.setWidth(500);
			fin.setHeight(200);
			fin.setArcHeight(500);
			fin.setArcWidth(50);
			Text GO = new Text("GAME OVER");
			GO.setX(450);
			GO.setY(450);
			GO.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
			GO.setFill(Color.WHITE);
			
			root.getChildren().add(fin);
			root.getChildren().add(GO);
			root.requestFocus();
		}
		
	}
}
