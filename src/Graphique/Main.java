package Graphique;

import java.awt.TextField;
import java.beans.EventHandler;
import Programme.Joueur;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
		
		Scene scene = new Scene(root, 1280, 970, Color.WHITE);
		System.out.println("root cree");
		System.out.println("scene");
		Plateau p = new Plateau();
		System.out.println("plateau");
		Pieces listePiece = new Pieces(p);
		System.out.println("piece");
		Joueur joueur1 = new Joueur(1, p); Score scorej1 = new Score(joueur1); joueur1.setScore(scorej1);
		System.out.println("j1");
		Joueur joueur2 = new Joueur(2, p); Score scorej2 = new Score(joueur2); joueur2.setScore(scorej2);
		System.out.println("j2");
		
		Clavier clav = new Clavier(joueur2, joueur1, listePiece);
		Menu menu = new Menu(clav);
		
		root.getChildren().add(p);
		root.getChildren().add(scorej1);
		root.getChildren().add(scorej2);
		root.getChildren().add(listePiece);
		root.getChildren().add(joueur1);
		root.getChildren().add(joueur2);
		root.getChildren().add(menu);
		root.getChildren().add(clav);


		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
