package Graphique;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class End extends Parent{
	public End(Group root){
		
<<<<<<< HEAD
=======
		Rectangle fin = new Rectangle();
		fin.setX(350);
		fin.setY(450);
		fin.setWidth(275);
		fin.setHeight(75);;
		fin.setFill(Color.hsb(0, .0, .15));
		
>>>>>>> branch 'Julien' of https://baptiste.betend@gitlab.com/baptiste.betend/PLA.git
		Text GO = new Text("GAME OVER");
		GO.setX(390);
		GO.setY(500);
		GO.setFont(Font.loadFont(getClass().getResourceAsStream("images/Polices/kenpixel_square.ttf"), 30));
		GO.setFill(Color.WHITE);

<<<<<<< HEAD
=======
		// root.getChildren().add(fin);
>>>>>>> branch 'Julien' of https://baptiste.betend@gitlab.com/baptiste.betend/PLA.git
		root.getChildren().add(GO);
		root.requestFocus();
	}
	
}
