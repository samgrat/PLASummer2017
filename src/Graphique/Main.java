package Graphique;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	private int t = 151;
	
	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws ParseException {
		primaryStage.setTitle("THE FLOOR IS LAVA");
        
		Group root = new Group();
		
		Scene scene = new Scene(root, 1480, 970, Color.DARKGREY);
		
		final URL resource = getClass().getResource("images/Textures/hit.mp3");
	    final Media media = new Media(resource.toString());
	    final MediaPlayer mediaPlayer = new MediaPlayer(media);
	    
		InputStream in = new ByteArrayInputStream("{E}".getBytes());
	    Reader parser = new Reader(in);
		Expression exp = Reader.read(parser);

		Plateau p = new Plateau(root);
		
		Joueur joueur1 = new Joueur(1, p, root, exp, mediaPlayer);
		Score score1 = new Score(joueur1);
		joueur1.setScore(score1);
		
		Joueur joueur2 = new Joueur(2, p, root, exp, mediaPlayer);
		Score score2 = new Score(joueur2);
		joueur2.setScore(score2);
		
		p.setJoueur(joueur1, joueur2);

		Clavier clav = new Clavier(joueur2, joueur1, p, root);

		Text temps = new Text(String.valueOf(this.t));
		temps.setX(1090);
		temps.setY(505);

		temps.setFill(Color.hsb(0, .0, .2));
		temps.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 50));
		temps.setFontSmoothingType(FontSmoothingType.LCD);
		compteArebour(temps, root);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				compteArebour(temps, root);
			}
		}));
		
		timeline.setCycleCount(Animation.INDEFINITE);
		
		Menu menu = new Menu(clav, timeline, joueur1, joueur2);

		root.getChildren().addAll(p, score1, score2, joueur1, joueur2, menu, clav, temps);

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
		
		// centrage du timer dans l'interface prvue
		double W = temps.getBoundsInLocal().getWidth();
		double H = temps.getBoundsInLocal().getHeight();
		temps.relocate(1125-W/2, 485-H/2);

	}

}
