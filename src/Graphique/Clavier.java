package Graphique;

import Programme.Joueur;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;

public class Clavier extends Parent {

	public Clavier(Joueur c1, Joueur c2, Pieces p) {

		c1.setTranslateX(900);
		c1.setTranslateY(900);

		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
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
				}
				if (ke.getCode().toString() == "RIGHT" 
						|| ke.getCode().toString() == "LEFT"
						|| ke.getCode().toString() == "UP" 
						|| ke.getCode().toString() == "DOWN") {
					if (p.rechercher((int) c1.getTranslateX() / 60, (int) c1.getTranslateY() / 60) != null) {
						p.ramasser((int) c1.getTranslateX() / 60, (int) c1.getTranslateY() / 60, c1);
						c1.getScore().actuScore();
					}
				} else {
					if (p.rechercher((int) c2.getTranslateX() / 60, (int) c2.getTranslateY() / 60) != null) {
						p.ramasser((int) c2.getTranslateX() / 60, (int) c2.getTranslateY() / 60, c2);
						c2.getScore().actuScore();
					}
				}

			}
		});
	}
}
