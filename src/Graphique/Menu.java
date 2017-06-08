package Graphique;


import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class Menu extends Parent {
	public Menu(Clavier clav, Timeline timeline){
		Button boutonMode1 = new Button();
		Button boutonMode2 = new Button();
		Button boutonMode3 = new Button();
		boutonMode1.setLayoutX(380);
		boutonMode1.setLayoutY(460);
		boutonMode1.setText("Easy");
		boutonMode1.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				boutonMode1.setVisible(false);
				boutonMode2.setVisible(false);
				boutonMode3.setVisible(false);
				System.out.println("Start Game");
				clav.requestFocus();
				timeline.play();
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
				System.out.println("Start Game");
				clav.requestFocus();
				timeline.play();
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
				System.out.println("Start Game");
				clav.requestFocus();
				timeline.play();
			}
		});

		this.getChildren().add(boutonMode1);
		this.getChildren().add(boutonMode2);
		this.getChildren().add(boutonMode3);
	}
}
