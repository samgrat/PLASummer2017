package Programme;

import javafx.scene.Parent;

public class Personnage extends Parent{
	static protected int TAILLE_CASE;
	
	private int x, y;			
	
	// accesseur absicisse
	public int getX(){ return this.x; }
	public void setX(int x){ this.x = x; }
	
	// accesseur ordonnee
	public int getY(){ return this.y; }
	public void setY(int y){ this.y = y; }

	
//	/**
//	 * Fait avancer la tortue de d pas
//	 * 
//	 * @param d
//	 *            la distance à parcourir
//	 * @require argumentValide : d>=0
//	 * @ensure CapInchange : _cap().equals(cap())
//	 * @ensure DeplacementOk : new Vecteur(_position(),position()).module()-d <
//	 *         Vecteur.EPSILON
//	 * @ensure capOk : new Vecteur(_position(),position()).colineaire(cap())
//	 */
//	public void avancer(int d) {
//		
//		Point positest = new Point(position);
//		Vecteur v = new Vecteur(cap);
//		v.homothetie(d);
//		positest.translation(v);
//
//		position.translation(v);
//	}
//
//	public void changeAbs(int x) {
//		System.out.println("changeAbs");
//		Vecteur v = new Vecteur(position.abscisse(), 0);
//		double normev = Math.sqrt((x - position.abscisse()) * (x - position.abscisse()));
//		v.homothetie(normev);
//		position.translation(v);
//	}
//
//	public void changeOrd(int y) {
//		// position(position.abscisse(),y);
//	}
//
//
//	/**
//	 * Fait reculer la tortue de d pas
//	 * 
//	 * @param d
//	 *            la distance à parcourir
//	 * @require argumentValide : d>=0
//	 * @ensure CapInchange : _cap().equals(cap())
//	 * @ensure DeplacementOk : new Vecteur(_position(),position()).module()-d <
//	 *         Vecteur.EPSILON
//	 * @ensure capOk : new Vecteur(_position(),position()).colineaire(cap())
//	 */
//	
//	public void reculer(int d) {
//		
//		Vecteur v = cap.oppose();
//		v.homothetie(d);
//		position.translation(v);
//	}
//
//	/**
//	 * Fait tourner la à droite d'un angle a
//	 * 
//	 * @param a
//	 *            l'angle de rotation en degré
//	 * @require argumentValide : a>=0
//	 * @ensure PositionInchange : new Vecteur(_position(),position()).module() <
//	 *         Vecteur.EPSILON
//	 */
//	public void droite(int a) {
//		cap.rotation((double) -a);
//	}
//
//	/**
//	 * Fait tourner la tortue à gauche d'un angle a
//	 * 
//	 * @param a
//	 *            l'angle de rotation en degré
//	 * @require argumentValide : a>=0
//	 * @ensure PositionInchange : new Vecteur(_position(),position()).module() <
//	 *         Vecteur.EPSILON
//	 */
//	public void gauche(int a) {
//		cap.rotation((double) a);
//	}
//	
//
//	/**
//	 * Restitue la représentation textuelle de la tortue
//	 * 
//	 * @return la chaine
//	 */
//	public String toString() {
//		return "Robot[" + position + "," + cap + "]";
//	}
}
