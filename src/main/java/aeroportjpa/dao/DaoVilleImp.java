package aeroportjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import aeroportjpa.model.Ville;
import aeroportjpa.util.EntityManagerFactorySingleton;

class DaoVilleImp implements DaoVille {

	@Override
	public void insert(Ville obj) {
		EntityManager em = null;
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			// affichage de la gestion de l'erreur
			e.printStackTrace();
			// si on a une transaction et qu'elle est active
			if (tx != null && tx.isActive()) {
				// je l'annule
				tx.rollback();
			}
		} finally {
			// si l'EntityManager existe et est toujours ouvert
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public Ville update(Ville obj) {
		Ville v = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			v = em.merge(obj);
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
		return v;
	}

	@Override
	public void delete(Ville obj) {
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
			em.remove(em.find(Ville.class, key));
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
	public Ville findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Ville v = null;
		v = em.find(Ville.class, key);
		em.close();
		return v;
	}

	@Override
	public List<Ville> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Ville> villes = null;
		Query query = em.createQuery("select v from Ville v");
		villes = query.getResultList();
		em.close();
		return villes;
	}

	// ressort la ville avec l'id "key" avec tous ses aéroports
	public Ville findByKeyWithAeroports(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Ville v = null;
		Query query = em.createNamedQuery("Ville.findByKeyWithAeroports");
		query.setParameter("id", key);
		v = (Ville) query.getSingleResult();
		em.close();
		return v;
	}

	// ressort toutes les villes avec leurs aéroports
	public List<Ville> findAllWithAeroports() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Ville> villes = null;
		Query query = em.createNamedQuery("Ville.findAllWithAeroports");
		villes = query.getResultList();
		em.close();
		return villes;
	}

}
