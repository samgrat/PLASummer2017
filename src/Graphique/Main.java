package Graphique;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import Dijkstra_explore.Dijkstra;
import Dijkstra_explore.Graphe;
import Grammaire.Comportement;
import Grammaire.Expression;
import Parser.ParseException;
import Parser.Reader;
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
	
	private Expression StringtoExpr(String s) throws ParseException{
		
		InputStream in = new ByteArrayInputStream(s.getBytes());
	    Reader parser = new Reader(in);
		Expression exp = Reader.read(parser);
		return exp;
	}

	@Override
	public void start(Stage primaryStage) throws ParseException {
		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");
		
		Group root = new Group();
		Scene scene = new Scene(root, 1280, 970, Color.DARKGREY);

		Pieces listePiece = new Pieces();
		Obstacles o = new Obstacles();

		Plateau p = new Plateau(listePiece, o);
		
//		for(int ori = 0; ori < 256; ori ++){
//			for(int dest = 0; dest < 256; dest ++){
//		Graphe g = new Graphe(p);
//		//System.out.println(g.toString());
//		Dijkstra d = new Dijkstra(g, ori, dest);
//		System.out.print("Dijkstra de "+d.origine+" a "+d.destination+" [ ");
//		for(int i = 0; i< d.chemin.size(); i++){
//			System.out.print(d.chemin.get(i)+" ");
//		}
//		System.out.println("]");
//			}
//		}
			
		Expression exp = StringtoExpr("{M;{H;{{H;H}|M}}}");
		
		Comportement comp = new Comportement(exp);
		
		Joueur joueur1 = new Joueur(1, p, root, comp); Score score1 = new Score(joueur1); joueur1.setScore(score1);
		
		Joueur joueur2 = new Joueur(2, p, root, comp); Score score2 = new Score(joueur2); joueur2.setScore(score2);
		
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
