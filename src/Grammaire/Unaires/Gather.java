package Grammaire.Unaires;

import Grammaire.ExpException;
import Grammaire.Unaire;
import Graphique.Plateau;
import Programme.Robot;

public class Gather extends Unaire {

	public String toString() {
		return "G";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec G");
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

}