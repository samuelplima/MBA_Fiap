package br.com.fiap.entity.dao;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.produto.Fornecedor;

public class FornecedorDAO extends GenericDAO<Fornecedor, Integer>{

	public FornecedorDAO(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Fornecedor> listar(){
		return this.em.createQuery("from Fornecedor order by codigo desc", Fornecedor.class).getResultList();
	}
	
}
