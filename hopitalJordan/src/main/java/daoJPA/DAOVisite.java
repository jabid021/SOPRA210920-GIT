package daoJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOVisite;
import model.Compte;
import model.Visite;
import util.Context;

public class DAOVisite implements IDAOVisite{

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Visite objet = em.find(Visite.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Visite v",Visite.class);
		List<Visite> visites = requete.getResultList();
		em.close();
		return visites;
	}


	@Override
	public Visite save(Visite o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Visite o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Visite> findAllByIdPatient(int idPatient) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query requete = em.createQuery("Select v from Visite v where v.patient.id=:id",Visite.class);
		requete.setParameter("id", idPatient);
		List<Visite> visites = requete.getResultList();
		em.close();
		return visites;
	}

}
