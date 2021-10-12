package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name="lib",columnDefinition = "VARCHAR(12)",unique = true)
	
	private String libelle;
	
	@Enumerated(EnumType.STRING)
	private TypePlanete typePlanete;

	private Double diametre;

	public Planete() {}
	
	public Planete(String libelle, TypePlanete typePlanete, Double diametre) {
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
	public TypePlanete getTypePlanete() {
		return typePlanete;
	}
	public void setTypePlanete(TypePlanete typePlanete) {
		this.typePlanete = typePlanete;
	}
	public Double getDiametre() {
		return diametre;
	}
	public void setDiametre(Double diametre) {
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
