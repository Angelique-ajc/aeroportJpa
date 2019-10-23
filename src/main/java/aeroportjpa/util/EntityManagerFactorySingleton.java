package aeroportjpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static EntityManagerFactory emf = null;

	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("aeroportjpa");
		}
		return emf;
	}

	public static void close() {
		if (emf != null) {
			emf.close();
		}
	}
}
