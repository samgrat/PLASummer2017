package Graphique;

import Parser.ParseException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	public Plateau p;

	Stage thestage;
	Group pane3;
	Button btnscene1, btnscene2;
	Scene scene2, scene3;
	String nomJ1, nomJ2;

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

