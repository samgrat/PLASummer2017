package Graphique;

import Programme.Joueur;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Clavier extends Parent {

	public Clavier(Joueur c1, Joueur c2, Plateau p, Group root) {

		c1.setTranslateX(900);
		c1.setTranslateY(900);

		p.setCasePlateau(0, 0, 1);
		p.setCasePlateau(15, 15, 2);

		this.setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent ke) {
				if (ke.getCode().toString() == "RIGHT" || ke.getCode().toString() == "LEFT"
						|| ke.getCode().toString() == "UP" || ke.getCode().toString() == "DOWN"
						|| ke.getCode().toString() == "DIGIT9" || ke.getCode().toString() == "DIGIT0"
						|| ke.getCode().toString() == "RIGHT_PARENTHESIS" || ke.getCode().toString() == "EQUALS") {

					switch (ke.getCode().toString()) {
					case "RIGHT":
						c1.droite();
						break;
					case "LEFT":
						c1.gauche();
						break;
					case "UP":
						c1.monter();
						break;
					case "DOWN":
						c1.descendre();
						break;
					case "DIGIT9":
						c1.invoquerRobot1(root);
						break;
					case "DIGIT0":
						c1.invoquerRobot2(root);
						break;
					case "RIGHT_PARENTHESIS":
						c1.invoquerRobot3(root);
						break;
					case "EQUALS":
						c1.invoquerRobot4(root);
						break;
					}

				} else {

					switch (ke.getCode().toString()) {
					case "D":
						c2.droite();
						break;
					case "Q":
						c2.gauche();
						break;
					case "Z":
						c2.monter();
						break;
					case "S":
						c2.descendre();
						break;
					case "DIGIT1":
						c2.invoquerRobot1(root);
						break;
					case "DIGIT2":
						c2.invoquerRobot2(root);
						break;
					case "DIGIT3":
						c2.invoquerRobot3(root);
						break;
					case "DIGIT4":
						c2.invoquerRobot4(root);
						break;
					}

				}

			}
		});
	}
}
