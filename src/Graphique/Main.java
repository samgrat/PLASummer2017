package Graphique;

import Programme.Joueur;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Zombie War Machine Demolition Evolution III");
		
		Group root = new Group();
		
		Scene scene = new Scene(root, 1280, 970, Color.DARKGREY);
		
		Plateau p = new Plateau();
		
		Pieces listePiece = new Pieces(p);
		
		Joueur joueur1 = new Joueur(1, p); Score score1 = new Score(joueur1); joueur1.setScore(score1);
		
		Joueur joueur2 = new Joueur(2, p); Score score2 = new Score(joueur2); joueur2.setScore(score2);
		

		Clavier clav = new Clavier(joueur2, joueur1, listePiece);
		Menu menu = new Menu(clav);

		
		root.getChildren().add(p);
		root.getChildren().add(score1);
		root.getChildren().add(score2);
		root.getChildren().add(listePiece);
		root.getChildren().add(joueur1);
		root.getChildren().add(joueur2);
		root.getChildren().add(menu);
		root.getChildren().add(clav);


		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
