package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient implements Serializable {

	@Id
	private int id;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "patient")
	private List<Visite> visites;
	
	public Patient() {}
	
	public Patient(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}


	public List<Visite> getVisites() {
		return visites;
	}


	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}
