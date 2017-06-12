package Graphique;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Obstacles extends Parent {
	private ImageView[][] listeObstacle;
	final int indice_obstacles = 5;
	
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
				System.out.println("ObstacleH : " + "x " + (x+i) + " y+i " + y + " id_obs " + indice_obstacles);
			}
		} else {
			obstacle.setTranslateX(-(taille-1)*30);
			obstacle.setTranslateY((taille-1)*30);
			obstacle.setFitWidth(60*taille);
			obstacle.setRotate(90);
			for (int i = 0; i < taille; i++) {
				p.setCasePlateau(x, y+i, indice_obstacles);
				System.out.println("ObstacleV : " + "x " + x + " y+i " + (y+i) + "id_obs " + indice_obstacles);
			}
		}
		this.getChildren().add(obstacle);
	}
}