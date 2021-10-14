package daoJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOCompte;
import model.Compte;
import util.Context;

public class DAOCompte implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Compte objet = em.find(Compte.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Compte c",Compte.class);
		List<Compte> comptes = requete.getResultList();
		em.close();
		return comptes;
	}


	@Override
	public Compte save(Compte o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Compte o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Compte connect(String login, String password) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query requeteConnect = em.createQuery("Select c from Compte c where c.login=:login and c.password=:password",Compte.class);
		requeteConnect.setParameter("login", login);
		requeteConnect.setParameter("password", password);
		Compte connected=null;

		try {
			connected =  (Compte) requeteConnect.getSingleResult();
		}
		catch(Exception e) {}

		return connected;
	}

}
