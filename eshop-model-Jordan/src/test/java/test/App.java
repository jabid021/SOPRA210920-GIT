package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Achat;
import model.Client;
import model.Fournisseur;
import model.Personne;
import model.Produit;
import util.Context;


public class App {

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	
	
	private static void testBdd() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		Client c = new Client("jabid","1234","Abid","Jordan",28,LocalDate.parse("1993-05-01"));
		Fournisseur f = new Fournisseur("jo","password","Doe", "John", "AJC");
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
	
	public static void demoJPQL() 
	{

		/*Fournisseur f = new Fournisseur("Doe", "John", "AJC");
		
		
		Client c = new Client("Abid","Jordan",42,LocalDate.parse("2000-01-01"));
		
		f=Context.getInstance().getDaoFournisseur().save(f);
		Produit p1 = new Produit("PS5",800,f);
		Produit p2 = new Produit("Switch",15,f);
		
		p1=Context.getInstance().getDaoProduit().save(p1);
		p2=Context.getInstance().getDaoProduit().save(p2);
		
		c=Context.getInstance().getDaoClient().save(c);
		
		Achat a =new Achat(p2, c);
		a=Context.getInstance().getDaoAchat().save(a);
		
		Achat achatbbd = Context.getInstance().getDaoAchat().findById(a.getId());
		System.out.println("Detail de l'achat : "+ achatbbd.getClient().getNom()+" à acheté "+achatbbd.getProduit().getLibelle());
		
		//Context.getInstance().getDaoAchat().delete(achatbbd);
		//Context.getInstance().getDaoClient().delete(c);
		System.out.println(Context.getInstance().getDaoClient().findById(c.getId()));
		
		*/
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		/*Query requete = em.createQuery("from Produit",Produit.class);
		
		List<Produit> produits = requete.getResultList();
		
	
		for(Produit p : produits) 
		{
			System.out.println(p);
		}
		
		*/
		
		
		Query requete = em.createQuery("from Produit p where p.libelle like :lib",Produit.class);
		requete.setParameter("lib", "%W%");
		
		List<Produit> produits = requete.getResultList();
		
	
		for(Produit p : produits) 
		{
			System.out.println(p);
		}
		
		
		
		Query requeteConnect = em.createQuery("Select p from Personne p where p.nom=:login and p.prenom=:password",Personne.class);
		requeteConnect.setParameter("login", "Abid");
		requeteConnect.setParameter("password", "Jordan");
		Personne connected=null;
		
		try {
			connected =  (Personne) requeteConnect.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();System.out.println("Identifiants invalides");}
		
	

		Query q = em.createNamedQuery("Produit.findByLibelle",Produit.class);
		q.setParameter("lelibelle","PS5");
		List<Produit> prods = q.getResultList();
		
		
		System.out.println(connected);
		em.close();
		
		Context.getInstance().closeEmf();
	}
	public static void main(String[] args) {
		
		//Client c = new Client("jabid","1234","Abid","Jordan",28,LocalDate.parse("1993-05-01"));
		//Fournisseur f = new Fournisseur("jo","password","Doe", "John", "AJC");
		
		
		//Context.getInstance().getDaoPersonne().save(c);
		//Context.getInstance().getDaoPersonne().save(f);
		
		String login = saisieString("Saisir login");
		String password= saisieString("Saisir password");
		Personne p = Context.getInstance().getDaoPersonne().connect(login, password);
		
		if(p==null) {System.out.println("Invalides");}
		else 
		{
			System.out.println(p);
		}
		
		
		
		Context.getInstance().closeEmf();
	}

}
