package heritage.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("lion")
public class Lion extends Animal {
	
	@Column(name="couleur")
	private String couleurCriniere;
	

	
	
	public Lion(Double poids, String espece, String couleurCriniere) {
		super(poids, espece);
		this.couleurCriniere = couleurCriniere;
	}
	public String getCouleurCriniere() {
		return couleurCriniere;
	}
	public void setCouleurCriniere(String couleurCriniere) {
		this.couleurCriniere = couleurCriniere;
	}
	
	
	@Override
	public String toString() {
		return "Lion [couleurCriniere=" + couleurCriniere + ", id=" + id + ", poids=" + poids + ", espece=" + race
				+ "]";
	}
	
	
	
	
	
}
