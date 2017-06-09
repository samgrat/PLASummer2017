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
		fin.setX(350);
		fin.setY(450);
		fin.setWidth(275);
		fin.setHeight(75);;
		fin.setFill(Color.hsb(0, .0, .15));
		
		Text GO = new Text("GAME OVER");
		GO.setX(390);
		GO.setY(500);
		GO.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		GO.setFill(Color.WHITE);

		// root.getChildren().add(fin);
		root.getChildren().add(GO);
		root.requestFocus();
	}
	
}
