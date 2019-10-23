package aeroportjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import aeroportjpa.model.Aeroport;
import aeroportjpa.util.EntityManagerFactorySingleton;

class DaoAeroportImp implements DaoAeroport {

	@Override
	public void insert(Aeroport obj) {
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
	public Aeroport update(Aeroport obj) {
		Aeroport a = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			a = em.merge(obj);
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
		return a;
	}

	@Override
	public void delete(Aeroport obj) {
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
			em.remove(em.find(Aeroport.class, key));
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
	public Aeroport findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Aeroport a = null;
		a = em.find(Aeroport.class, key);
		em.close();
		return a;
	}

	@Override
	public List<Aeroport> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Aeroport> aeroports = null;
		Query query = em.createQuery("select a from Aeroport a");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

	public Aeroport findByKeyWithVilles(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Aeroport a = null;
		Query query = em.createNamedQuery("Aeroport.findByKeyWithVilles");
		query.setParameter("id", key);
		a = (Aeroport) query.getSingleResult();
		em.close();
		return a;
	}

	public List<Aeroport> findAllWithVilles() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Aeroport> aeroports = null;
		Query query = em.createNamedQuery("Aeroport.findAllWithVilles");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

}
