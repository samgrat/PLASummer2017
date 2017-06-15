package Graphique;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Obstacles extends Parent {

	final int indice_obstacles = 5;
	
	public Obstacles(Plateau p){
		
		ImageView obstacle = new ImageView(new Image(Main.class.getResourceAsStream("")));
		obstacle.setFitHeight(60);
		obstacle.setFitWidth(60);
		
		/* "map1.png" : obstacles repartis sur la carte 
		
		// case(1, 14)
		p.setCasePlateau(1, 14, indice_obstacles);
		// case(2, 14)
		p.setCasePlateau(2, 14, indice_obstacles);
		// case(3, 14)
		p.setCasePlateau(3, 14, indice_obstacles);
		// case(3, 13)
		p.setCasePlateau(3, 13, indice_obstacles);
		// case(8, 13)
		p.setCasePlateau(8, 13, indice_obstacles);
		// case(9, 13)
		p.setCasePlateau(9, 13, indice_obstacles);
		// case(5, 10)
		p.setCasePlateau(5, 10, indice_obstacles);
		// case(5, 9)
		p.setCasePlateau(5, 9, indice_obstacles);
		// case(10, 8)
		p.setCasePlateau(10, 8, indice_obstacles);
		// case(11, 8)
		p.setCasePlateau(11, 8, indice_obstacles);
		// case(12, 8)
		p.setCasePlateau(12, 8, indice_obstacles);
		// case(13, 8)
		p.setCasePlateau(13, 8, indice_obstacles);
		// case(10, 7)
		p.setCasePlateau(10, 7, indice_obstacles);
		// case(2, 5)
		p.setCasePlateau(2, 5, indice_obstacles);
		// case(3, 5)
		p.setCasePlateau(3, 5, indice_obstacles);
		// case(4, 5)
		p.setCasePlateau(4, 5, indice_obstacles);
		// case(10, 5)
		p.setCasePlateau(10, 5, indice_obstacles);
		// case(10, 4)
		p.setCasePlateau(10, 4, indice_obstacles);
		// case(10, 3)
		p.setCasePlateau(10, 3, indice_obstacles);
		// case(9, 3)
		p.setCasePlateau(9, 3, indice_obstacles);
		// case(13, 1)
		p.setCasePlateau(13, 1, indice_obstacles);
		// case(14, 1)
		p.setCasePlateau(14, 1, indice_obstacles); */
		
		/* "map2.png" : ricm 
		
		// case(1, 6)
		p.setCasePlateau(1, 6, indice_obstacles);
		// case(1, 7)
		p.setCasePlateau(1, 7, indice_obstacles);
		// case(1, 8)
		p.setCasePlateau(1, 8, indice_obstacles);
		// case(1, 9)
		p.setCasePlateau(1, 9, indice_obstacles);
		// case(2, 6)
		p.setCasePlateau(2, 6, indice_obstacles);
		// case(3, 6)
		p.setCasePlateau(3, 6, indice_obstacles);
		// case(5, 6)
		p.setCasePlateau(5, 6, indice_obstacles);
		// case(5, 7)
		p.setCasePlateau(5, 7, indice_obstacles);
		// case(5, 8)
		p.setCasePlateau(5, 8, indice_obstacles);
		// case(5, 9)
		p.setCasePlateau(5, 9, indice_obstacles);
		// case(7, 6)
		p.setCasePlateau(7, 6, indice_obstacles);
		// case(7, 7)
		p.setCasePlateau(7, 7, indice_obstacles);
		// case(7, 8)
		p.setCasePlateau(7, 8, indice_obstacles);
		// case(7, 9)
		p.setCasePlateau(7, 9, indice_obstacles);
		// case(8, 6)
		p.setCasePlateau(8, 6, indice_obstacles);
		// case(8, 9)
		p.setCasePlateau(8, 9, indice_obstacles);
		// case(10, 6)
		p.setCasePlateau(10, 6, indice_obstacles);
		// case(10, 7)
		p.setCasePlateau(10, 7, indice_obstacles);
		// case(10, 8)
		p.setCasePlateau(10, 8, indice_obstacles);
		// case(10, 9)
		p.setCasePlateau(10, 9, indice_obstacles);
		// case(11, 6)
		p.setCasePlateau(11, 6, indice_obstacles);
		// case(12, 6)
		p.setCasePlateau(12, 6, indice_obstacles);
		// case(12, 7)
		p.setCasePlateau(12, 7, indice_obstacles);
		// case(12, 8)
		p.setCasePlateau(12, 8, indice_obstacles);
		// case(12, 9)
		p.setCasePlateau(12, 9, indice_obstacles);
		// case(13, 6)
		p.setCasePlateau(13, 6, indice_obstacles);
		// case(14, 6)
		p.setCasePlateau(14, 6, indice_obstacles);
		// case(14, 7)
		p.setCasePlateau(14, 7, indice_obstacles);
		// case(14, 8)
		p.setCasePlateau(14, 8, indice_obstacles);
		// case(14, 9)
		p.setCasePlateau(14, 9, indice_obstacles);
		
		this.getChildren().add(obstacle); */
		
		
		// "map3.png" : pacman 
		
		// case(1, 1)
		p.setCasePlateau(1, 1, indice_obstacles);
		// case(1, 2)
		p.setCasePlateau(1, 2, indice_obstacles);
		// case(1, 4)
		p.setCasePlateau(1, 4, indice_obstacles);
		// case(1, 6)
		p.setCasePlateau(1, 6, indice_obstacles);
		// case(1, 7)
		p.setCasePlateau(1, 7, indice_obstacles);
		// case(1, 9)
		p.setCasePlateau(1, 9, indice_obstacles);
		// case(1, 10)
		p.setCasePlateau(1, 10, indice_obstacles);
		// case(1, 12)
		p.setCasePlateau(1, 12, indice_obstacles);
		// case(1, 13)
		p.setCasePlateau(1, 13, indice_obstacles);
		// case(1, 14)
		p.setCasePlateau(1, 14, indice_obstacles);
		
		// case(2, 1)
		p.setCasePlateau(2, 1, indice_obstacles);
		// case(2, 2)
		p.setCasePlateau(2, 2, indice_obstacles);
		// case(2, 4)
		p.setCasePlateau(2, 4, indice_obstacles);
		// case(2, 6)
		p.setCasePlateau(2, 6, indice_obstacles);
		// case(2, 7)
		p.setCasePlateau(2, 7, indice_obstacles);
		// case(2, 10)
		p.setCasePlateau(2, 10, indice_obstacles);
		// case(2, 12)
		p.setCasePlateau(2, 12, indice_obstacles);
		// case(2, 13)
		p.setCasePlateau(2, 13, indice_obstacles);
		// case(2, 14)
		p.setCasePlateau(2, 14, indice_obstacles);
		
		// case(3, 1)
		p.setCasePlateau(3, 1, indice_obstacles);
		// case(3, 2)
		p.setCasePlateau(3, 2, indice_obstacles);
		// case(3, 4)
		p.setCasePlateau(3, 4, indice_obstacles);
		// case(3, 6)
		p.setCasePlateau(3, 6, indice_obstacles);
		// case(3, 7)
		p.setCasePlateau(3, 7, indice_obstacles);
		// case(3, 9)
		p.setCasePlateau(3, 9, indice_obstacles);
		// case(3, 10)
		p.setCasePlateau(3, 10, indice_obstacles);
		// case(3, 12)
		p.setCasePlateau(3, 12, indice_obstacles);
		// case(3, 13)
		p.setCasePlateau(3, 13, indice_obstacles);
		// case(3, 14)
		p.setCasePlateau(3, 14, indice_obstacles);
		
		// case(5, 1)
		p.setCasePlateau(5, 1, indice_obstacles);
		// case(5, 2)
		p.setCasePlateau(5, 2, indice_obstacles);
		// case(5, 4)
		p.setCasePlateau(5, 4, indice_obstacles);
		// case(5, 5)
		p.setCasePlateau(5, 5, indice_obstacles);
		// case(5, 6)
		p.setCasePlateau(5, 6, indice_obstacles);
		// case(5, 7)
		p.setCasePlateau(5, 7, indice_obstacles);
		// case(5, 9)
		p.setCasePlateau(5, 9, indice_obstacles);
		// case(5, 10)
		p.setCasePlateau(5, 10, indice_obstacles);
		// case(5, 12)
		p.setCasePlateau(5, 12, indice_obstacles);
		// case(5, 13)
		p.setCasePlateau(5, 13, indice_obstacles);
		// case(5, 14)
		p.setCasePlateau(5, 14, indice_obstacles);
		
		// case(6, 1)
		p.setCasePlateau(6, 1, indice_obstacles);
		// case(6, 2)
		p.setCasePlateau(6, 2, indice_obstacles);
		// case(6, 6)
		p.setCasePlateau(6, 6, indice_obstacles);
		// case(6, 10)
		p.setCasePlateau(6, 10, indice_obstacles);
		// case(6, 12)
		p.setCasePlateau(6, 12, indice_obstacles);
		
		// case(7, 1)
		p.setCasePlateau(7, 1, indice_obstacles);
		// case(7, 2)
		p.setCasePlateau(7, 2, indice_obstacles);
		// case(7, 4)
		p.setCasePlateau(7, 4, indice_obstacles);
		// case(7, 6)
		p.setCasePlateau(7, 6, indice_obstacles);
		// case(7, 8)
		p.setCasePlateau(7, 8, indice_obstacles);
		// case(7, 10)
		p.setCasePlateau(7, 10, indice_obstacles);
		// case(7, 12)
		p.setCasePlateau(7, 12, indice_obstacles);
		// case(7, 14)
		p.setCasePlateau(7, 14, indice_obstacles);
		
		// case(8, 1)
		p.setCasePlateau(8, 1, indice_obstacles);
		// case(8, 2)
		p.setCasePlateau(8, 2, indice_obstacles);
		// case(8, 4)
		p.setCasePlateau(8, 4, indice_obstacles);
		// case(8, 6)
		p.setCasePlateau(8, 6, indice_obstacles);
		// case(8, 8)
		p.setCasePlateau(8, 8, indice_obstacles);
		// case(8, 10)
		p.setCasePlateau(8, 10, indice_obstacles);
		// case(8, 12)
		p.setCasePlateau(8, 12, indice_obstacles);
		// case(8, 14)
		p.setCasePlateau(8, 14, indice_obstacles);
		
		// case(9, 4)
		p.setCasePlateau(9, 4, indice_obstacles);
		// case(9, 8)
		p.setCasePlateau(9, 8, indice_obstacles);
		
		// case(10, 1)
		p.setCasePlateau(10, 1, indice_obstacles);
		// case(10, 2)
		p.setCasePlateau(10, 2, indice_obstacles);
		// case(10, 4)
		p.setCasePlateau(10, 4, indice_obstacles);
		// case(10, 5)
		p.setCasePlateau(10, 5, indice_obstacles);
		// case(10, 6)
		p.setCasePlateau(10, 6, indice_obstacles);
		// case(10, 8)
		p.setCasePlateau(10, 8, indice_obstacles);
		// case(10, 10)
		p.setCasePlateau(10, 10, indice_obstacles);
		// case(10, 11)
		p.setCasePlateau(10, 11, indice_obstacles);
		// case(10, 12)
		p.setCasePlateau(10, 12, indice_obstacles);
		// case(10, 13)
		p.setCasePlateau(10, 13, indice_obstacles);
		// case(10, 14)
		p.setCasePlateau(10, 14, indice_obstacles);
		
		// case(11, 4)
		p.setCasePlateau(11, 4, indice_obstacles);
		// case(11, 11)
		p.setCasePlateau(11, 11, indice_obstacles);

		// case(12, 1)
		p.setCasePlateau(12, 1, indice_obstacles);
		// case(12, 2)
		p.setCasePlateau(12, 2, indice_obstacles);
		// case(12, 6)
		p.setCasePlateau(12, 6, indice_obstacles);
		// case(12, 7)
		p.setCasePlateau(12, 7, indice_obstacles);
		// case(12, 9)
		p.setCasePlateau(12, 9, indice_obstacles);
		// case(12, 13)
		p.setCasePlateau(12, 13, indice_obstacles);
		// case(12, 14)
		p.setCasePlateau(12, 14, indice_obstacles);
		
		// case(13, 1)
		p.setCasePlateau(13, 1, indice_obstacles);
		// case(13, 2)
		p.setCasePlateau(13, 2, indice_obstacles);
		// case(13, 4)
		p.setCasePlateau(13, 4, indice_obstacles);
		// case(13, 6)
		p.setCasePlateau(13, 6, indice_obstacles);
		// case(13, 7)
		p.setCasePlateau(13, 7, indice_obstacles);
		// case(13, 9)
		p.setCasePlateau(13, 9, indice_obstacles);
		// case(13, 11)
		p.setCasePlateau(13, 11, indice_obstacles);
		// case(13, 13)
		p.setCasePlateau(13, 13, indice_obstacles);
		// case(13, 14)
		p.setCasePlateau(13, 14, indice_obstacles);
		
		// case(14, 1)
		p.setCasePlateau(14, 1, indice_obstacles);
		// case(14, 2)
		p.setCasePlateau(14, 2, indice_obstacles);
		// case(14, 4)
		p.setCasePlateau(14, 4, indice_obstacles);
		// case(14, 6)
		p.setCasePlateau(14, 6, indice_obstacles);
		// case(14, 7)
		p.setCasePlateau(14, 7, indice_obstacles);
		// case(14, 9)
		p.setCasePlateau(14, 9, indice_obstacles);
		// case(14, 11)
		p.setCasePlateau(14, 11, indice_obstacles);
		// case(14, 13)
		p.setCasePlateau(14, 13, indice_obstacles);
		// case(14, 14)
		p.setCasePlateau(14, 14, indice_obstacles); 	
		
		
		this.getChildren().add(obstacle);

	}
}