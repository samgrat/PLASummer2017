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
	private CouleurPiece couleur;
	private int indiceCouleur;
	private Timeline timeline;

	public void stopTimeline(){
		this.timeline.stop();
	}
	
	public int getIndiceCouleur(){
		return couleur.getIndice();
	}
	public ImageView getImagePiece() {
		return piece;
	}

	public void setImagePiece(ImageView imagePiece) {
		this.piece = imagePiece;
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
		
		ImageView piecerose = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/piecerose.png")));
		ImageView pieceverte = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/pieceverte.png")));
		ImageView pieceorange = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/pieceorange.png")));
		ImageView pieceviolette = new ImageView(new Image(Main.class.getResourceAsStream("images/Textures/pieceviolette.png")));
		
		idpiece = (int) (Math.random() * 100);
		if ((0 <= idpiece) && (idpiece < 35)) {
			piece = piecerose;
			couleur = CouleurPiece.ROSE;
		}
		
		else if ((35 <= idpiece) && (idpiece < 70)) {
			piece = pieceverte;
			couleur = CouleurPiece.VERT;
		}
		
		else if ((70 <= idpiece) && (idpiece < 90)) {
			piece = pieceorange;
			couleur = CouleurPiece.ORANGE;
		}
		
		else {
			piece = pieceviolette;
			couleur = CouleurPiece.VIOLET;
		}
		this.indiceCouleur = getIndiceCouleur();

		p.setCasePlateau(x, y, indiceCouleur);
		piece.setScaleX(2.0);
		piece.setScaleY(2.0);
		piece.setFitWidth(60);
		piece.setFitHeight(60);
		piece.setTranslateX(6 + x * 60);
		piece.setTranslateY(6 + y * 60);

		root.getChildren().add(piece);
		
		timeline = new Timeline(new KeyFrame(Duration.millis(7000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				delPiece(piece, x, y, p, root);
			}
		}));
		timeline.play();
	}
	
	public void delPiece(ImageView piece, int x, int y, Plateau p, Group root){
		p.setCasePlateau(x, y, 0);
		p.delListePiece(p.rechercherPiece(x, y));

		piece.setVisible(false);

		new Pieces(p, root);
	}

}
