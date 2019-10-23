package aeroportjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import aeroportjpa.model.Client;
import aeroportjpa.model.ClientEI;
import aeroportjpa.model.ClientMoral;
import aeroportjpa.model.ClientPhysique;
import aeroportjpa.util.EntityManagerFactorySingleton;

public class DaoClientImpl implements DaoClient {

	@Override
	public void insert(Client obj) {
		EntityManager em = null;
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Client update(Client obj) {
		Client c = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			c = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return c;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Client.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Client findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Client c = null;
		c = em.find(Client.class, key);
		em.close();
		return c;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Client> clients = null;
		Query query = em.createQuery("from Client c");
		clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public List<ClientPhysique> findAllClientPhysique() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<ClientPhysique> clientsphysiques = null;
		Query query = em.createNamedQuery("ClientPhysique.findAllClientPhysique");
		clientsphysiques = query.getResultList();
		em.close();
		return clientsphysiques;
	}

	@Override
	public List<ClientPhysique> findClientPhysiqueByVille(String ville) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<ClientPhysique> clientsphysiques = null;
		Query query = em.createNamedQuery("ClientPhysique.findClientPhysiqueByVille");
		query.setParameter("ville", ville);
		clientsphysiques = query.getResultList();
		em.close();
		return clientsphysiques;
	}

	@Override
	public List<ClientMoral> findAllClientMoral() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<ClientMoral> clientsmoraux = null;
		Query query = em.createNamedQuery("ClientMoral.findAllClientMoral");
		clientsmoraux = query.getResultList();
		em.close();
		return clientsmoraux;
	}

	@Override
	public List<ClientMoral> findClientMoralByVille(String ville) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<ClientMoral> clientsmoraux = null;
		Query query = em.createNamedQuery("ClientMoral.findClientMoralByVille");
		query.setParameter("ville", ville);
		clientsmoraux = query.getResultList();
		em.close();
		return clientsmoraux;
	}

	@Override
	public List<ClientEI> findAllClientEI() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<ClientEI> eiclients = null;
		Query query = em.createNamedQuery("ClientEI.findAllClientEI");
		eiclients = query.getResultList();
		em.close();
		return eiclients;
	}

	@Override
	public List<ClientEI> findClientEIByVille(String ville) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<ClientEI> eiclients = null;
		Query query = em.createNamedQuery("ClientEI.findClientEIByVille");
		query.setParameter("ville", ville);
		eiclients = query.getResultList();
		em.close();
		return eiclients;
	}

}
