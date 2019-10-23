package aeroportjpa.dao;

import java.util.List;

import aeroportjpa.model.Client;
import aeroportjpa.model.ClientEI;
import aeroportjpa.model.ClientMoral;
import aeroportjpa.model.ClientPhysique;

public interface DaoClient extends DaoGeneric<Client, Long> {
	List<ClientPhysique> findAllClientPhysique();

	List<ClientMoral> findAllClientMoral();

	List<ClientEI> findAllClientEI();

	public List<ClientPhysique> findClientPhysiqueByVille(String ville);

	public List<ClientMoral> findClientMoralByVille(String ville);
	
	public List<ClientEI> findClientEIByVille(String ville);
}
