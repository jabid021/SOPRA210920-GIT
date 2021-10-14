package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Achat;
import model.Client;
import model.Fournisseur;
import model.Produit;


public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		Client c = new Client("Abid","Jordan",28,LocalDate.parse("1993-05-01"));
		Fournisseur f = new Fournisseur("Doe", "John", "AJC");
		Produit p1 = new Produit("PS5",800,f);
		Produit p2 = new Produit("Switch",15,f);
		
		Achat a1 = new Achat(p1,c);
		Achat a2 = new Achat(p2,c);
		
	
		
		
		em.getTransaction().begin();
		//em.persist(f);
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(c);
		
		System.out.println(a1);
		em.persist(a1);
		em.persist(a2);
	
		System.out.println(a1);
		
		
		
		em.getTransaction().commit();
		
		
		em.close();
		
		
		em=emf.createEntityManager();
		
		Produit produit = em.find(Produit.class, 1);
		
		

		for(Achat achat : produit.getAcheteurs()) 
		{
			System.out.println(achat.getDateAchat());
		}
		em.close();
		//System.out.println(clientBdd);
		
		//@ToOne => Eager
		//@ToMany => Lazy
		
		
		
		emf.close();
	}

}
