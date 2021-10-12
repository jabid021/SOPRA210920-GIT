package heritage.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("duck")
public class Canard extends Animal {

	@Column(name="bec")
	private Double tailleBec;

	
	public Canard(Double poids, String espece, Double tailleBec) {
		super(poids, espece);
		this.tailleBec = tailleBec;
	}

	public Double getTailleBec() {
		return tailleBec;
	}

	public void setTailleBec(Double tailleBec) {
		this.tailleBec = tailleBec;
	}

	@Override
	public String toString() {
		return "Canard [tailleBec=" + tailleBec + ", id=" + id + ", poids=" + poids + ", espece=" + race + "]";
	}
	
	
	
}
