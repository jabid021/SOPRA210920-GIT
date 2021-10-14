package dao;

import java.util.List;

import model.Planete;

public interface IDAOPlanete extends IDAO<Planete,Integer> {

	
	public List<Planete> findByLibelleLike(String libelle);
}
