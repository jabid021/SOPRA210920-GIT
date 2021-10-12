package util;

import java.util.LinkedList;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import daoJDBC.DAOCompteJDBC;
import daoJDBC.DAOPatientJDBC;
import daoJDBC.DAOVisiteJDBC;
import model.Compte;
import model.Patient;

public class Context {


	private LinkedList<Patient> fileAttente = new LinkedList();
	private IDAOCompte daoC = new DAOCompteJDBC();
	private IDAOPatient daoP = new DAOPatientJDBC();
	private IDAOVisite daoV = new DAOVisiteJDBC();
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
	
	
	
	
	
}
