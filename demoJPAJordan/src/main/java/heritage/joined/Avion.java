package heritage.joined;

import javax.persistence.Entity;

//@Entity
public class Avion extends Vehicule {

	private int nbReacteur;

	public Avion() {
		// TODO Auto-generated constructor stub
	}
	
	public Avion(Double poids, int nbReacteur) {
		super(poids);
		this.nbReacteur = nbReacteur;
	}

	public int getNbReacteur() {
		return nbReacteur;
	}

	public void setNbReacteur(int nbReacteur) {
		this.nbReacteur = nbReacteur;
	}

	@Override
	public String toString() {
		return "Avion [nbReacteur=" + nbReacteur + ", id=" + id + ", poids=" + poids + "]";
	}
	
	
}
