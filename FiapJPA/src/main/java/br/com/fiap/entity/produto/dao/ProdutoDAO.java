package br.com.fiap.entity.produto.dao;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.produto.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Integer> {

	public ProdutoDAO(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Produto> listar(){
		return this.em.createQuery("from Produto order by id desc", Produto.class).getResultList();
	}

}
