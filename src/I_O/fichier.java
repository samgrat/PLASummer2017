package I_O;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class fichier {
	public static ArrayList<String> lecture(String fichier) {

		ArrayList<String> tab = new ArrayList<String>();

		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				tab.add(ligne);
			}
			br.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return tab;
	}

	public static void initialisation(String f) {
		if(f == "Joueur1.txt"){
		try {
			String fichier = f;
			FileWriter fw = new FileWriter(fichier);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
			fichierSortie.println("");
			fichierSortie.println("{M}");
			fichierSortie.println("*{H;M}");
			fichierSortie.println("*{H|{R>E}}");
			fichierSortie.println("*{E|H}");
			fichierSortie.println("{M}");
			fichierSortie.println("*{H;M}");
			fichierSortie.println("*{H|{R>E}}");
			fichierSortie.println("*{E|H}");
			fichierSortie.close();
			System.out.println("Le fichier " + fichier + " a ete cree!");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		}else{
		try {
			String fichier2 = f;
			FileWriter fw2 = new FileWriter(fichier2);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			PrintWriter fichierSortie2 = new PrintWriter(bw2);
			fichierSortie2.println("");
			fichierSortie2.println("{X;O}");
			fichierSortie2.println("{H;X}");
			fichierSortie2.println("{X|O}");
			fichierSortie2.println("{X|O}");
			fichierSortie2.println("{M}");
			fichierSortie2.println("{H;M}");
			fichierSortie2.println("{H|{R>E}}");
			fichierSortie2.println("{E|H}");
			fichierSortie2.close();
			System.out.println("Le fichier " + fichier2 + " a ete cree!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public static void ecrire(String fichier, String s) {

		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fichier, true)));

			pw.println(s);
			

			pw.close();
		} catch (IOException exception) {
			System.out.println("Erreur lors de la lecture : " + exception.getMessage());
		}

	}

}
