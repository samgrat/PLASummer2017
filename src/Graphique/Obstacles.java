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
		p.setCasePlateau(14, 1, indice_obstacles);
		
		
		this.getChildren().add(obstacle);

	}
	
	/*
	public Obstacles(){
		listeObstacle = new ImageView[16][16];
	}
	
	public void addObstacles(Plateau p){
		int x = (int) (Math.random() * 11);
		int y = (int) (Math.random() * 14);
		int direction = (int) (Math.random() * 2);
		int taille = (int) (1 + Math.random() * 5);
		
		ImageView obstacle = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/obstacle.png")));

		obstacle.setFitHeight(60);
		obstacle.setLayoutX(5 + (x) * 60);
		obstacle.setLayoutY(5 + (y) * 60);
		listeObstacle[x][y] = obstacle;
		if(direction == 0){
			obstacle.setFitWidth(60*taille);
			for (int i = 0; i < taille; i++) {
				p.setCasePlateau(x+i, y, indice_obstacles);
			}
		} else {
			obstacle.setTranslateX(-(taille-1)*30);
			obstacle.setTranslateY((taille-1)*30);
			obstacle.setFitWidth(60*taille);
			obstacle.setRotate(90);
			for (int i = 0; i < taille; i++) {
				p.setCasePlateau(x, y+i, indice_obstacles);
			}
		}
		this.getChildren().add(obstacle);
	}*/
}