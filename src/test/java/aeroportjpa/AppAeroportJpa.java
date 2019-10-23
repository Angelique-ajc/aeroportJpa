package aeroportjpa;

import aeroportjpa.dao.DaoAeroport;
import aeroportjpa.dao.DaoAeroportFactory;
import aeroportjpa.dao.DaoVille;
import aeroportjpa.dao.DaoVilleFactory;
import aeroportjpa.model.Aeroport;
import aeroportjpa.model.Ville;

public class AppAeroportJpa {

	public static void main(String[] args) {
		DaoAeroport daoAeroport = DaoAeroportFactory.getInstance();
		// on crée un aéroport
		Aeroport a = new Aeroport();
		a.setNomAeroport("Venise");
		daoAeroport.insert(a);

		Aeroport a1 = new Aeroport("Aeroport Paris");
		daoAeroport.insert(a1);

		System.out.println(daoAeroport.findByKey((long) 1));
		System.out.println(daoAeroport.findAll());

		DaoVille daoVille = DaoVilleFactory.getInstance();
		// on crée une ville
		Ville v = new Ville("Tokyo");
		daoVille.insert(v);

		Ville v1 = new Ville("Châlons");
		daoVille.insert(v1);

		System.out.println(daoVille.findByKey((long) 1));
		System.out.println(daoVille.findAll());

		a.setVilleAeroport(v);
		daoAeroport.update(a);

		a1.setVilleAeroport(v);
		daoAeroport.update(a1);

		Aeroport aero = daoAeroport.findByKeyWithVilles((long) 1);
		// List<Aeroport> aero = daoAeroport.findAllWithVilles();
		System.out.println(aero.getVilleAeroport());

		// ressort la liste des aéroports qu'il y a dans la ville
		// Ville ville = daoVille.findByKeyWithAeroports((long) 1);
		// System.out.println(ville.getAeroports());

	}

}
