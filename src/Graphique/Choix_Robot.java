package Graphique;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import I_O.fichier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Choix_Robot {
	ArrayList<String> j1;
	ArrayList<String> j2;

	GridPane pane2, pane1bis, pane2bis;
	Scene scene2, scene1bis, scene2bis;
	Button btnscene2, btnscene1bis, btnscene2bis;
	public String nomJ1;
	public String nomJ2;

	public void addNomJ1(String j1) {
		this.nomJ1 = j1;
	}

	public String getNomJ2() {
		return this.nomJ2;
	}

	public Choix_Robot(Stage primaryStage, Stage thestage, Scene scene3, Group pane3) {

		// fichier.initialisation();
		j1 = fichier.lecture("Joueur1.txt");
		j2 = fichier.lecture("Joueur2.txt");

		primaryStage.setTitle("Zombie War Machinator Demolition Evolution III");

		pane1bis = new GridPane();
		pane2bis = new GridPane();
		scene1bis = new Scene(pane1bis, 330, 320);
		scene2bis = new Scene(pane2bis, 330, 320);
		pane1bis.setPadding(new Insets(10));
		pane1bis.setHgap(25);
		pane1bis.setVgap(15);

		pane2bis.setPadding(new Insets(10));
		pane2bis.setHgap(25);
		pane2bis.setVgap(15);

		primaryStage.setScene(scene1bis);
		primaryStage.show();

		Text nom1 = new Text("Nom Joueur 1");
		TextField setnom1 = new TextField();
		// //nomJ1 = setnom1.getText();
		// System.out.println("Test nom 1" + nomJ1);
		GridPane.setHalignment(nom1, HPos.LEFT);
		pane1bis.add(nom1, 1, 2);
		pane1bis.add(setnom1, 2, 2);

		Text nomJ11 = new Text("Robot 1 :");
		TextField setRobot11 = new TextField(j1.get(1));
		setRobot11.getText();
		GridPane.setHalignment(nomJ11, HPos.CENTER);
		pane1bis.add(nomJ11, 1, 3);
		pane1bis.add(setRobot11, 2, 3);

		Text nomJ12 = new Text("Robot 2 :");
		TextField setRobot12 = new TextField(j1.get(2));
		setRobot12.getText();
		GridPane.setHalignment(nomJ12, HPos.CENTER);
		pane1bis.add(nomJ12, 1, 4);
		pane1bis.add(setRobot12, 2, 4);

		Text nomJ13 = new Text("Robot 3 :");
		TextField setRobot13 = new TextField(j1.get(3));
		setRobot13.getText();
		GridPane.setHalignment(nomJ13, HPos.CENTER);
		pane1bis.add(nomJ13, 1, 5);
		pane1bis.add(setRobot13, 2, 5);

		Text nomJ14 = new Text("Robot 4:");
		TextField setRobot14 = new TextField(j1.get(4));
		setRobot14.getText();
		GridPane.setHalignment(nomJ14, HPos.CENTER);
		pane1bis.add(nomJ14, 1, 6);
		pane1bis.add(setRobot14, 2, 6);

		Text nom2 = new Text("Nom Joueur 2");
		TextField setnom2 = new TextField();
		GridPane.setHalignment(nom2, HPos.LEFT);
		pane2bis.add(nom2, 1, 2);
		pane2bis.add(setnom2, 2, 2);

		Text nomJ21 = new Text("Robot 1 :");
		TextField setRobot21 = new TextField(j2.get(1));
		setRobot21.getText();
		GridPane.setHalignment(nomJ21, HPos.CENTER);
		pane2bis.add(nomJ21, 1, 3);
		pane2bis.add(setRobot21, 2, 3);

		Text nomJ22 = new Text("Robot 2 :");
		TextField setRobot22 = new TextField(j2.get(2));
		setRobot22.getText();
		GridPane.setHalignment(nomJ22, HPos.CENTER);
		pane2bis.add(nomJ22, 1, 4);
		pane2bis.add(setRobot22, 2, 4);

		Text nomJ23 = new Text("Robot 3 :");
		TextField setRobot23 = new TextField(j2.get(3));
		setRobot23.getText();
		GridPane.setHalignment(nomJ23, HPos.CENTER);
		pane2bis.add(nomJ23, 1, 5);
		pane2bis.add(setRobot23, 2, 5);

		Text nomJ24 = new Text("Robot 4:");
		TextField setRobot24 = new TextField(j2.get(4));
		setRobot24.getText();
		GridPane.setHalignment(nomJ24, HPos.CENTER);
		pane2bis.add(nomJ24, 1, 6);
		pane2bis.add(setRobot24, 2, 6);

		Button btnscene1bis = new Button("Enregistrer");
		GridPane.setHalignment(btnscene1bis, HPos.CENTER);
		pane1bis.add(btnscene1bis, 2, 8);
		btnscene1bis.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Bouton 1 activer");
				ArrayList<String> J1bis = new ArrayList<String>();
				J1bis.add(setRobot11.getText());
				J1bis.add(setRobot12.getText());
				J1bis.add(setRobot13.getText());
				J1bis.add(setRobot14.getText());

				j1.add(0, setnom1.getText());
				for (int i = 0; i < 4; i++) {
					if (J1bis.get(i) != "") {
						// System.out.println("Affichage à l'indice "+ i + "du
						// tableau j1 : " + J1bis.get(i));
						j1.add(i + 1, J1bis.get(i));
					}
				}

				PrintWriter pw;
				try {
					pw = new PrintWriter(new BufferedWriter(new FileWriter("joueur1.txt", false)));
					pw.println(j1.get(0));

					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int j = 1; j < 5; j++) {
					String ligne = j1.get(j);
					fichier.ecrire("Joueur1.txt", ligne);
				}
				// ArrayList<String> J1 = fichier.lecture("joueur1.txt");
				// System.out.println("TEST NOM = " + J1.get(0));
				primaryStage.setScene(scene2bis);
			}

		});

		btnscene2bis = new Button("Enregistrer");
		GridPane.setHalignment(btnscene2bis, HPos.CENTER);
		pane2bis.add(btnscene2bis, 2, 8);
		btnscene2bis.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// System.out.println("Bouton 2 activer");
				ArrayList<String> J2bis = new ArrayList<String>();

				j2.add(0, setnom2.getText());
				J2bis.add(setRobot21.getText());
				J2bis.add(setRobot22.getText());
				J2bis.add(setRobot23.getText());
				J2bis.add(setRobot24.getText());

				j2.add(0, setnom2.getText());
				for (int i = 0; i < J2bis.size(); i++) {
					if (J2bis.get(i) != "") {
						j2.add(i + 1, J2bis.get(i));
					}
				}

				PrintWriter pw;
				try {
					pw = new PrintWriter(new BufferedWriter(new FileWriter("joueur2.txt", false)));
					pw.println(j2.get(0));

					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int j = 1; j < 5; j++) {
					String ligne = j2.get(j);
					fichier.ecrire("Joueur2.txt", ligne);
				}
				ButtonClicked(event, thestage, scene3, pane3);
				// primaryStage.close();
			}
		});
	}

	public String GetNom1() {
		return j1.get(0);
	}

	public String GetNom2() {
		return j2.get(0);
	}

	public void ButtonClicked(ActionEvent e, Stage thestage, Scene scene3, Group pane3) {
		if (e.getSource() == btnscene2bis)
			nomJ1 = j1.get(0);
		nomJ2 = j2.get(0);
		Text joueur1 = new Text(j1.get(0));
		Text joueur2 = new Text(j2.get(0));

		joueur1.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		joueur1.setX(1025);
		joueur2.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		joueur2.setX(1025);

		joueur1.setFill(Color.BLUE);
		joueur1.setY(45);

		joueur2.setFill(Color.RED);
		joueur2.setY(950);

		pane3.getChildren().add(joueur1);
		pane3.getChildren().add(joueur2);

		joueur1.setFill(Color.ROYALBLUE);
		// centrage du nom du joueur dans l'interface prevue
		double W1 = joueur1.getBoundsInLocal().getWidth();
		double H1 = joueur1.getBoundsInLocal().getHeight();
		joueur1.relocate(1125 - W1 / 2, 30 - H1 / 2);

		joueur2.setFill(Color.RED);
		// centrage du nom du joueur dans l'interface prevue
		double W2 = joueur2.getBoundsInLocal().getWidth();
		double H2 = joueur2.getBoundsInLocal().getHeight();
		joueur2.relocate(1125 - W2 / 2, 938 - H2 / 2);

		// TODO : centrer les noms dans les cases correspondantes
		// TODO : scanf pour entrer le nom des joueurs en début de partie

		thestage.setScene(scene3);
	}
}
