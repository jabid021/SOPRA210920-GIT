package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
//opt
@Table(name="planet",uniqueConstraints=@UniqueConstraint(columnNames = { "lib","diametre","typePlanete" }))

public class Planete {
	
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	@Column(name="idDeLaPlanete")
	private int id;
	@Column(name="lib",columnDefinition = "VARCHAR(12)")
	
	private String libelle;
	
	@Enumerated(EnumType.STRING)
	private TypePlanete typePlanete;

	private Double diametre;
	
	
	@ManyToOne
	@JoinColumn(name="id_systeme")
	private Systeme solaire;
	
	@ManyToMany
	@JoinTable
	(
		name="proxi",
		joinColumns = @JoinColumn(name="idPlanete"),
		inverseJoinColumns = @JoinColumn(name="idAsteroide")
	)
	private List<Asteroide> asteroides;
	
	@OneToOne
	@JoinColumn(name="atm")
	private ATM atm;
	
	@OneToMany(mappedBy = "planete")
	private List<Satellite> satellites;
	


	public Planete() {}
	
	
	
	
	public Planete(String libelle, TypePlanete typePlanete, Double diametre, Systeme solaire,
			List<Asteroide> asteroides, ATM atm) {
		this.libelle = libelle;
		this.typePlanete = typePlanete;
		this.diametre = diametre;
		this.solaire = solaire;
		this.asteroides = asteroides;
		this.atm = atm;
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




	public Systeme getSolaire() {
		return solaire;
	}




	public void setSolaire(Systeme solaire) {
		this.solaire = solaire;
	}




	public List<Asteroide> getAsteroides() {
		return asteroides;
	}




	public void setAsteroides(List<Asteroide> asteroides) {
		this.asteroides = asteroides;
	}




	public ATM getAtm() {
		return atm;
	}




	public void setAtm(ATM atm) {
		this.atm = atm;
	}




	public List<Satellite> getSatellites() {
		return satellites;
	}




	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}




	@Override
	public String toString() {
		return "Planete [id=" + id + ", libelle=" + libelle + ", typePlanete=" + typePlanete + ", diametre=" + diametre
				+ ", solaire=" + solaire + ", asteroides=" + asteroides + ", atm=" + atm + "]";
	}

	
	
	
	
	

}
