package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOSatellite;
import model.Satellite;
import util.Context;

public class DAOSatellite implements IDAOSatellite{

	@Override
	public Satellite findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Satellite objet = em.find(Satellite.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Satellite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Satellite o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Satellite update(Satellite o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Satellite o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
