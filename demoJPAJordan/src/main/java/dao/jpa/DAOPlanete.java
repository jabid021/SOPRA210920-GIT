package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOPlanete;
import model.Planete;
import util.Context;

public class DAOPlanete implements IDAOPlanete{

	@Override
	public Planete findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Planete objet = em.find(Planete.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Planete> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Planete save(Planete o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Planete o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Planete> findByLibelleLike(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

}
