package Graphique;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plateau extends Parent {
	Integer[][] casePlateau;
	Integer[][] murPlateau;
	
	
	public Integer getCasePlateau(int x, int y) { return casePlateau[x][y]; }
	public void setCasePlateau(int value, int x, int y) { this.casePlateau[x][y] = value; }

	public Integer getMurPlateau(int x, int y) { return murPlateau[x][y];	}
	public void setMurPlateau(int value, int x, int y) {	this.murPlateau[x][y] = value; }


	public Plateau(){
		
		casePlateau = new Integer[16][16];
		murPlateau = new Integer[17][17];


		ImageView bck = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/interface.png")));

		this.getChildren().add(bck);
		System.out.println("1");
		int j = 0;
		for (int i = 0; i < 16; i++) {
			Rectangle rectangle = new Rectangle();
			rectangle.setX(5 + j * 60);
			rectangle.setY(5 + i * 60);
			rectangle.setWidth(60);
			rectangle.setHeight(60);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setStroke(Color.TRANSPARENT);
			rectangle.setStrokeWidth(1);
			this.getChildren().add(rectangle);
			if (i == 15) {
				i = -1;
				j++;
			}
			if (j == 16) {
				i = 15;
			}
		}
	}
}
