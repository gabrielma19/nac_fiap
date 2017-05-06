package singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//Atributo estático
	private static EntityManagerFactory emf;
	
	//Construtor privado
	private EntityManagerFactorySingleton(){}
	
	//Método getInstance
	public static EntityManagerFactory getInstance(){
		if (emf == null){
			emf = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}
	
}




