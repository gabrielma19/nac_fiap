package dao;

import java.util.List;

import entity.Aluguel;

public interface AluguelDAO extends GenericDAO<Aluguel, Integer>{

	List<Aluguel> listar();
	
}