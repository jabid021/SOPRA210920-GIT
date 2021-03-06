package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",columnDefinition = ("ENUM('supplier','customer')"))
public abstract class Personne {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name="lastname")
	protected String nom;
	@Column(name="firstname")
	protected String prenom;
	
	@Column(unique = true)
	protected String login;
	protected String password;
	
	@Embedded
	protected Adresse adresse;
	
	public Personne() {
	}

	public Personne(String login,String password,String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.login=login;
		this.password=password;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
