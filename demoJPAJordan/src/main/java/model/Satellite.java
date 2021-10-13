package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Satellite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToOne
	private Planete planete;
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
	private Satellite manager;
	
	public Satellite() {
	
	}
	
	
	
	public Satellite(String nom,Planete planete) {
		this.nom=nom;
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
	
	

	public Satellite getManager() {
		return manager;
	}



	public void setManager(Satellite manager) {
		this.manager = manager;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public String toString() {
		return "Satellite [id=" + id + ", nom=" + nom + ", planete=" + planete + ", manager=" + manager + "]";
	}



	



	
	
}
