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
	

	static{

		contexteSym.put("H", new Hit());
		contexteSym.put("G", new Gather());
		contexteSym.put("E", new Explore());
		contexteSym.put("B", new Best());
		contexteSym.put("F", new Follow());
		contexteSym.put("M", new Move());
		contexteSym.put("P", new Protect());
		contexteSym.put("R", new Repeat());
		contexteSym.put("O", new Opponent());
	}
	
	public static Unaire get(String l){
		return contexteSym.get(l);
	}

	/**
	 * 
	 * @param un : l'Unaire que l'on cherche
	 *
	 */
	public String toString(Unaire un) {
		return un.toString();
	}
	
	/**
	 * La fonction affiche le contenu de la table
	 * @param contexteSym : la table contenant les opérateurs unaire
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