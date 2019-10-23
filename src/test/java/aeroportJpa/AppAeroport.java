package aeroportJpa;

import aeroportjpa.dao.DaoCompagnieAerienne;
import aeroportjpa.dao.DaoCompagnieAerienneFactory;
import aeroportjpa.model.CompagnieAerienne;

public class AppAeroport {
	public static void main(String[] args) {

		DaoCompagnieAerienne daoCompagnieAerienne = DaoCompagnieAerienneFactory.getInstance();
		CompagnieAerienne ca = new CompagnieAerienne();

		daoCompagnieAerienne.insert(ca);

		ca.setNomCompagnieAerienne("Air France");
		daoCompagnieAerienne.update(ca);

		CompagnieAerienne ca1 = new CompagnieAerienne();

		daoCompagnieAerienne.insert(ca1);

		ca1.setNomCompagnieAerienne("Air Austral");
		daoCompagnieAerienne.update(ca1);

//		daoCompagnieAerienne.delete(ca);
//
//		daoCompagnieAerienne.deleteByKey((long) 101);

		System.out.println(daoCompagnieAerienne.findByKey((long) 100));
		System.out.println(daoCompagnieAerienne.findAll());

//		DaoVol daoVol = DaoVolFactory.getInstance();
//		Vol v = new Vol();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
//
//		try {
//			v.setDateDepartVol(sdf.parse("24/10/2019"));
//		} catch (ParseException e) {
//
//			e.printStackTrace();
//		}
//
//		daoVol.insert(v);
//
//		try {
//			v.setDateArriveeVol(sdf.parse("25/10/2019"));
//		} catch (ParseException e) {
//
//			e.printStackTrace();
//		}
//
//		daoVol.update(v);
//
//		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
//
//		try {
//			v.setHeureArriveeVol(sdf1.parse("18:00"));
//		} catch (ParseException e) {
//
//			e.printStackTrace();
//		}
//
//		daoVol.update(v);
//
//		try {
//			v.setHeureDepartVol(sdf1.parse("07:00"));
//		} catch (ParseException e) {
//
//			e.printStackTrace();
//		}
//
//		daoVol.update(v);
//
//		try {
//			Vol v1 = new Vol(sdf.parse("24/10/2019"), sdf.parse("25/10/2019"), sdf1.parse("07:00"),
//					sdf1.parse("18:00"));
//			daoVol.insert(v1);
//		} catch (ParseException e) {
//			e.printStackTrace();
//
//		}
//
//		// daoVol.delete(v);
//
//		// daoVol.deleteByKey((long) 101);
//
//		System.out.println(daoVol.findByKey((long) 100));
//
//		System.out.println(daoVol.findAll());

	}
}
