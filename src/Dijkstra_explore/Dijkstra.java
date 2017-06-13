package Dijkstra_explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Graphique.Plateau;

public class Dijkstra {
	private List<Boolean> Q;
	private Graphe g;
	public int origine;
	public int destination;
	public List<Integer> chemin;

	public Dijkstra(Plateau p, int o, int d) {
		
		g = new Graphe(p);
		
		int param = 0;
		destination = d;
		System.out.println("Sur case X: "+etiquettetoX(d)+" Y: "+etiquettetoY(d)+" indice: "+d+" : "+g.p.rechercher(etiquettetoY(d), etiquettetoX(d)));
		while(g.p.rechercher(etiquettetoX(d), etiquettetoY(d)) <= 10 && g.p.rechercher(etiquettetoX(d), etiquettetoY(d)) != 0){
			System.out.println("Sur case in while"+d+" : "+g.p.rechercher(etiquettetoY(d), etiquettetoX(d)));
			d = lookAround(destination, param);
			param++ ;
		}
		chemin = new ArrayList<Integer>();
		Q = new ArrayList<Boolean>();
		int q = g.NCases - 1;
		origine = o;
		destination = d;
		noeud noeud_courant = new noeud();
		// tous les noeuds appartiennent au graph a l init
		for (int i = 0; i < g.NCases; i++) {
			Q.add(i, true);
		}

		// on initialize de l origine
		g.list_noeuds[origine].setDistance(0);

		do {
			// on recupere le noeud avec la distance la plus petite
			noeud_courant = g.list_noeuds[distance_min_in_g(g, Q)];

			// on met la case correspondante au noeud a false
			Q.set(noeud_courant.getEtiquette(), false);
			q--;

			for (int i = 0; i < g.NCases; i++) {
				// si il y a un arc
				if(g.arcs[noeud_courant.getEtiquette()][i] != 0){
					// si le nouveau chemin est plus court
					if (noeud_courant.getDistance() + g.arcs[noeud_courant.getEtiquette()][i] < g.list_noeuds[i]
							.getDistance()) {
						// mise a jour du chemin
						g.list_noeuds[i]
								.setDistance(noeud_courant.getDistance() + g.arcs[noeud_courant.getEtiquette()][i]);
						g.list_noeuds[i].setPred(noeud_courant.getEtiquette());
					}
				}
			}
		} while (q != 0);

		int j = 0;
		noeud nc = new noeud(g.list_noeuds[destination]);
		int cheat;
		int param2 = 0;
		// parcours recurssif pour trouver le chemin
		while (nc.getEtiquette() != origine && j < g.NCases) {
			chemin.add(j, nc.getEtiquette());
			cheat = nc.getPred();
			while(cheat == -1){
				cheat = lookAround(nc.getEtiquette(), param2);
				param2++;
			}
			nc = g.list_noeuds[cheat];
			j++;
		}
		chemin.add(j, origine);
		reverse();
	}

	// TODO A DEBUG
	private int lookAround(int d, int param) {
		int var_dir_x = 0, var_dir_y = 0;
		
		switch (param) {
		case 0:
			var_dir_y = -1;
			break;
		case 1:
			var_dir_y = 1;
			break;
		case 2:
			var_dir_x = -1;
			break;
		case 3:
			var_dir_x = 1;
			break;
		default:
			System.out.println("Erreur: mauvaise direction.");
			System.exit(-1);
		}
		
		if (0 <= d + var_dir_x && d + var_dir_x < 16 && 0 <= d + var_dir_y && d + var_dir_y < 16) {

			// la direction
			switch (param) {
			case 0:
				d = d - 16;
				break;
			case 1:
				d = d + 16;
				break;
			case 2:
				d = d - 1;
				break;
			case 3:
				d = d + 1;
				break;
			default:
				System.out.println("Erreur: la cible est entouree");
				System.exit(-1);
			}
		} else { // sinon donut
			switch (param) {
			case 0:
				d = d + 240;
				break;
			case 1:
				d = d - 240;
				break;
			case 2:
				d = d + 15;
				break;
			case 3:
				d = d - 15;
				break;
			default:
				System.out.println("Erreur: la cible est entouree");
				System.exit(-1);
			}
		}
		return d;
	}


	private void reverse() {
		List<Integer> save = Arrays.asList(new Integer[chemin.size()]);
		for (int i = 1; i <= chemin.size(); i++)
			save.set(chemin.size() - i, chemin.get(i - 1));
		
		chemin = save;
	}

	/**
	 * retourne le noeud avec la distance la plus petite dans le graphe
	 * 
	 * @param g:
	 *            le graphe
	 * @param q:
	 *            tableau des noeuds considere
	 * @return
	 */
	int distance_min_in_g(Graphe g, List<Boolean> q) {
		float dmin = Graphe.INFINI + 1;
		int n = -1;

		for (int i = 0; i < g.NCases; i++) {
			// si le noeud est considere et que sa distance est inferieure a
			// dmin
			if (Q.get(i) && g.list_noeuds[i].getDistance() < dmin) {
				dmin = g.list_noeuds[i].getDistance();
				n = i;
			}
		}
		return n;
	}
	
	/**
	 * retourne le X associe a l etiquette entrante
	 * @param etq
	 * @return
	 */
	int etiquettetoX(int etq){
		return etq/(16*((etq%16)+1));
	}
	
	/**
	 * retourne le Y associe a l etiquette entrante
	 * @param etq
	 * @return
	 */
	int etiquettetoY(int etq){
		return etq%16;
	}
}
