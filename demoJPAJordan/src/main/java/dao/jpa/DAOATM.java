package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOATM;
import model.ATM;
import util.Context;

public class DAOATM implements IDAOATM{

	@Override
	public ATM findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		ATM objet = em.find(ATM.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<ATM> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ATM save(ATM o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(ATM o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
