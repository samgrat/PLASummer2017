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
						g.list_noeuds[i].setDistance(noeud_courant.getDistance() + g.arcs[noeud_courant.getEtiquette()][i]);
						g.list_noeuds[i].setPred(noeud_courant.getEtiquette());
					}
				}
			}
		} while (q != 0);

		int j = 0;
		noeud nc = new noeud(g.list_noeuds[destination]);
		// parcours recurssif pour trouver le chemin
		while (nc.getEtiquette() != origine && j < g.NCases) {
			chemin.add(j, nc.getEtiquette());
			nc = g.list_noeuds[nc.getPred()];
			j++;
		}
		chemin.add(j, origine);
		reverse();
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
}
