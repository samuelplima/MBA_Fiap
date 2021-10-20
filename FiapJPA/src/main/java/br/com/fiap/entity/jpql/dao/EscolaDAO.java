package br.com.fiap.entity.jpql.dao;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.jpql.escola.Escola;

public class EscolaDAO extends GenericJpqlDAO<Escola, Integer>{

	public EscolaDAO(EntityManager em) {
		super(em);
	}
	
	public List<Escola> listarDoisUltimos(){
		return this.em.createQuery("from Escola order by id desc", Escola.class).setMaxResults(2).
				getResultList();
	}
			
	public List<Escola> listarPorNome(String nome){
		return this.em.createQuery("select e from Escola e where e.nomeEscola like :nomeEscola", Escola.class)
				.setParameter("nomeEscola", "%" + nome + "%").getResultList();
	}
}
