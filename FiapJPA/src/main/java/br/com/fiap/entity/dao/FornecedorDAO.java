package br.com.fiap.entity.dao;
import javax.persistence.EntityManager;
import br.com.fiap.entity.produto.Fornecedor;

public class FornecedorDAO extends GenericDAO<Fornecedor, Integer>{

	public FornecedorDAO(EntityManager em) {
		super(em);
	}
	
}
