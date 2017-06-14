package Grammaire;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import Grammaire.Binaires.*;
import Grammaire.Unaires.*;

public class Dico {

	private String sym;
	static Map<String, Unaire> contexteSym = new HashMap<>();

	// static{
	//
	// contexteSym.put("H", new Hit());
	// contexteSym.put("G", new Gather());
	// contexteSym.put("E", new Explore());
	// contexteSym.put("B", new Best());
	// contexteSym.put("M", new Move());
	// contexteSym.put("O", new Opponent());
	// }

	public static Unaire get(String l) {
		switch (l) {
		case "H":
			return new Hit();
		case "G":
			return new Gather();
		case "E":
			return new Explore();
		case "B":
			return new Best();
		case "M":
			return new Move();
		case "O":
			return new Opponent();
		default:
			return null;
		}

	}

	public static Unaire get(String l, int avancement) {
		switch (l) {
		case "H":
			Unaire H = new Hit();
			H.setAvancement(avancement);
			return H;
		case "G":
			Unaire G = new Gather();
			G.setAvancement(avancement);
			return G;
		case "E":
			Unaire E = new Explore();
			E.setAvancement(avancement);
			return E;
		case "B":
			Unaire B = new Best();
			B.setAvancement(avancement);
			return B;
		case "M":
			Unaire M = new Move();
			M.setAvancement(avancement);
			return M;
		case "O":
			Unaire O = new Opponent();
			O.setAvancement(avancement);
			return O;
		default:
			return null;
		}
	}

	/**
	 * 
	 * @param un
	 *            : l'Unaire que l'on cherche
	 *
	 */
	public String toString(Unaire un) {
		return un.toString();
	}

	/**
	 * La fonction affiche le contenu de la table
	 * 
	 * @param contexteSym
	 *            : la table contenant les opérateurs unaire
	 */
	public void toPrint(Map<Integer, String> contexteSym) {
		System.out.println("Parcours de l'objet HashMap : ");
		Set<Entry<Integer, String>> setHm = contexteSym.entrySet();
		Iterator<Entry<Integer, String>> it = setHm.iterator();
		while (it.hasNext()) {
			Entry<Integer, String> e = it.next();
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}