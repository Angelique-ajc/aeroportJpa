package aeroportjpa.dao;

import java.util.List;

import aeroportjpa.model.Ville;

public interface DaoVille extends DaoGeneric<Ville, Long> {
	public Ville findByKeyWithAeroports(Long key);

	public List<Ville> findAllWithAeroports();
}
