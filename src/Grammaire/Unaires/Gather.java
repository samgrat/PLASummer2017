package Grammaire.Unaires;

import Grammaire.ExpException;
import Grammaire.Unaire;
import Graphique.Plateau;
import Programme.Robot;

public class Gather extends Unaire {
	
	int avancement;

	public String toString() {
		return "[G av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
	}

	@Override
	public void exec(Robot robot) {
		// TODO Algo de Gather
		// le robot recolte une ressource dans un perimetre autour de lui
		Plateau p = robot.getPlateau();
		
		if(p.rechercher(robot.getX(),robot.getY()) == 11){
			if(p.rechercher(robot.getX(),robot.getY()) == 12){
				if(p.rechercher(robot.getX(),robot.getY()) == 13){
					if(p.rechercher(robot.getX(),robot.getY()) == 14){
						throw new ExpException();
					}else{	
						p.ramasser(robot.getX(),robot.getY(), robot.getJoueur(),14);
					}
				}else{
					p.ramasser(robot.getX(),robot.getY(), robot.getJoueur(),13);
				}
			}else{
				p.ramasser(robot.getX(),robot.getY(), robot.getJoueur(),12);
			}
		}else{
			p.ramasser(robot.getX(),robot.getY(), robot.getJoueur(),11);
		}
		
		
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement) {}
		
	}
	
	@Override
	public void setAvancement(int a) {
		if (avancement == 0)
			avancement = a;
	}
	
	@Override
	public int getAvancement() {
		return avancement;
	}
	
	@Override
	public int getAvancementMax() {
		return avancement;
	}
}
