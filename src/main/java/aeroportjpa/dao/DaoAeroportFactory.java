package aeroportjpa.dao;

public class DaoAeroportFactory {
	private static DaoAeroport daoAeroport = null;

	public static DaoAeroport getInstance() {
		if (daoAeroport == null) {
			daoAeroport = new DaoAeroportImp();
		}
		return daoAeroport;
	}

}
