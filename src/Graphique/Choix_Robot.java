package Graphique;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import I_O.fichier;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Choix_Robot{
//	final ArrayList<String> j1;
//	final ArrayList<String> j2;
	
	GridPane pane2;
	Scene scene2;
	Button btnscene2;
	
	
	
	public  Choix_Robot(Stage primaryStage, Stage thestage, Scene scene3) {

		ArrayList<String> j1 = fichier.lecture("Joueur1.txt");
		ArrayList<String> j2 = fichier.lecture("Joueur2.txt");
		final BooleanProperty firstTime = new SimpleBooleanProperty(true);
		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");

		pane2 = new GridPane();
		pane2.setPadding(new Insets(10));
		pane2.setHgap(25);
		pane2.setVgap(15);


		Text titre = new Text("Joueur 1");
		GridPane.setHalignment(titre, HPos.CENTER);
		pane2.add(titre, 2, 2);

		Text nomJ11 = new Text("Robot 1 :");
		TextField setRobot11 = new TextField();
		setRobot11.setPromptText(j1.get(0));
		GridPane.setHalignment(nomJ11, HPos.CENTER);
		pane2.add(nomJ11, 1, 3);
		pane2.add(setRobot11, 2, 3);

		Text nomJ12 = new Text("Robot 2 :");
		TextField setRobot12 = new TextField();
		setRobot12.setPromptText(j1.get(1));
		GridPane.setHalignment(nomJ12, HPos.CENTER);
		pane2.add(nomJ12, 1, 4);
		pane2.add(setRobot12, 2, 4);

		Text nomJ13 = new Text("Robot 3 :");
		TextField setRobot13 = new TextField();
		setRobot13.setPromptText(j1.get(2));
		GridPane.setHalignment(nomJ13, HPos.CENTER);
		pane2.add(nomJ13, 1, 5);
		pane2.add(setRobot13, 2, 5);

		Text nomJ14 = new Text("Robot 4:");
		TextField setRobot14 = new TextField();
		setRobot14.setPromptText(j1.get(3));
		GridPane.setHalignment(nomJ14, HPos.CENTER);
		pane2.add(nomJ14, 1, 6);
		pane2.add(setRobot14, 2, 6);

		Text titre1 = new Text("Joueur 2");
		GridPane.setHalignment(titre1, HPos.CENTER);
		pane2.add(titre1, 2, 10);

		Text nomJ21 = new Text("Robot 1 :");
		TextField setRobot21 = new TextField();
		setRobot21.setPromptText(j2.get(0));
		GridPane.setHalignment(nomJ21, HPos.CENTER);
		pane2.add(nomJ21, 1, 11);
		pane2.add(setRobot21, 2, 11);

		Text nomJ22 = new Text("Robot 2 :");
		TextField setRobot22 = new TextField();
		setRobot22.setPromptText(j2.get(1));
		GridPane.setHalignment(nomJ22, HPos.CENTER);
		pane2.add(nomJ22, 1, 12);
		pane2.add(setRobot22, 2, 12);

		Text nomJ23 = new Text("Robot 3 :");
		TextField setRobot23 = new TextField();
		setRobot23.setPromptText(j2.get(2));
		GridPane.setHalignment(nomJ23, HPos.CENTER);
		pane2.add(nomJ23, 1, 13);
		pane2.add(setRobot23, 2, 13);

		Text nomJ24 = new Text("Robot 4:");
		TextField setRobot24 = new TextField();
		setRobot24.setPromptText(j2.get(3));
		GridPane.setHalignment(nomJ24, HPos.CENTER);
		pane2.add(nomJ24, 1, 14);
		pane2.add(setRobot24, 2, 14);

		// Déselectionne les champs
		setRobot11.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue && firstTime.get()) {
				pane2.requestFocus(); // Delegate the focus to container
				firstTime.setValue(false); // Variable value changed for future
											// references
			}
		});

		btnscene2 = new Button("Enregistrer");
		GridPane.setHalignment(btnscene2, HPos.CENTER);
		pane2.add(btnscene2, 2, 16);
		btnscene2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				ArrayList<String> J1bis = new ArrayList<String>();
				J1bis.add(setRobot11.getText());
				J1bis.add(setRobot12.getText());
				J1bis.add(setRobot13.getText());
				J1bis.add(setRobot14.getText());

				for (int i = 0; i < J1bis.size(); i++) {
					if (J1bis.get(i) != "") {
						System.out.println(J1bis.get(i));
						j1.add(i, J1bis.get(i));
					}
				}

				ArrayList<String> J2bis = new ArrayList<String>();
				J2bis.add(setRobot21.getText());
				J2bis.add(setRobot22.getText());
				J2bis.add(setRobot23.getText());
				J2bis.add(setRobot24.getText());

				for (int i = 0; i < J2bis.size(); i++) {
					if (J2bis.get(i) != "") {
						j2.add(i, J2bis.get(i));
					}
				}
				 //ArrayList<String> t = new ArrayList<>();
				

				fichier.ecrire("joueur1.txt", J1bis);
				fichier.ecrire("joueur2.txt", J2bis);

				
				primaryStage.close();
			}
		});

		System.out.println("Test 1");
		//pane2.getChildren().addAll(btnscene2);
		System.out.println("Test 2");
		
		btnscene2.setOnAction(e-> ButtonClicked(e,thestage,scene3));	
		
		Scene scene2 = new Scene(pane2, 330, 550);

		
		
		
		
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	public void ButtonClicked(ActionEvent e, Stage thestage, Scene scene3)
    {
        if (e.getSource()==btnscene2)
            thestage.setScene(scene3);
    }
}


