package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import heritage.single.Canard;
import heritage.single.Lion;
import model.Planete;
import model.TypePlanete;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		
		//Planete p = new Planete("Terre2",TypePlanete.Tellurique,12742.0);
		
		//Planete p2 = new Planete("Terre",TypePlanete.Gazeux,null);
		
		Lion l = new Lion(150.0, "Lion des neiges","Rose");
		Canard tpt = new Canard(8.0, "TPT", 2.0);
		
		
		em.getTransaction().begin();
	//	em.persist(p);
	//	em.persist(p2);
		
		em.persist(tpt);
		em.persist(l);
		
		em.getTransaction().commit();
		
	
		em.close();
		
		
		em = emf.createEntityManager();
		
		//Planete pBase = em.find(Planete.class, 1);
		//System.out.println(pBase);
		//System.out.println(em.find(Planete.class, 2));
		em.close();
		
	
		
		
		emf.close();
		
		
	}

}
