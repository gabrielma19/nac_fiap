package dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import dao.GenericDAO;
import exception.CodigoInvalidoException;
import exception.CommitErrorException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void excluir(K codigo) throws CodigoInvalidoException {
		T entidade = buscar(codigo);
		if (entidade == null){
			throw new CodigoInvalidoException("C�digo inv�lido");
		}
		em.remove(entidade);
	}

	@Override
	public T buscar(K codigo) {
		return em.find(clazz, codigo);
	}

	@Override
	public void commit() throws CommitErrorException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitErrorException("Erro no commit");
		}
	}

	
	
}
