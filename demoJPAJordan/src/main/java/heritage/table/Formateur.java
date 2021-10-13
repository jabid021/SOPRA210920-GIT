package heritage.table;

import javax.persistence.Entity;

//@Entity
public class Formateur extends Personne{

	
	private String matiere;
	
	
	public Formateur() {
	}


	public Formateur(String nom, String prenom, String matiere) {
		super(nom, prenom);
		this.matiere = matiere;
	}


	public String getMatiere() {
		return matiere;
	}


	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}


	@Override
	public String toString() {
		return "Formateur [matiere=" + matiere + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
