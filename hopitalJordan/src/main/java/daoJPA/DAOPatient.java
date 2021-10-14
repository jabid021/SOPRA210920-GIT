package daoJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOPatient;
import model.Patient;
import util.Context;

public class DAOPatient implements IDAOPatient{

	@Override
	public Patient findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Patient objet = em.find(Patient.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Patient> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Patient p",Patient.class);
		List<Patient> patients = requete.getResultList();
		em.close();
		return patients;
	}


	@Override
	public Patient save(Patient o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Patient o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
