package aeroportjpa.dao;

public class DaoClientFactory {
	private static DaoClient daoClient = null;

	public static DaoClient getInstance() {
		if (daoClient == null) {
			daoClient = new DaoClientImpl();
		}
		return daoClient;
	}
}
