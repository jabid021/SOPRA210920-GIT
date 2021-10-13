package heritage.single;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "espece")
public abstract class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected Double poids;
	protected String race;
	
	public Animal() {
	}

	public Animal(Double poids, String race) {
		this.poids = poids;
		this.race = race;
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

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	
	
	
	
	
}
