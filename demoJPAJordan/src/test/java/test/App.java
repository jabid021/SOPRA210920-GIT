package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import heritage.joined.Avion;
import heritage.joined.Bateau;
import heritage.joined.Voiture;
import heritage.single.Animal;
import heritage.single.Canard;
import heritage.single.Lion;
import heritage.table.Eleve;
import heritage.table.Formateur;
import heritage.table.Personne;
import model.ATM;
import model.Asteroide;
import model.Planete;
import model.Satellite;
import model.Systeme;
import model.TypePlanete;

public class App {

	public static void demoHeritage() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		
		//Planete p = new Planete("Terre2",TypePlanete.Tellurique,12742.0);
		
		//Planete p2 = new Planete("Terre",TypePlanete.Gazeux,null);
		
		Lion l = new Lion(150.0, "Lion des neiges","Rose");
		Canard tpt = new Canard(8.0, "TPT", 2.0);
		
		
		Avion a = new Avion(1200.0,4);
		Bateau b = new Bateau(5000.0,12);
		Voiture v = new Voiture(500.0,"Fiat Panda");
		
		Eleve e = new Eleve("Monod","Achille",1403);
		Formateur f = new Formateur("Abid","Jordan","JPA"); 
		em.getTransaction().begin();
	//	em.persist(p);
	//	em.persist(p2);
		
		em.persist(tpt);
		em.persist(l);
		em.persist(v);
		em.persist(a);
		em.persist(b);
		em.persist(e);
		em.persist(f);
		
		em.getTransaction().commit();
		
	
		em.close();
		
		
		em = emf.createEntityManager();
		
		//Planete pBase = em.find(Planete.class, 1);
		//System.out.println(pBase);
		//System.out.println(em.find(Planete.class, 2));
		//em.close();
		
		System.out.println("--------------------------------");
		Animal canard = em.find(Animal.class, 1);
		System.out.println(canard);
		
		System.out.println("--------------------------------");
		Voiture voiture = em.find(Voiture.class, 1);
		System.out.println(voiture);
		
		System.out.println("--------------------------------");
		
		Personne eleve = em.find(Personne.class, 1);
		System.out.println(eleve);
		
		
		System.out.println("--------------------------------");
		
		Formateur formateur = em.find(Formateur.class, 2);
		System.out.println(formateur);
		emf.close();
		
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		ATM atm = new ATM();
		Systeme solaire= new Systeme();
		Asteroide a1 = new Asteroide();
		Asteroide a2 = new Asteroide();
		Asteroide a3 = new Asteroide();
		List<Asteroide> asteroides =new ArrayList();
		asteroides.add(a1);
		asteroides.add(a2);
		asteroides.add(a3);
		
		
		Planete terre = new Planete("terre",TypePlanete.Tellurique,12742.0,solaire,asteroides,atm);
	
		
		Satellite s1 = new Satellite("Sat1",terre);
		
		Satellite s2 = new Satellite("Sat2",terre);
		s2.setManager(s1);
		
		Satellite s3 = new Satellite("Sat3",terre);
		s3.setManager(s2);
		
		
		
		
		
		em.getTransaction().begin();
		em.persist(atm);
		em.persist(solaire);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(terre);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		
		
		em.getTransaction().commit();
		
		em.close();
		
		
		em=emf.createEntityManager();
		
		Satellite sBdd = em.find(Satellite.class, 3);
		sBdd.setNom("Lune");
		em.merge(sBdd);
	
		em.close();
		
		
		em=emf.createEntityManager();

		//Satellite s = em.find(Satellite.class, 3);
		s3=em.merge(s3);
		em.remove(s3);
		
		em.close();
		
		
		em=emf.createEntityManager();
		System.out.println(em.find(Satellite.class, 3));
		em.close();
		
		emf.close();
		
		
	}	
		
		
		
		/*
		 * C => persist(objet)
		 * RAll => ?
		 * ROne => find(Class.class,id);
		 * U => merge(objet);
		 * D => remove(objet);
		 */
		 
	
	/*Planete p ;
	 *  persist(p) => p est managed
	 *  p = find() => p est managed
	 *  Planete p2 = merge(p) =>  p n'est pas managed , p2 est managed
	 *  
	 * 	remove(p) => il faut p managed 
	 * 
	*/
	}

	
	
	
	

