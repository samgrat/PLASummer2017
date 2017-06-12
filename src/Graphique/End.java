package Graphique;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class End extends Parent{
	public End(Group root){
		Text GO = new Text("GAME OVER");
		GO.setX(350);
		GO.setY(450);
		GO.setFill(Color.hsb(0, .0, .15));
		GO.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		root.getChildren().add(GO);
		root.requestFocus();
	}
}
