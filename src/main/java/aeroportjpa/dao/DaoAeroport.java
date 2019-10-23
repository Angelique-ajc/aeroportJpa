package aeroportjpa.dao;

import java.util.List;

import aeroportjpa.model.Aeroport;

public interface DaoAeroport extends DaoGeneric<Aeroport, Long> {
	public Aeroport findByKeyWithVilles(Long key);

	public List<Aeroport> findAllWithVilles();
}
