package model;

import javax.persistence.Embeddable;

@Embeddable	
public class Adresse {

	
	private String voie;
	private String numero;
	private String ville;
	private String cp;
	
	
	public Adresse() {
	}


	public Adresse(String voie, String numero, String ville, String cp) {
		this.voie = voie;
		this.numero = numero;
		this.ville = ville;
		this.cp = cp;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Adresse [voie=" + voie + ", numero=" + numero + ", ville=" + ville + ", cp=" + cp + "]";
	}
	
	
	
}
