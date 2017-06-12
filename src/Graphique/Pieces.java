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
	private ImageView piece;
	final int indice_piece = 11;
	private Timeline timeline;

	public void stopTimeline(){
		this.timeline.stop();
	}
	
	public ImageView getImagePiece() {
		return piece;
	}

	public void setImagePiece(ImageView imagePiece) {
		this.piece = imagePiece;
	}

	public int getIndice_piece() {
		return indice_piece;
	}

	public Pieces(Plateau p, Group root) {
		


		
		int idpiece;
		
		
		
		p.setListePiece(this);
		p.incrCompteurPiece();
		int abs, ord;
		do {
			abs = (int) (Math.random() * 15);
			ord = (int) (Math.random() * 15);
			
		} while (p.rechercher(abs, ord) != 0);
		setX(abs);
		setY(ord);
		
		ImageView pieceorange = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/pieceorange.png")));
		ImageView piecerose = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/piecerose.png")));
		ImageView pieceverte = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/pieceverte.png")));
		ImageView pieceviolette = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/pieceviolette.png")));
		
		idpiece = (int) (Math.random() * 100);
		if ((0 <= idpiece) && (idpiece < 25)) {
			piece = pieceviolette;
		}
		
		else if ((25 <= idpiece) && (idpiece < 50)) {
			piece = pieceverte;
		}
		
		else if ((50 <= idpiece) && (idpiece < 60)) {
			piece = piecerose;
		}
		
		else {
			piece = pieceorange;
		}
		
		piece.setScaleX(2.0);
		piece.setScaleY(2.0);
		piece.setFitWidth(60);
		piece.setFitHeight(60);
		piece.setTranslateX(6 + x * 60);
		piece.setTranslateY(6 + y * 60);
		root.getChildren().add(piece);
		p.setCasePlateau(x, y, indice_piece);
		
		
		timeline = new Timeline(new KeyFrame(Duration.millis(7000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				delPiece(piece, x, y, p, root);
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
