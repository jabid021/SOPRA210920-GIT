package heritage.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
@PrimaryKeyJoinColumn(name="id_voiture")
public class Voiture extends Vehicule{

	
	private String marque;

	public Voiture() {
	}
	
	public Voiture(Double poids, String marque) {
		super(poids);
		this.marque = marque;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", id=" + id + ", poids=" + poids + "]";
	}
	
	
	
}
