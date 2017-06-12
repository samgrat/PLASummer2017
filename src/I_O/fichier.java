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
		String chaine = "";

		ArrayList<String> tab = new ArrayList<String>();

		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				tab.add(ligne);
				System.out.println(ligne);
				chaine += ligne + "\n";
			}
			br.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return tab;
	}

	public static void initialisation() {
		try {
			String fichier = "/Joueur1.txt";
			FileWriter fw = new FileWriter(fichier);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
			fichierSortie.println("{X}");
			fichierSortie.println("*{H;B}");
			fichierSortie.println("*{H|{X>O}}");
			fichierSortie.println("*{X|O}");
			fichierSortie.close();
			System.out.println("Le fichier " + fichier + " a été créé!");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		try {
			String fichier2 = "Joueur2.txt";
			FileWriter fw2 = new FileWriter(fichier2);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			PrintWriter fichierSortie2 = new PrintWriter(bw2);

			fichierSortie2.println("*{X;O}");
			fichierSortie2.println("*{H;X}");
			fichierSortie2.println("*{X|O}");
			fichierSortie2.println("*{X|O}");

			fichierSortie2.close();
			System.out.println("Le fichier " + fichier2 + " a été créé!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void ecrire(String fichier, ArrayList<String> s) {
		try {

			FileWriter fw = new FileWriter(fichier);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
			for (String e : s) {
				fichierSortie.println(e);
			}
			fichierSortie.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
