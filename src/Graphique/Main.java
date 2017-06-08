package Graphique;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import Grammaire.Expression;
import Parser.ParseException;
import Parser.Reader;
import Programme.Joueur;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	private int t = 120;

	public static void main(String[] args) {
		// Application.launch(Nom.class, args);
		Application.launch(Main.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws ParseException {
		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");

		Group root = new Group();

		Scene scene = new Scene(root, 1280, 970, Color.DARKGREY);

		Pieces listePiece = new Pieces();
		Obstacles o = new Obstacles();

		Plateau p = new Plateau(listePiece, o);
		
		Joueur joueur1 = new Joueur(1, p, root, null); Score score1 = new Score(joueur1); joueur1.setScore(score1);
		
		Joueur joueur2 = new Joueur(2, p, root, null); Score score2 = new Score(joueur2); joueur2.setScore(score2);
		
		Clavier clav = new Clavier(joueur2, joueur1, p, root);
	
		Menu menu = new Menu(clav, null);

		root.getChildren().add(p);
		root.getChildren().add(score1);
		root.getChildren().add(score2);
		root.getChildren().add(listePiece);
		root.getChildren().add(o);
		root.getChildren().add(joueur1);
		root.getChildren().add(joueur2);
		root.getChildren().add(menu);
		root.getChildren().add(clav);

		InputStream in = new ByteArrayInputStream("{M}".getBytes());
	    Reader parser = new Reader(in);
		Expression exp = Reader.read(parser);

		Joueur joueur1 = new Joueur(1, p, root, exp);
		Score score1 = new Score(joueur1);
		joueur1.setScore(score1);

		Joueur joueur2 = new Joueur(2, p, root, exp);
		Score score2 = new Score(joueur2);
		joueur2.setScore(score2);

		Clavier clav = new Clavier(joueur2, joueur1, p, root);

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
		if (this.t > 0) {
			this.t--;
			temps.setText("temp : " + String.valueOf(this.t));
		} else {
			new End(root);
		}

	}
}
