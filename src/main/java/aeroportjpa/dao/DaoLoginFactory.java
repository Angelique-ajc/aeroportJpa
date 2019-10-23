package aeroportjpa.dao;

public class DaoLoginFactory {
	private static DaoLogin daoLogin = null;

	public static DaoLogin getInstance() {
		if (daoLogin == null) {
			daoLogin = new DaoLoginImpl();
		}
		return daoLogin;
	}
}
