package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Fournisseur;


public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		Client c = new Client("Abid","Jordan",28,LocalDate.parse("1993-05-01"));
		Fournisseur f = new Fournisseur("Doe", "John", "AJC");
		
		
		em.getTransaction().begin();
		
		em.persist(c);
		em.persist(f);
		
		em.getTransaction().commit();
		
		
		em.close();
		
		
		emf.close();
	}

}
