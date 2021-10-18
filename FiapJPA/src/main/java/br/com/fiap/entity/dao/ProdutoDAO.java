package br.com.fiap.entity.dao;
import javax.persistence.EntityManager;
import br.com.fiap.entity.produto.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Integer> {

	public ProdutoDAO(EntityManager em) {
		super(em);
	}

}
