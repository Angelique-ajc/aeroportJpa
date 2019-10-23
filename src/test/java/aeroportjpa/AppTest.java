package aeroportjpa;

import aeroportjpa.dao.DaoClient;
import aeroportjpa.dao.DaoClientFactory;
import aeroportjpa.dao.DaoLogin;
import aeroportjpa.dao.DaoLoginFactory;
import aeroportjpa.model.Adresse;
import aeroportjpa.model.ClientEI;
import aeroportjpa.model.ClientMoral;
import aeroportjpa.model.ClientPhysique;
import aeroportjpa.model.Login;
import aeroportjpa.util.EntityManagerFactorySingleton;

public class AppTest {
	public static void main(String[] args) {
		EntityManagerFactorySingleton.getInstance();
		//-------------------------------------------------------------------------//
		
		DaoClient daoClient = DaoClientFactory.getInstance();
		
		ClientPhysique cp1 = new ClientPhysique();
		cp1.setNomClient("compote");
		daoClient.insert(cp1);
		cp1.setPrenomCP("pomme");
		cp1.setEmail("blablabla@blablabla");
		cp1.setAdresse(new Adresse(10, "rue R","paris","75001"));
		cp1 = (ClientPhysique) daoClient.update(cp1);
		//System.out.println(daoClient.findAllClientPhysique());
		//System.out.println(daoClient.findClientPhysiqueByVille("paris"));

		ClientMoral cm1 = new ClientMoral();
		cm1.setNomClient("tartare");
		daoClient.insert(cm1);
		cm1.setSiret("sssssssssssssss");
		cm1.setAdresse(new Adresse("Londres"));
		cm1 = (ClientMoral) daoClient.update(cm1);
		//System.out.println(daoClient.findAllClientMoral());
		//System.out.println(daoClient.findClientMoralByVille("londres"));
		
		ClientEI cei1 = new ClientEI();
		cei1.setNomClient("nom");
		daoClient.insert(cei1);
		cei1.setAdresse(new Adresse(11, "rue R1","paris","75002"));
		cei1 = (ClientEI) daoClient.update(cei1);
		//System.out.println(daoClient.findAllClientEI());
		//System.out.println(daoClient.findClientEIByVille("paris"));
		
		DaoLogin daoLogin = DaoLoginFactory.getInstance();
		
		Login login1 = new Login();
		login1.setLogin("iamlogin1");
		daoLogin.insert(login1);
		cei1.setLogin(login1);
		login1 = daoLogin.update(login1);
		cei1 = (ClientEI) daoClient.update(cei1);
		//-------------------------------------------------------------------------//
		EntityManagerFactorySingleton.close();
	}
}
