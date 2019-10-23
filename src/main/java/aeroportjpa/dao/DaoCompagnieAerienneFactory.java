package aeroportjpa.dao;

public class DaoCompagnieAerienneFactory {

	private static DaoCompagnieAerienne daoCompagnieAerienne;

	public static DaoCompagnieAerienne getInstance() {
		if (daoCompagnieAerienne == null) {
			daoCompagnieAerienne = new DaoCompagnieAerienneJpaImpl();
		}
		return daoCompagnieAerienne;
	}

}