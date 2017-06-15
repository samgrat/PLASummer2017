package Grammaire.Unaires;

import Grammaire.Unaire;
import Programme.Robot;

public class Hit extends Unaire {
	
	int avancement;

	public String toString() {
		return "[H av("+ avancement+")]";
	}

	@Override
	public void exec() {
		// fonction de test
		System.out.println("exec H");
	}

	@Override
	public void exec(Robot robot) {
		// TODO Algo de Hit:
		// le robot frappe en face de lui
		robot.hit(robot.getX(), robot.getY());
		
		
	}

	@Override
	public void exec(Robot r, int a) {
		if (a == avancement)
			System.out.println("exec H avancement " + avancement);
		
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
