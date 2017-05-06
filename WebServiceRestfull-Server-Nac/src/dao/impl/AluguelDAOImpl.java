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
		return em.createQuery("from Aluguel" ,Aluguel.class).getResultList();
	}

}





