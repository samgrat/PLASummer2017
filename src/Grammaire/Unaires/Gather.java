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
				int X = robot.getX();
				int X2 = robot.getX();
				int Y = robot.getY();
				int Y2 = robot.getY();
				
				if(robot.getX()+1 > 15){
					X = -1;
				} else if(robot.getX()-1 < 0){
					X2 = 16;
				}
				
				else{
					X = robot.getX();
				}
				
				if(robot.getY()+1 > 15){
					Y = -1;
				}else if(robot.getY()-1 < 0){
					Y2 = 16;
				}
				
				int lookatright = p.rechercher(X+1,robot.getY());
				int lookatdown = p.rechercher(robot.getX(),Y+1);
				int lookatleft = p.rechercher(X2-1,robot.getY());
				int lookatup = p.rechercher(robot.getX(),Y2-1);
				
				//Si le robot appartient au joueur1
				if(robot.getJoueur().Indice_joueur() == 1){
					 if(lookatright != 11 && lookatright != 12 && lookatright != 13 && lookatright != 14){
						if(lookatdown != 11 && lookatdown != 12 && lookatdown != 13 && lookatdown != 14){
							if(lookatleft != 11 && lookatleft != 12 && lookatleft != 13 && lookatleft != 14){
								if(lookatup != 11 && lookatup != 12 && lookatup != 13 && lookatup != 14){
									throw new ExpException();
								}
								else{
									p.ramasser(robot.getX(), Y2-1, robot.getJoueur(), 1);
								}
							}
							else{
								p.ramasser(X2-1, robot.getY(), robot.getJoueur(), 1);

							}
						}
						else{
							p.ramasser(robot.getX(), Y+1, robot.getJoueur(), 1);

						}	
					 }
					 else{
						 p.ramasser(X+1, robot.getY(), robot.getJoueur(), 1);
					}
				}
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement) 
			exec(r);		
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
