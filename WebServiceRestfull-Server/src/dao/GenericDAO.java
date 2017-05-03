package dao;

import exception.CodigoInvalidoException;
import exception.CommitErrorException;

public interface GenericDAO<T,K> {

	void cadastrar(T entidade);
	void atualizar(T entidade);
	void excluir(K codigo) throws CodigoInvalidoException;
	T buscar(K codigo);
	void commit() throws CommitErrorException;
	
}
