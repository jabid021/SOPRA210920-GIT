package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ATM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@OneToOne(mappedBy = "atm" )
	private Planete planete;
	
	public ATM() {
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
		return "ATM [id=" + id + "]";
	}
	

	
}
