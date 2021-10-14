package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOATM;
import dao.IDAOAsteroide;
import dao.IDAOPlanete;
import dao.IDAOSatellite;
import dao.IDAOSysteme;
import dao.jpa.DAOATM;
import dao.jpa.DAOAsteroide;
import dao.jpa.DAOPlanete;
import dao.jpa.DAOSatellite;
import dao.jpa.DAOSysteme;


public class Context {



	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private IDAOPlanete daoPlanete = new DAOPlanete();
	private IDAOSatellite daoSatellite=new DAOSatellite();
	private IDAOSysteme daoSysteme=new DAOSysteme();
	private IDAOATM daoAtm=new DAOATM();
	private IDAOAsteroide daoAsteroide = new DAOAsteroide();
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



	public EntityManagerFactory getEmf() {
		return emf;
	}

	

	public IDAOPlanete getDaoPlanete() {
		return daoPlanete;
	}



	public IDAOSatellite getDaoSatellite() {
		return daoSatellite;
	}



	public IDAOSysteme getDaoSysteme() {
		return daoSysteme;
	}



	public IDAOATM getDaoAtm() {
		return daoAtm;
	}



	public IDAOAsteroide getDaoAsteroide() {
		return daoAsteroide;
	}



	public void closeEmf() 
	{
		this.emf.close();
	}

	
	
	
	
}
