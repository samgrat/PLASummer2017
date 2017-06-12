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
		
		ImageView obstacle = new ImageView(new Image(Main.class.getResourceAsStream("")));
		obstacle.setFitHeight(60);
		obstacle.setFitWidth(60);
		
		// case(1, 14)
		p.setCasePlateau(1, 14, indice_obstacles);
		listeObstacle[1][14] = obstacle;
		// case(2, 14)
		p.setCasePlateau(2, 14, indice_obstacles);
		listeObstacle[2][14] = obstacle;
		// case(3, 14)
		p.setCasePlateau(3, 14, indice_obstacles);
		listeObstacle[3][14] = obstacle;
		// case(3, 13)
		p.setCasePlateau(3, 13, indice_obstacles);
		listeObstacle[3][13] = obstacle;
		// case(8, 13)
		p.setCasePlateau(8, 13, indice_obstacles);
		listeObstacle[8][13] = obstacle;
		// case(9, 13)
		p.setCasePlateau(9, 13, indice_obstacles);
		listeObstacle[9][13] = obstacle;
		// case(5, 10)
		p.setCasePlateau(5, 10, indice_obstacles);
		listeObstacle[5][10] = obstacle;
		// case(5, 9)
		p.setCasePlateau(5, 9, indice_obstacles);
		listeObstacle[5][9] = obstacle;
		// case(10, 8)
		p.setCasePlateau(10, 8, indice_obstacles);
		listeObstacle[10][8] = obstacle;
		// case(11, 8)
		p.setCasePlateau(11, 8, indice_obstacles);
		listeObstacle[11][8] = obstacle;
		// case(12, 8)
		p.setCasePlateau(12, 8, indice_obstacles);
		listeObstacle[12][8] = obstacle;
		// case(13, 8)
		p.setCasePlateau(13, 8, indice_obstacles);
		listeObstacle[13][8] = obstacle;
		// case(10, 7)
		p.setCasePlateau(10, 7, indice_obstacles);
		listeObstacle[10][7] = obstacle;
		// case(2, 5)
		p.setCasePlateau(2, 5, indice_obstacles);
		listeObstacle[2][15] = obstacle;
		// case(3, 5)
		p.setCasePlateau(3, 5, indice_obstacles);
		listeObstacle[3][5] = obstacle;
		// case(4, 5)
		p.setCasePlateau(4, 5, indice_obstacles);
		listeObstacle[4][5] = obstacle;
		// case(10, 5)
		p.setCasePlateau(10, 5, indice_obstacles);
		listeObstacle[10][5] = obstacle;
		// case(10, 4)
		p.setCasePlateau(10, 4, indice_obstacles);
		listeObstacle[10][4] = obstacle;
		// case(10, 3)
		p.setCasePlateau(10, 3, indice_obstacles);
		listeObstacle[10][3] = obstacle;
		// case(9, 3)
		p.setCasePlateau(9, 3, indice_obstacles);
		listeObstacle[9][3] = obstacle;
		// case(13, 1)
		p.setCasePlateau(13, 1, indice_obstacles);
		listeObstacle[13][1] = obstacle;
		// case(14, 1)
		p.setCasePlateau(14, 1, indice_obstacles);
		listeObstacle[14][1] = obstacle;
		
		
		this.getChildren().add(obstacle);
		
		
/*	
		ImageView obstacle = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/obstacle.png")));
		listeObstacle[x][y] = obstacle;
		obstacle.setFitWidth(60);
		obstacle.setFitHeight(60);
		obstacle.setTranslateX(5 + x * 60);
		obstacle.setTranslateY(5 + y * 60);
		obstacle.setVisible(true);
		listeObstacle[x][y] = obstacle;

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
	*/
		
	}
}