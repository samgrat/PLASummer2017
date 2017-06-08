package Graphique;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class End extends Parent{
	public End(Group root){
		Rectangle fin = new Rectangle();
		fin.setX(300);
		fin.setY(400);
		fin.setWidth(500);
		fin.setHeight(200);
		fin.setArcHeight(500);
		fin.setArcWidth(50);
		Text GO = new Text("GAME OVER");
		GO.setX(450);
		GO.setY(450);
		GO.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		GO.setFill(Color.WHITE);

		root.getChildren().add(fin);
		root.getChildren().add(GO);
		root.requestFocus();
	}
	
}
