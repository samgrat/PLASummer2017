package Graphique;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Grammaire.Comportement;
import Grammaire.Expression;
import I_O.fichier;
import Parser.ParseException;
import Parser.Reader;
import Programme.Joueur;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Choix_Robot {
	ArrayList<String> j1;
	ArrayList<String> j2;
	ArrayList<String> l1;
	ArrayList<String> lrobot;
	ArrayList<Integer> arg;

	final ComboBox<String> comboBox1 = new ComboBox(), comboBox2 = new ComboBox(), comboBox3 = new ComboBox(),
			comboBox4 = new ComboBox(), comboBox5 = new ComboBox(), comboBox6 = new ComboBox(),
			comboBox7 = new ComboBox(), comboBox8 = new ComboBox();

	public Joueur jou1, jou2;
	private int t = 121;
	GridPane pane2, pane1bis, pane2bis;
	Scene scene2, scene1bis, scene2bis;
	Button btnscene2, btnscene1bis, btnscene2bis, init1, init2;

	public Timeline timeline;
public String nomJ1;
public String nomJ2;
	
	
	
	private Comportement StringtoComportement(String s, Reader r) throws ParseException{
		InputStream in = new ByteArrayInputStream(s.getBytes());
		Reader.ReInit(in);
	    Expression exp = Reader.read(r);
	    Comportement comp = new Comportement(exp);
		return comp;
	}

	public void addNomJ1(String j1) {
		this.nomJ1 = j1;
	}

	public void modif(String s, TextField a) {
		switch (s) {
		case "Guerrier 1":
			a.setText(l1.get(0));
			break;
		case "Guerrier 2":
			a.setText(l1.get(1));
			break;
		case "Recolteur 1":
			a.setText(l1.get(2));
			break;
		case "Recolteur 2":
			a.setText(l1.get(3));
			break;
		case "Tourelle":
			a.setText(l1.get(4));
			break;
		case "Polyvalent":
			a.setText(l1.get(5));
			break;
		}
	}

	public EventHandler<KeyEvent> maxLength(final Integer i) {
		return new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {

				TextField tx = (TextField) arg0.getSource();
				if (tx.getText().length() >= i) {
					arg0.consume();
				}

			}

		};

	}

	public Choix_Robot(Stage primaryStage, Stage thestage, Scene scene3, Group pane3) {

		// fichier.initialisation();
		String a = "Guerrier 1", b = "Guerrier 2", c = "Recolteur 1", d = "Recolteur 2", e = "Tourelle",
				f = "Polyvalent";
		j1 = fichier.lecture("Joueur1.txt");
		j2 = fichier.lecture("Joueur2.txt");
		ImageView bg = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/fenetre.png")));	
		bg.setTranslateX(-11);
		bg.setTranslateY(-11);
		l1 = fichier.lecture("Modele.txt");

		pane1bis = new GridPane();
		pane2bis = new GridPane();

		scene1bis = new Scene(pane1bis, 350, 320);
		scene2bis = new Scene(pane2bis, 350, 320);

		pane1bis.setPadding(new Insets(10));
		pane1bis.setHgap(25);
		pane1bis.setVgap(15);

		primaryStage.setScene(scene1bis);
		primaryStage.show();

		Text nom1 = new Text("Nom Joueur 1");
		TextField setnom1 = new TextField();
		setnom1.addEventFilter(KeyEvent.KEY_TYPED, maxLength(11));
		
		GridPane.setHalignment(nom1, HPos.LEFT);
		pane1bis.add(nom1, 1, 2);
		pane1bis.add(setnom1, 2, 2);
		pane1bis.add(new Text("1"), 0, 3);

		TextField setRobot11 = new TextField(j1.get(1));
		setRobot11.getText();
		// GridPane.setHalignment(nomJ11, HPos.CENTER);
		comboBox1.setPrefWidth(150);
		comboBox1.getItems().setAll(a, b, c, d, e, f);
		pane1bis.add(comboBox1, 1, 3);
		pane1bis.add(new Text("1"), 0, 3);
		pane1bis.add(setRobot11, 2, 3);
		comboBox1.valueProperty().addListener(observable -> {
			modif(comboBox1.getValue(), setRobot11);

		});

		TextField setRobot12 = new TextField(j1.get(2));
		setRobot12.getText();
		// GridPane.setHalignment(nomJ12, HPos.CENTER);
		comboBox2.setPrefWidth(150);
		comboBox2.getItems().setAll(a, b, c, d, e, f);
		pane1bis.add(new Text("2"), 0, 4);
		pane1bis.add(comboBox2, 1, 4);
		// pane1bis.add(nomJ12, 1, 4);
		pane1bis.add(setRobot12, 2, 4);
		comboBox2.valueProperty().addListener(observable -> {
			modif(comboBox2.getValue(), setRobot12);

		});

		TextField setRobot13 = new TextField(j1.get(3));
		setRobot13.getText();
		// GridPane.setHalignment(nomJ13, HPos.CENTER);
		comboBox3.setPrefWidth(150);
		comboBox3.getItems().setAll(a, b, c, d, e, f);
		// comboBox3.getSelectionModel().selectFirst();
		pane1bis.add(new Text("3"), 0, 5);
		pane1bis.add(comboBox3, 1, 5);
		// pane1bis.add(nomJ13, 1, 5);
		pane1bis.add(setRobot13, 2, 5);
		comboBox3.valueProperty().addListener(observable -> {
			modif(comboBox3.getValue(), setRobot13);

		});

		TextField setRobot14 = new TextField(j1.get(4));
		setRobot14.getText();
		// GridPane.setHalignment(nomJ14, HPos.CENTER);
		comboBox4.setPrefWidth(150);
		comboBox4.getItems().setAll(a, b, c, d, e, f);
		pane1bis.add(new Text("4"), 0, 6);
		pane1bis.add(comboBox4, 1, 6);
		// pane1bis.add(nomJ14, 1, 6);
		pane1bis.add(setRobot14, 2, 6);
		comboBox4.valueProperty().addListener(observable -> {
			modif(comboBox4.getValue(), setRobot14);

		});

		Text nom2 = new Text("Nom Joueur 2");
		TextField setnom2 = new TextField();
		setnom2.addEventFilter(KeyEvent.KEY_TYPED, maxLength(11));
		// GridPane.setHalignment(nom2, HPos.LEFT);
		pane2bis.add(nom2, 1, 2);
		pane2bis.add(setnom2, 2, 2);

		TextField setRobot21 = new TextField(j2.get(1));
		setRobot21.getText();
		// GridPane.setHalignment(nomJ21, HPos.CENTER);
		comboBox5.setPrefWidth(150);
		comboBox5.getItems().setAll(a, b, c, d, e, f);
		pane2bis.add(comboBox5, 1, 3);
		pane2bis.add(new Text("1"), 0, 3);
		// pane2bis.add(nomJ21, 1, 3);
		pane2bis.add(setRobot21, 2, 3);
		comboBox5.valueProperty().addListener(observable -> {
			modif(comboBox5.getValue(), setRobot21);

		});

		TextField setRobot22 = new TextField(j2.get(2));
		setRobot22.getText();
		// GridPane.setHalignment(nomJ22, HPos.CENTER);
		comboBox6.setPrefWidth(150);
		comboBox6.getItems().setAll(a, b, c, d, e, f);
		pane2bis.add(comboBox6, 1, 4);
		pane2bis.add(new Text("2"), 0, 4);
		// pane2bis.add(nomJ22, 1, 4);
		pane2bis.add(setRobot22, 2, 4);
		comboBox6.valueProperty().addListener(observable -> {
			modif(comboBox6.getValue(), setRobot22);

		});

		TextField setRobot23 = new TextField(j2.get(3));
		setRobot23.getText();
		// GridPane.setHalignment(nomJ23, HPos.CENTER);
		comboBox7.setPrefWidth(150);
		comboBox7.getItems().setAll(a, b, c, d, e, f);
		pane2bis.add(comboBox7, 1, 5);
		pane2bis.add(new Text("3"), 0, 5);
		// pane2bis.add(nomJ23, 1, 5);
		pane2bis.add(setRobot23, 2, 5);
		comboBox7.valueProperty().addListener(observable -> {
			modif(comboBox7.getValue(), setRobot23);

		});

		TextField setRobot24 = new TextField(j2.get(4));
		setRobot24.getText();
		// GridPane.setHalignment(nomJ24, HPos.CENTER);
		comboBox8.setPrefWidth(150);
		comboBox8.getItems().setAll(a, b, c, d, e, f);
		pane2bis.add(comboBox8, 1, 6);
		pane2bis.add(new Text("4"), 0, 6);
		// pane2bis.add(nomJ24, 1, 6);
		pane2bis.add(setRobot24, 2, 6);
		comboBox8.valueProperty().addListener(observable -> {
			modif(comboBox8.getValue(), setRobot24);

		});
		Button btnscene1bis = new Button("Enregistrer");
		// btnscene1bis.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		btnscene1bis.setDefaultButton(true);
		GridPane.setHalignment(btnscene1bis, HPos.CENTER);
		pane1bis.add(btnscene1bis, 2, 8);
		btnscene1bis.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ArrayList<String> J1bis = new ArrayList<String>();
				J1bis.add(setRobot11.getText());
				J1bis.add(setRobot12.getText());
				J1bis.add(setRobot13.getText());
				J1bis.add(setRobot14.getText());

				j1.add(0, setnom1.getText());
				for (int i = 0; i < 4; i++) {
					if (J1bis.get(i) != "") {
						// System.out.println("Affichage � l'indice "+ i + "du
						// tableau j1 : " + J1bis.get(i));
						j1.add(i + 1, J1bis.get(i));
					}
				}

				PrintWriter pw;
				try {
					pw = new PrintWriter(new BufferedWriter(new FileWriter("Joueur1.txt", false)));
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
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		hbox1.setPrefWidth(100);
		hbox2.setPrefWidth(100);
		
		init1 = new Button("Modele");
		init2 = new Button("Modele");

		hbox1.getChildren().add(init1);
		hbox2.getChildren().add(init2);

		pane1bis.add(hbox1, 1, 8);
		pane2bis.add(hbox2, 1, 8);

		init1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// fichier.initialisation("Joueur1.txt");
				// j1 = fichier.lecture("Joueur1.txt");
				setRobot11.setText(l1.get(0));
				comboBox1.setValue(a);
				setRobot12.setText(l1.get(1));
				comboBox2.setValue(b);
				setRobot13.setText(l1.get(2));
				comboBox3.setValue(c);
				setRobot14.setText(l1.get(3));
				comboBox4.setValue(d);

			}
		});

		init2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// fichier.initialisation("Joueur2.txt");
				// j2 = fichier.lecture("Joueur2.txt");
				setRobot21.setText(l1.get(0));
				comboBox5.setValue(a);
				setRobot22.setText(l1.get(1));
				comboBox6.setValue(b);
				setRobot23.setText(l1.get(2));
				comboBox7.setValue(c);
				setRobot24.setText(l1.get(3));
				comboBox8.setValue(d);
			}
		});

		btnscene2bis = new Button("Enregistrer");
		btnscene2bis.setDefaultButton(true);
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
					pw = new PrintWriter(new BufferedWriter(new FileWriter("Joueur2.txt", false)));
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
				try {
					ButtonClicked(event, thestage, scene3, pane3);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	public void ButtonClicked(ActionEvent e, Stage thestage, Scene scene3, Group pane3) throws ParseException {
		if (e.getSource() == btnscene2bis){
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

		//pane3.getChildren().add(joueur1);
		//pane3.getChildren().add(joueur2);

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
		// TODO : scanf pour entrer le nom des joueurs en d�but de partie
		
		final URL resource = getClass().getResource("images/Textures/hit.mp3");
	    final Media media = new Media(resource.toString());
	    final MediaPlayer mediaPlayer = new MediaPlayer(media);
	    

		thestage.setScene(scene3);
		thestage.centerOnScreen();
		
		
		Comportement compj1[] = new Comportement[4];
		Comportement compj2[] = new Comportement[4];
		
		String express_j1[] = new String[4];		
		String express_j2[] = new String[4];		
		
		for(int i = 0; i < express_j1.length; i++){
			express_j1[i] = j1.get(i+1);			
			express_j2[i] = j2.get(i+1);
		}
		
		//String express_j1[] = {"{E}","{M}","{M;E}","{M|E}"};
		//String express_j2[] = {"{M}","{E}","{M;E}","{M|E}"};
		
		InputStream init = new ByteArrayInputStream("".getBytes());
	    Reader r = new Reader(init);
			
	    for(int i = 0; i < 4; i++){
			compj1[i] = StringtoComportement(express_j1[i], r);
			compj2[i] = StringtoComportement(express_j2[i], r);
		}
		
	    int tabCoutRVPj1[][] = new int[express_j1.length][3] ;
		int tabCoutRVPj2[][] = new int[express_j2.length][3] ;
		
		for(int i = 0 ; i < express_j1.length ; i++){
			tabCoutRVPj1[i] = CoutRobot(express_j1[i]);
			tabCoutRVPj2[i] = CoutRobot(express_j2[i]);
		}
		Plateau p = new Plateau(pane3);
		
		jou1 = new Joueur(1, p, pane3, compj1, tabCoutRVPj1, mediaPlayer);
		Score score1 = new Score(jou1);
		jou1.setScore(score1);
		
		jou2 = new Joueur(2, p, pane3, compj2, tabCoutRVPj2, mediaPlayer);
		Score score2 = new Score(jou2);
		jou2.setScore(score2);
		
		p.setJoueur(jou1, jou2);
		
		Clavier clav = new Clavier(jou2, jou1, p, pane3);

		Text temps = new Text(String.valueOf(this.t));
		temps.setX(1090);
		temps.setY(505);

		temps.setFill(Color.hsb(0, .0, .2));
		temps.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 50));
		temps.setFontSmoothingType(FontSmoothingType.LCD);
		
		compteArebour(temps, pane3);

		timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				compteArebour(temps, pane3);

			}
		}));
		
		timeline.setCycleCount(Animation.INDEFINITE);
		jou1.setTimeline(timeline);
		jou2.setTimeline(timeline);

		Menu menu = new Menu(clav, timeline, jou1, jou2);
		
	
		pane3.getChildren().addAll(p, score1, score2,  jou1, jou2, menu, clav, temps,joueur1,joueur2);	
		}
	}

