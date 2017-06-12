package Graphique;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;

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
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	private int t = 150;

	public static void main(String[] args) {
		// Application.launch(Nom.class, args);
		Application.launch(Main.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws ParseException {
		primaryStage.setTitle("THE FLOOR IS LAVA");

		Group root = new Group();

		Scene scene = new Scene(root, 1480, 970, Color.DARKGREY);

		Pieces listePiece = new Pieces();
		Obstacles o = new Obstacles();

		Plateau p = new Plateau(listePiece, o);
		
		Joueur joueur1 = new Joueur(1, p, root, null); Score score1 = new Score(joueur1); joueur1.setScore(score1);
		
		Joueur joueur2 = new Joueur(2, p, root, null); Score score2 = new Score(joueur2); joueur2.setScore(score2);
		
		Clavier clav = new Clavier(joueur2, joueur1, p, root);

		InputStream in = new ByteArrayInputStream("{M}".getBytes());
	    Reader parser = new Reader(in);
		Expression exp = Reader.read(parser);

		Text temps = new Text(String.valueOf(this.t));
		temps.setX(1090);
		temps.setY(505);
		temps.setFill(Color.hsb(0, .0, .2));
		temps.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 40));
		temps.setFontSmoothingType(FontSmoothingType.LCD);

		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				compteArebour(temps, root);
			}
		}));
		
		timeline.setCycleCount(Animation.INDEFINITE);

		Menu menu = new Menu(clav, timeline);

		root.getChildren().addAll(p, score1, score2, listePiece, joueur1, joueur2, menu, clav, temps);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void compteArebour(Text temps, Group root) {
		
		DecimalFormat formater = new DecimalFormat("00");
		
		if (this.t > 0) {
			this.t--;
			String min = String.valueOf(this.t / 60);
			String sec = formater.format(this.t % 60);
			temps.setText(min + ":" + sec);
		} else {
			new End(root);
		}
		
		// centrage du timer dans l'interface prévue
		double W = temps.getBoundsInLocal().getWidth();
		double H = temps.getBoundsInLocal().getHeight();
		temps.relocate(1125-W/2, 485-H/2);

	}
}
