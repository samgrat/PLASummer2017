package Graphique;

import Programme.Joueur;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Menu extends Parent {

	public Menu(Clavier clav, Timeline timeline, Joueur j1, Joueur j2) {
		Button boutonMode1 = new Button();
		Button boutonMode2 = new Button();
		Button boutonMode3 = new Button();
		boutonMode1.setDefaultButton(true);
		boutonMode1.requestFocus();
		boutonMode1.setLayoutX(380);
		boutonMode1.setLayoutY(460);
		boutonMode1.setText("Easy");
		boutonMode1.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				boutonMode1.setVisible(false);
				boutonMode2.setVisible(false);
				boutonMode3.setVisible(false);
				j1.setDifficulte(1);
				j2.setDifficulte(1);
				System.out.println("Start Game");
				clav.requestFocus();
				timeline.play();
			}
		});

		/*
		 * active le bouton lorsque l'on appui sur entrer
		 */
		boutonMode1.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER) {
				boutonMode1.fire();
				ev.consume();

			} else if (ev.getCode() == KeyCode.RIGHT) {
				boutonMode1.setDefaultButton(false);
				boutonMode2.setDefaultButton(true);
				// boutonMode2.requestFocus();
				// } else if (ev.getCode() == KeyCode.LEFT) {
				// boutonMode1.setDefaultButton(false);
				// boutonMode3.setDefaultButton(true);
				// boutonMode3.requestFocus();
				// }
			}
		});

		boutonMode2.setLayoutX(460);
		boutonMode2.setLayoutY(460);
		boutonMode2.setText("Normal");
		boutonMode2.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				boutonMode1.setVisible(false);
				boutonMode2.setVisible(false);
				boutonMode3.setVisible(false);
				j1.setDifficulte(2);
				j2.setDifficulte(2);
				System.out.println("Start Game");
				clav.requestFocus();
				timeline.play();
			}
		});

		boutonMode2.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER) {
				boutonMode2.fire();
				ev.consume();
			} else if (ev.getCode() == KeyCode.LEFT) {
				boutonMode1.setDefaultButton(true);
				// boutonMode1.requestFocus();
				boutonMode2.setDefaultButton(false);
			} else if (ev.getCode() == KeyCode.RIGHT) {
				boutonMode3.setDefaultButton(true);
				// boutonMode3.requestFocus();
				boutonMode2.setDefaultButton(false);
			}
		});
		boutonMode3.setLayoutX(560);
		boutonMode3.setLayoutY(460);
		boutonMode3.setText("HardCore");
		boutonMode3.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				boutonMode1.setVisible(false);
				boutonMode2.setVisible(false);
				boutonMode3.setVisible(false);
				j1.setDifficulte(4);
				j2.setDifficulte(4);
				System.out.println("Start Game");
				clav.requestFocus();
				timeline.play();
			}
		});

		boutonMode3.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER) {
				boutonMode3.fire();
				ev.consume();
			} else if (ev.getCode() == KeyCode.LEFT) {
				boutonMode3.setDefaultButton(false);
				boutonMode2.setDefaultButton(true);
				// boutonMode2.requestFocus();
				// } else if (ev.getCode() == KeyCode.RIGHT) {
				// boutonMode1.setDefaultButton(true);
				// boutonMode1.requestFocus();
				// boutonMode3.setDefaultButton(false);
				// }
			}
		});

		this.getChildren().add(boutonMode1);
		this.getChildren().add(boutonMode2);
		this.getChildren().add(boutonMode3);

	}

}
