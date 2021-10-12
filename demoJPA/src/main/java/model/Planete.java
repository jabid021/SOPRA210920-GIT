package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//opt
@Table(name="planet")
public class Planete {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="lib")
	private String libelle;
	private String typePlanete;
	private double diametre;
	

	public Planete() {}
	
	public Planete(String libelle, String typePlanete, double diametre) {
		this.libelle = libelle;
		this.typePlanete = typePlanete;
		this.diametre = diametre;
	}
	
	
	

	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getTypePlanete() {
		return typePlanete;
	}
	public void setTypePlanete(String typePlanete) {
		this.typePlanete = typePlanete;
	}
	public double getDiametre() {
		return diametre;
	}
	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Planete [libelle=" + libelle + ", typePlanete=" + typePlanete + ", diametre=" + diametre + "]";
	}
	
	
	
	

}
