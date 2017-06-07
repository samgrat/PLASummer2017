package Graphique;

import Programme.Joueur;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plateau extends Parent {
	private Integer[][] casePlateau;
	private Pieces listePiece;
	private Obstacles listeObstacle;
	
	public Integer getCasePlateau(int x, int y) { return casePlateau[x][y]; }
	public void setCasePlateau(int x, int y, int value) { if(x<16 && x>=0 && y<16 && y>=0){this.casePlateau[x][y] = value; }}
	
	public Pieces getListePiece() { return listePiece; }
	public void setListePiece(Pieces listePiece) { this.listePiece = listePiece; }
	
	public Plateau(Pieces p, Obstacles o){
		
		casePlateau = new Integer[16][16];
		for (int i = 0; i < casePlateau.length; i++) {
			for (int j = 0; j < casePlateau.length; j++) {
				casePlateau[i][j] = 0;
			}
		}
		this.listePiece = p;
		this.listeObstacle = o;

		ImageView bck = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/interface.png")));

		this.getChildren().add(bck);
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
		
		listePiece.addPieces(this);
		listePiece.addPieces(this);
		listeObstacle.addObstacles(this);
		listeObstacle.addObstacles(this);
		listeObstacle.addObstacles(this);
		listeObstacle.addObstacles(this);
		listeObstacle.addObstacles(this);
		listeObstacle.addObstacles(this);
		listeObstacle.addObstacles(this);
		listeObstacle.addObstacles(this);
	}
	
	public void ramasser(int x, int y, Joueur j, int indice) {
		switch (indice) {
		case 3: 
		case 11:
			listePiece.getPiece(x, y).setVisible(false);
			listePiece.setPiece(x, y, null);
			casePlateau[x][y] = 0;
			j.incrPiece();
			listePiece.addPieces(this);
			break;
		case 12:
			
		default:
			break;
		}
		
	}
	
	public int rechercher(int x, int y) { return casePlateau[x][y]; }
}
