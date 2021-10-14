package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOSysteme;
import model.Systeme;
import util.Context;

public class DAOSysteme implements IDAOSysteme{

	@Override
	public Systeme findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Systeme objet = em.find(Systeme.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Systeme> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Systeme o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Systeme update(Systeme o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Systeme o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
