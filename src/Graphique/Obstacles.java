package Graphique;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Obstacles extends Parent {
	private ImageView[][] listeObstacle;
	final int indice_obstacles = 3;
	
	public Obstacles(){
		listeObstacle = new ImageView[16][16];
	}
	
	public void addObstacles(Plateau p){
		int x = (int) (2+Math.random() * 13);
		int y = (int) (2+Math.random() * 13);
		int direction = (int) (Math.random() * 2);
		int taille = (int) (1 + Math.random() * 5);
		
		ImageView obstacle = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/obstacle.png")));
		listeObstacle[x][y] = obstacle;
		obstacle.setFitWidth(60);
		obstacle.setFitHeight(60);
		obstacle.setTranslateX(5 + x * 60);
		obstacle.setTranslateY(5 + y * 60);
		obstacle.setVisible(true);
		listeObstacle[x][y] = obstacle;

		System.out.println(direction);
		if(direction == 0){
			obstacle.setFitWidth(60*taille);
			for (int i = 0; i < taille; i++) {
				p.setCasePlateau(x+i, y, indice_obstacles);
			}
		} else {
			obstacle.setTranslateX(5 + (x-1) * 60);
			obstacle.setTranslateY(5 + (y+1) * 60);
			obstacle.setFitWidth(180);
			obstacle.setRotate(90);
			p.setCasePlateau(x, y, indice_obstacles);
			p.setCasePlateau(x, y+1, indice_obstacles);
			p.setCasePlateau(x, y+2, indice_obstacles);
		}
		this.getChildren().add(obstacle);
	}
}