package Graphique;

public enum CouleurPiece {
	VIOLET(11), VERT(12), ROSE(13), ORANGE(14);

	private int indice = 0;

	CouleurPiece(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return indice;
	}
}
