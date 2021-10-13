package heritage.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Vehicule")
	protected int id;
	
	
	protected Double poids;

	public Vehicule() {
	}
	
	public Vehicule(Double poids) {
		this.poids = poids;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Double getPoids() {
		return poids;
	}


	public void setPoids(Double poids) {
		this.poids = poids;
	}
	
	
	
}
