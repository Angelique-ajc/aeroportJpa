package aeroportjpa.dao;

public class DaoVilleFactory {
	private static DaoVille daoVille = null;

	public static DaoVille getInstance() {
		if (daoVille == null) {
			daoVille = new DaoVilleImp();
		}
		return daoVille;
	}
}
