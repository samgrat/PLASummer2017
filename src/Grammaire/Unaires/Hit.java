package Grammaire.Unaires;

import Grammaire.ExpException;
import Grammaire.Unaire;
import Graphique.Plateau;
import Programme.Robot;
import Programme.Joueur;


public class Hit extends Unaire {

	public String toString() {
		return "H";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec H");
	}

	@Override
	public void exec(Robot robot) {
		// TODO Algo de Hit:$
		
		Plateau p = robot.getPlateau();
		
		int X = robot.getX();
		int Y = robot.getY();
		
		if(robot.getX()+1 > 15){
			X = -1;
		}
		if(robot.getX()-1 < 0){
			X = 16;
		}
		else{
			X = robot.getX();
		}
		
		
		if(robot.getY()+1 > 15){
			Y = -1;
		}
		if(robot.getY()-1 < 0){
			Y = 16;
		}
		
		
			
		
		
		
		//Si le robot appartient au joueur1
		if(robot.getJoueur().Indice_joueur() == 1){
			
			 if(p.rechercher(X+1,robot.getY()) != 2){
				if(p.rechercher(robot.getX(),Y+1) != 2){
					if(p.rechercher(X-1,robot.getY()) != 2){
						if(p.rechercher(robot.getX(),Y-1) != 2){
							throw new ExpException();
						}
						else{
							robot.hit(robot.getX(),Y-1);
						}
					}
					else{
						robot.hit(X-1,robot.getY());
					}
				}
				else{
					robot.hit(robot.getX(),Y+1);
				}	
			 }
			 else{
				robot.hit(X+1,robot.getY());
			}
		}
			 
		//Si le robot apaprtient au joueur2
		else{
			 if(p.rechercher(X+1,robot.getY()) != 1){
					if(p.rechercher(robot.getX(),Y+1) != 1){
						if(p.rechercher(X-1,robot.getY()) != 1){
							if(p.rechercher(robot.getX(),Y-1) != 1){
								throw new ExpException();
							}
							else{
								exec();
							}
						}
						else{
							exec();
						}
					}
					else{
						exec();
					}	
				 }
				 else{
						exec();
				}
		}
				
	}
}
