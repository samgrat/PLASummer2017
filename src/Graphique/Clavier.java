package Graphique;

import Programme.Joueur;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;

public class Clavier extends Parent {

	public Clavier(Joueur c1, Joueur c2, Plateau p) {


		c1.setTranslateX(900);
		c1.setTranslateY(900);
		
		p.setCasePlateau(0, 0, 1);
		p.setCasePlateau(15, 15, 2);

		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				if (ke.getCode().toString() == "RIGHT" || ke.getCode().toString() == "LEFT"
						|| ke.getCode().toString() == "UP" || ke.getCode().toString() == "DOWN") {
					
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
						}
					
				}

			}
		});
}}
