package heritage.table;

import javax.persistence.Entity;

//@Entity
public class Eleve extends Personne {

	
	private int quest;
	
	public Eleve() {
	}

	public Eleve(String nom, String prenom, int quest) {
		super(nom, prenom);
		this.quest = quest;
	}

	public int getQuest() {
		return quest;
	}

	public void setQuest(int quest) {
		this.quest = quest;
	}

	@Override
	public String toString() {
		return "Eleve [quest=" + quest + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
