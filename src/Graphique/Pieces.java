package Graphique;

import Programme.Personnage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Pieces extends Personnage {
	private ImageView imagePiece;
	final int indice_piece = 11;
	private Timeline timeline;

	public void stopTimeline(){
		this.timeline.stop();
	}
	
	public ImageView getImagePiece() {
		return imagePiece;
	}

	public void setImagePiece(ImageView imagePiece) {
		this.imagePiece = imagePiece;
	}

	public int getIndice_piece() {
		return indice_piece;
	}

	public Pieces(Plateau p, Group root) {
		p.setListePiece(this);
		p.incrCompteurPiece();
		int abs, ord;
		do {
			abs = (int) (Math.random() * 15);
			ord = (int) (Math.random() * 15);
			
		} while (p.rechercher(abs, ord) != 0);
		setX(abs);
		setY(ord);
		imagePiece = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/piece.png")));
		imagePiece.setFitWidth(60);
		imagePiece.setFitHeight(60);
		imagePiece.setTranslateX(5 + x * 60);
		imagePiece.setTranslateY(5 + y * 60);
		root.getChildren().add(imagePiece);
		p.setCasePlateau(x, y, indice_piece); System.out.println("p = " + p.getCasePlateau(x, y));
		
		timeline = new Timeline(new KeyFrame(Duration.millis(7000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				delPiece(imagePiece, x, y, p, root);
			}
		}));
		timeline.play();
	}
	
	public void delPiece(ImageView piece, int x, int y, Plateau p, Group root){
		piece.setVisible(false);
		p.setCasePlateau(x, y, 0);
		new Pieces(p, root);
	}

}
