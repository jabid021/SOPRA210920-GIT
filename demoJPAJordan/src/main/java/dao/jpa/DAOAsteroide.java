package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOAsteroide;
import model.Asteroide;
import util.Context;

public class DAOAsteroide implements IDAOAsteroide{

	@Override
	public Asteroide findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Asteroide objet = em.find(Asteroide.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Asteroide> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Asteroide save(Asteroide o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Asteroide o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