public void compteArebour(Text temps, Group pane3) {
	int scorej1, scorej2;
		DecimalFormat formater = new DecimalFormat("00");
		
		if (this.t > 0) {
			this.t--;
			String min = String.valueOf(this.t / 60);
			String sec = formater.format(this.t % 60);
			temps.setText(min + ":" + sec);
		} else {
			//System.out.println(joueur1.getPieces());
			scorej1 = jou1.getPieces();
			scorej2 = jou2.getPieces();
			
			if (scorej1 > scorej2) {
				new End(pane3, 2, timeline);
				timeline.stop();
			}
			
			else if (scorej1 < scorej2) {
				new End(pane3, 1, timeline);
				timeline.stop();
			}
			
			else {
				new End(pane3, 0, timeline);
				timeline.stop();
			}
		}
		
		// centrage du timer dans l'interface prevue
		double W = temps.getBoundsInLocal().getWidth();
		double H = temps.getBoundsInLocal().getHeight();
		temps.relocate(1125-W/2, 485-H/2);
}

/**
 * Retourne le cout du robot correspondant a la sequence entree
 * @param s
 * @return
 */
private int[] CoutRobot(String s) {
	int tabCoutRVP[] = new int[3];
	for (int i = 0; i < s.length(); i++) {
		switch (s.charAt(i)) {
		// piece Rose
		case '{':
		case '}':
		case '|':
		case ';':
			tabCoutRVP[0]++;
			break;
		// piece Vert
		case 'M':
		case 'H':
		case 'R':
			tabCoutRVP[1]++;
			break;
		// piece Violette
		case '>':
		case 'E':
			tabCoutRVP[2]++;
			break;
		default:
			System.out.println("Erreur: operateur non reconnu");
			System.exit(-1);

		}
	}
	return tabCoutRVP;
}
}
