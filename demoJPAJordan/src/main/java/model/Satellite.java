package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Satellite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Planete planete;
	
	public Satellite() {
	
	}
	
	

	public Satellite(Planete planete) {
		this.planete = planete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Planete getPlanete() {
		return planete;
	}

	public void setPlanete(Planete planete) {
		this.planete = planete;
	}

	@Override
	public String toString() {
		return "Satelite [id=" + id + ", planete=" + planete + "]";
	}
	
	
}
