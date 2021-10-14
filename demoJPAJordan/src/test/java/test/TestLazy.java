package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Asteroide;
import model.Planete;
import model.Satellite;
import util.Context;

public class TestLazy {


	//Acces aux satellites avant le em.close();
	//Impossible de filtrer sur des infos satellites
	public static void showLazyJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("from Planete p",Planete.class);
		List<Planete> planetes = q.getResultList();
		em.close();

		for(Planete p : planetes) 
		{
			System.out.println("--------------------");
			System.out.println("infos de la planete : "+p.getLibelle());
			System.out.println("Liste des satellites :");
			System.out.println(p.getSatellites());

		}	
	}

	//Acces aux satellites avant le em.close();
	//Possible de filtrer sur des infos satellites
	//Recup uniquement les planetes qui match la jointure
	//Affiche des doublons de planete si plusieurs Satelittes
	public static void showJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT p from Planete p JOIN p.satellites ",Planete.class);
		List<Planete> planetes = q.getResultList();


		for(Planete p : planetes) 
		{
			System.out.println("--------------------");
			System.out.println("infos de la planete : "+p.getLibelle());
			System.out.println("Liste des satellites :");
			System.out.println(p.getSatellites());

		}	
		em.close();
	}



	//Acces aux satellites avant le em.close();
	//Possible de filtrer sur des infos satellites
	//Recup toutes les planetes
	//Affiche des doublons de planete si plusieurs Satelittes
	public static void showLeftJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT p from Planete p LEFT JOIN p.satellites ",Planete.class);
		List<Planete> planetes = q.getResultList();


		for(Planete p : planetes) 
		{
			System.out.println("--------------------");
			System.out.println("infos de la planete : "+p.getLibelle());
			System.out.println("Liste des satellites :");
			System.out.println(p.getSatellites());

		}	
		em.close();
	}



	//Acces aux satellites avant le em.close();
	//Possible de filtrer sur des infos satellites
	//Recup toutes les planetes
	//N'affiche pas de doublons de planete si plusieurs Satelittes
	public static void showLeftJoinSansDoublons() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT distinct p from Planete p LEFT JOIN p.satellites ",Planete.class);
		List<Planete> planetes = q.getResultList();


		for(Planete p : planetes) 
		{
			System.out.println("--------------------");
			System.out.println("infos de la planete : "+p.getLibelle());
			System.out.println("Liste des satellites :");
			System.out.println(p.getSatellites());

		}	
		em.close();
	}



	//Acces aux satellites apres le em.close();
	//Possible de filtrer sur des infos satellites
	//Recup toutes les planetes
	//N'affiche pas de doublons de planete si plusieurs Satelittes
	public static void showLeftJoinSansDoublonsFETCH() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT distinct p from Planete p LEFT JOIN fetch p.satellites s ",Planete.class);
		List<Planete> planetes = q.getResultList();
		em.close();

		for(Planete p : planetes) 
		{
			System.out.println("--------------------");
			System.out.println("infos de la planete : "+p.getLibelle());
			System.out.println("Liste des satellites :");
			for(Satellite s : p.getSatellites()) 
			{
				System.out.println(s.getNom());
			}

		}	
		
	}
	
	
	public static void showFullFetchNotWorking() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT distinct p from Planete p LEFT JOIN fetch p.satellites s LEFT JOIN fetch p.asteroides a ",Planete.class);
		List<Planete> planetes = q.getResultList();
		em.close();

		for(Planete p : planetes) 
		{
			System.out.println("--------------------");
			System.out.println("infos de la planete : "+p.getLibelle());
			System.out.println("Liste des satellites :");
			for(Satellite s : p.getSatellites()) 
			{
				System.out.println(s.getNom());
			}
			
			System.out.println("Liste des asteroides :");
			for(Asteroide a : p.getAsteroides()) 
			{
				System.out.println(a);
			}

		}	
	
	}

	public static void showFullFetchWorking() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT distinct p from Planete p LEFT JOIN fetch p.satellites s",Planete.class);
		List<Planete> planetes = q.getResultList();

		q = em.createQuery("SELECT distinct p from Planete p LEFT JOIN fetch p.asteroides a",Planete.class);
		planetes = q.getResultList();
		
		
		em.close();
		
		for(Planete p : planetes) 
		{
			System.out.println("--------------------");
			System.out.println("infos de la planete : "+p.getLibelle());
			System.out.println("Liste des satellites :");
			for(Satellite s : p.getSatellites()) 
			{
				System.out.println(s.getNom());
			}
			
			System.out.println("Liste des asteroides :");
			for(Asteroide a : p.getAsteroides()) 
			{
				System.out.println(a);
			}
		}	
		
	}

	public static void main(String[] args) {

		Context.getInstance();

		showFullFetchWorking();

		Context.getInstance().closeEmf();

	}

}
