package util;

import java.util.LinkedList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import daoJPA.DAOCompte;
import daoJPA.DAOPatient;
import daoJPA.DAOVisite;
import model.Compte;
import model.Patient;

public class Context {


	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private LinkedList<Patient> fileAttente = new LinkedList();
	private IDAOCompte daoC = new DAOCompte();
	private IDAOPatient daoP = new DAOPatient();
	private IDAOVisite daoV = new DAOVisite();
	private Compte connected;
	private boolean enPause = false;
	
	
	//SINGLETON
	private static Context _instance;
	
	
	private Context() {}
	
	
	
	public static Context getInstance() 
	{
		if(_instance==null)
		{_instance=new Context();}
		
		return _instance;
	}
	//FIN SINGLETON



	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}



	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}




	public IDAOCompte getDaoC() {
		return daoC;
	}



	public IDAOPatient getDaoP() {
		return daoP;
	}



	public IDAOVisite getDaoV() {
		return daoV;
	}



	public Compte getConnected() {
		return connected;
	}



	public void setConnected(Compte connected) {
		this.connected = connected;
	}



	public boolean isEnPause() {
		return enPause;
	}



	public void setEnPause(boolean enPause) {
		this.enPause = enPause;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public void closeEmf() 
	{
		this.emf.close();
	}
	
	
	
}
