package aeroportjpa.dao;

public class DaoVolFactory {
	private static DaoVol daoVol;

	public static DaoVol getInstance() {
		if (daoVol == null) {
			daoVol = new DaoVolJpaImpl();
		}
		return daoVol;
	}

}
