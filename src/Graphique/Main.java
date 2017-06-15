package Graphique;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;

import Grammaire.Comportement;
import Grammaire.Expression;
import Parser.ParseException;
import Parser.Reader;
import Graphique.Score;
import Programme.Joueur;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	
	public Plateau p;
	
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

		primaryStage.setTitle("THE FLOOR IS LAVA");
		
		thestage = primaryStage;
		
		pane3 = new Group();
		scene3 = new Scene(pane3, 1480, 970, Color.DARKGREY);
		
		new Choix_Robot(primaryStage,thestage,scene3,pane3);	
		

	}
}
