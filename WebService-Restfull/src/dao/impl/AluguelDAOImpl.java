package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.AluguelDAO;
import entity.Aluguel;

public class AluguelDAOImpl extends GenericDAOImpl<Aluguel, Integer> implements AluguelDAO{

	public AluguelDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Aluguel> listar() {
<<<<<<< HEAD:WebService-Restfull/src/dao/impl/AluguelDAOImpl.java
		return em.createQuery("from Aluguel",Aluguel.class).getResultList();
=======
		return em.createQuery("from Aluguel" ,Aluguel.class).getResultList();
>>>>>>> e2905d75e3a32647d843c9c24cbc8f3aaa74e4c1:WebServiceRestfull-Server-Nac/src/dao/impl/AluguelDAOImpl.java
	}

}





