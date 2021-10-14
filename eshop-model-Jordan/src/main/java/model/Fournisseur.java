package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne{
	
	@Column(name="society")
	private String societe;
	
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> stock;

	public Fournisseur() {}
	
	public Fournisseur(String login,String password,String nom, String prenom, String societe) {
		super(login,password,nom, prenom);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	
	public List<Produit> getStock() {
		return stock;
	}

	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Fournisseur [societe=" + societe + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
	

}
