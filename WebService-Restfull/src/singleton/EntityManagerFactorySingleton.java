package singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//Atributo est�tico
	private static EntityManagerFactory emf;
	
	//Construtor privado
	private EntityManagerFactorySingleton(){}
	
	//M�todo getInstance
	public static EntityManagerFactory getInstance(){
		if (emf == null){
			emf = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}
	
}




