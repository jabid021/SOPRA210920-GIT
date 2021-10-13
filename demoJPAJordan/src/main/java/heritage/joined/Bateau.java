package heritage.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
@PrimaryKeyJoinColumn(name="id_bateau")
public class Bateau extends Vehicule{

	
	private double tailleVoile;
	
	
	public Bateau() {
	}


	public Bateau(Double poids, double tailleVoile) {
		super(poids);
		this.tailleVoile = tailleVoile;
	}


	public double getTailleVoile() {
		return tailleVoile;
	}


	public void setTailleVoile(double tailleVoile) {
		this.tailleVoile = tailleVoile;
	}


	@Override
	public String toString() {
		return "Bateau [tailleVoile=" + tailleVoile + ", id=" + id + ", poids=" + poids + "]";
	}
	
	
}
