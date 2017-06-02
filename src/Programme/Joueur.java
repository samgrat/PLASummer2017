package Programme;

import Graphique.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Joueur extends Personnage {
	private Score s;
	private Plateau p;
	private int indice_joueur;
	private int niveau_recolte;
	private int niveau_attaque;
	private int nbr_boulon;
	private int nbr_planche;
	private int nbr_vis;
	private int nbr_piece;
	
	public Score getScore(){ return this.s; }
	public void setScore(Score s){ this.s = s; }
	//accesseur indice_joueur
	public int Indice_joueur(){ return indice_joueur; }
	
	// accesseur niveau_recolte
	public int Niveau_recolte(){ return niveau_recolte; }
	
	//accesseur niveau_attaque
	public int Niveau_attaque(){ return niveau_attaque; }
	
	// accesseur nbr_boulon
	public int Nbr_boulon(){ return nbr_boulon; }
	
	// accesseur nbr_planche
	public int Nbr_planche(){ return nbr_planche; }
	
	//accesseur niveau_attaque
	public int Nbr_vis(){ return nbr_vis; }
	
	//accesseur nbr_piece
	public int Nbr_piece(){ return nbr_piece; }
	public void incrPiece(){ nbr_piece++; System.out.println(this.nbr_piece);}
	
	/**
	 * creation d'un joueur
	 * @param indice 1 si joueur 1 ou 2 si joueur 2
	 */
	public Joueur(int indice_joueur, Plateau p){
		niveau_recolte = 0;
		niveau_attaque = 0;
		nbr_boulon = 0;
		nbr_planche = 0;
		nbr_vis = 0;
		this.indice_joueur = indice_joueur;
		this.p = p;
		if (indice_joueur == 1){
			//position.positionnerCartesien(0, 0);
			creeJoueur("images/Textures/personnagebleu.png", 0);
		}
		if(indice_joueur == 2) {
			//position.positionnerCartesien(15*TAILLE_CASE, 15*TAILLE_CASE);
			creeJoueur("images/Textures/personnagerouge.png", 900);			
		}		
	}
	public void creeJoueur(String file, int pos){
		ImageView joueur = new ImageView(new Image(Main.class.getResourceAsStream(file)));
		joueur.setFitWidth(60);
		joueur.setFitHeight(60);
		joueur.setLayoutX(5);
		joueur.setLayoutY(5);
		this.getChildren().add(joueur);
	}
	
	public void droite(){
		if (this.getTranslateX() + 60 > 959) {
			this.setTranslateX(0);
		} else {
			this.setTranslateX(this.getTranslateX() + 60);
		}
		
	}
	
	public void gauche(){
		if (this.getTranslateX() - 60 < 0) {
			this.setTranslateX(900);
		} else {
			this.setTranslateX(this.getTranslateX() - 60);
		}
	}
	
	public void monter(){
		if (this.getTranslateY() - 60 < 0) {
			this.setTranslateY(900);
		} else {
			this.setTranslateY(this.getTranslateY() - 60);
		}
	}
	
	public void descendre(){
		if (this.getTranslateY() + 60 > 959) {
			this.setTranslateY(0);
		} else {
			this.setTranslateY(this.getTranslateY() + 60);
		}
	}
	/**
	 * creation d'un robot recolte 
	 * @return 
	 * 
	 */
	public void RobotRecolte(){
		
	}
	
	/**
	 * creation d'un robot attaque
	 * 
	 */
	public void RobotAttaque(){
		
	}
	
	/**
	 * Level up robot recolte
	 *
	 */
	public void LevelUpRR(){
		
	}
	
	/**
	 * Level up robot attaque
	 *
	 */
	public void LevelUpRA(){
		
	}
}
