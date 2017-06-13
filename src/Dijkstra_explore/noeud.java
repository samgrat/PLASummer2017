package Dijkstra_explore;


public class noeud {
	private int etiquette;
	private int distance;
	private int predecesseur;

public noeud(){
	distance = 0;
}

public noeud(int e, int d, int p){
	etiquette = e;
	distance = d;
	predecesseur = p;
}

public noeud(noeud noeud) {
	etiquette = noeud.getEtiquette();
	distance = noeud.getDistance();
	predecesseur = noeud.getPred();
}

/**
 * Accesseur
 * @return l etiquette du noeud
 */
public int getEtiquette(){
	return etiquette;
}

/**
 * Accesseur
 * @return la distance au sommet du noeud
 */
public int getDistance(){
	return distance;
}

/**
 * Accesseur
 * @return le predecesseur du noeud dans le chemin
 */
public int getPred(){
	return predecesseur;
}

public void setDistance(int d){
	distance = d;
}

public void setPred(int n){
	predecesseur = n;
}

public void setall(int e, int d, int n){
	etiquette = e;
	distance = d;
	predecesseur = n;
}

public String toString(){
	return("noeud "+etiquette+" d= "+distance);
}

}
