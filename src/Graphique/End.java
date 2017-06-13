package Graphique;

import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;

public class End extends Parent{
	
	public End(Group root){

		Rectangle r = new Rectangle();
		r.setHeight(965);
		r.setWidth(965);
		r.setLayoutX(5);
		r.setLayoutY(5);
		r.setFill(Color.BLACK);
		r.setOpacity(.75);
		
		Text GO = new Text("GAME OVER");
		GO.setX(390);
		GO.setY(500);
		GO.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		GO.setFontSmoothingType(FontSmoothingType.LCD);
		GO.setFill(Color.WHITE);

		root.getChildren().addAll(r, GO);
		root.requestFocus();
		}
	}
