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
		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");
		
		Group root = new Group();
		Scene scene = new Scene(root, 1280, 970, Color.DARKGREY);

		Pieces listePiece = new Pieces();
		Obstacles o = new Obstacles();

		Plateau p = new Plateau(listePiece, o);
		
		Joueur joueur1 = new Joueur(1, p, root); Score score1 = new Score(joueur1); joueur1.setScore(score1);
		
		Joueur joueur2 = new Joueur(2, p, root); Score score2 = new Score(joueur2); joueur2.setScore(score2);
		
		Clavier clav = new Clavier(joueur2, joueur1, p);
		
		Menu menu = new Menu(clav);
		
		
		root.getChildren().add(p);
		root.getChildren().add(score1);
		root.getChildren().add(score2);
		root.getChildren().add(listePiece);
		root.getChildren().add(o);
		root.getChildren().add(joueur1);
		root.getChildren().add(joueur2);
		root.getChildren().add(menu);
		root.getChildren().add(clav);


		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
