package Dijkstra_explore;

import Graphique.Plateau;

//http://codes-sources.commentcamarche.net/source/view/54685/1296628#browser
// Representation matricielle d un graphe

public class Graphe {

	public int NCases = 16 * 16;
	int arcs[][]; // arcs[i][j] = 0 <=> pas d'arc de i vers j
	noeud list_noeuds[]; // tableau des noeuds du graphe
	final static int INFINI = 999999;

	/**
	 * Constructeur d un graphe [16*16][16*16] sans liaisons
	 */
	public Graphe() {
		list_noeuds = new noeud[NCases];
		arcs = new int[NCases][NCases];
		int etiquette = 0; // etiquette du noeud dans arcs[][]

		for (int i = 0; i < NCases; i++) {
			for (int j = 0; j < NCases; j++) {
				list_noeuds[etiquette].setall(etiquette, INFINI, -1);
				arcs[i][j] = 0;

				etiquette++;
			}
		}
	}

	/**
	 * Constructeur via notre matrice dans Plateau
	 * 
	 * @param p
	 */
	public Graphe(Plateau p) {
		list_noeuds = new noeud[NCases];
		arcs = new int[NCases][NCases];
		int etiquette = 0; // etiquette du noeud dans arcs[][]

		for (int j = 0; j < 16; j++) {
			for (int i = 0; i < 16; i++) { // on parcours p
				list_noeuds[etiquette] = new noeud(etiquette, INFINI, -1);

				/* Creation des arcs */

				lookAround(p, i, j, etiquette, "haut");
				lookAround(p, i, j, etiquette, "bas");
				lookAround(p, i, j, etiquette, "droite");
				lookAround(p, i, j, etiquette, "gauche");

				etiquette++;
			}
		}
	}

	/**
	 * regarde et construit les noeuds dans arcs[][] autour de p[i][j]
	 * 
	 * @param p
	 *            : le plateau de jeu
	 * @param i
	 *            : abscisse courante
	 * @param j
	 *            : ordonnee courante
	 * @param etiquette
	 *            : indice du noeud dans arcs
	 * @param direction
	 *            : haut, bas, droite ou gauche
	 */
	private void lookAround(Plateau p, int i, int j, int etiquette, String direction) {
		int indice = 0;
		int var_dir_x = 0;
		int var_dir_y = 0;
		int x_in_p = 0, y_in_p = 0;
		int x_in_arcs = etiquette, y_in_arcs = -1;

		switch (direction) {
		case "haut":
			var_dir_y = -1;
			break;
		case "bas":
			var_dir_y = 1;
			break;
		case "gauche":
			var_dir_x = -1;
			break;
		case "droite":
			var_dir_x = 1;
			break;
		default:
			System.out.println("Erreur: mauvaise direction.");
			System.exit(-1);
		}

		// si il y a une case sur le plateau dans la direction voulue
		if (0 <= i + var_dir_x && i + var_dir_x < 16 && 0 <= j + var_dir_y && j + var_dir_y < 16) {
			x_in_p = i + var_dir_x;
			y_in_p = j + var_dir_y;

			// on affecte a y_in_arcs le bon indice d etiquette en fonction de
			// la direction
			switch (direction) {
			case "haut":
				y_in_arcs = etiquette - 16;
				break;
			case "bas":
				y_in_arcs = etiquette + 16;
				break;
			case "gauche":
				y_in_arcs = etiquette - 1;
				break;
			case "droite":
				y_in_arcs = etiquette + 1;
				break;
			default:
				System.out.println("Erreur: mauvaise direction.");
				System.exit(-1);
			}
		} else { // sinon donut
			switch (direction) {
			case "haut":
				y_in_p = 15;
				y_in_arcs = (NCases - 1) - (15 - etiquette);
				break;
			case "bas":
				y_in_p = 0;
				y_in_arcs = etiquette - (NCases - 1 - 15);
				break;
			case "gauche":
				x_in_p = 15;
				y_in_arcs = etiquette + 15;
				break;
			case "droite":
				x_in_p = 0;
				y_in_arcs = etiquette - 15;
				break;
			default:
				System.out.println("Erreur: mauvaise direction.");
				System.exit(-1);
			}
		}
		indice = p.rechercher(x_in_p, y_in_p);

			// si on peut aller sur cette case
			if ((indice > 10 || indice == 0)) {
				// on cree un arc entre le noeud courant et le noeud a la
				// direction voulue
				arcs[x_in_arcs][y_in_arcs] = 1;
			} else {
				arcs[x_in_arcs][y_in_arcs] = 0;
			}
	}

	/**
	 * @param i
	 * @param j
	 * @return true si la liaison existe false sinon
	 */
	private boolean existeArc(int i, int j) {
		return (arcs[i][j] != 0);
	}

	public int getValArc(int i, int j) {
		if ((i < 0) || (i >= arcs.length) || (j < 0) || (j >= arcs.length)) {
			System.out.println("Graphe::getValArc : Erreur: hors de la matrice.");
			System.exit(-1);
		}
		if (!existeArc(i, j)) {
			System.out.println("Graphe::getValArc : Erreur: aucun arc.");
			System.exit(-1);
		}
		return arcs[i][j];
	}

	/**
	 * Ajoute une liaison reciproque dans arcs
	 * 
	 * @param i
	 * @param j
	 * @param val
	 * @return true si l ajout a bien ete fait false si la liaison existe deja
	 */
	public boolean ajoutArc(int i, int j, int val) {

		if (existeArc(i, j)) {
			return false;
		}

		arcs[i][j] = val;
		arcs[j][i] = val;
		return true;

	}

	public void supprimerArc(int i, int j) {
		arcs[i][j] = 0;
		arcs[j][i] = 0;
	}

	public String toString() {
		String chaine = "";

		// while(j<NCases){
		// chaine += "[";
		// while (i<NCases){
		// chaine += arcs[i][j];
		// i++;
		// }
		// i = 0;
		// chaine += "]\n";
		// j++;
		// }
		for (int k = 0; k < NCases; k++) {
			chaine += k + ":";
			for (int l = 0; l < NCases; l++) {
				if (arcs[k][l] == 1) {
					chaine += " " + l + ", ";
				}
			}
			chaine += "\n";
		}
		return chaine;
	}

	public int[][] getArcs() {
		return arcs;
	}

	public void setArcs(int[][] a) {
		arcs = a;
	}

}
