package Graphique;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Nom extends Application {
	 
    public void start(Stage primaryStage) throws Exception {
 
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(25);
        root.setVgap(15);
        
        Text titre = new Text("Choisissez les noms des joueurs !");
        GridPane.setHalignment(titre, HPos.RIGHT);
        root.add(titre, 1, 0, 2, 1);
		
        Text nomJ1 = new Text("Nom du joueur 1 :");
        TextField setNomJ1 = new TextField();
        GridPane.setHalignment(nomJ1, HPos.CENTER);
        root.add(nomJ1, 1, 3);
        root.add(setNomJ1, 2, 3);
        
        Text nomJ2 = new Text("Nom du joueur 2 :");
        TextField setNomJ2 = new TextField();  
        GridPane.setHalignment(nomJ2, HPos.CENTER);
        root.add(nomJ2, 1, 4);
        root.add(setNomJ2, 2, 4);
		
		Button boutonJouer = new Button("Jouer !");
		GridPane.setHalignment(boutonJouer, HPos.RIGHT);
		root.add(boutonJouer, 2, 6);
			
		boutonJouer.setOnAction(new EventHandler<ActionEvent>() {

			/* TODO :
			 * - Gestion du cas o les noms sont similaires
			 * - Gestion du cas o les champs entrs sont vides
			 */
			
			public void handle(ActionEvent event) {
				
				String getNomJ1 = setNomJ1.getText();
				System.out.printf("nom du joueur 1 : ");
				System.out.println(getNomJ1);
				
				String getNomJ2 = setNomJ2.getText();
				System.out.printf("nom du joueur 2 : ");
				System.out.println(getNomJ2);
			
				primaryStage.close();
			}
		});
		
        Scene scene = new Scene(root, 400, 225);
		
        primaryStage.setTitle("Slection des noms des joueurs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
    public static void main(String[] args) {
        launch(args);
    }
 
}
