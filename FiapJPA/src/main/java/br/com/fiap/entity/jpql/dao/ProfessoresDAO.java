package br.com.fiap.entity.jpql.dao;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.jpql.escola.Professores;

public class ProfessoresDAO extends GenericJpqlDAO<Professores, Integer>{

	public ProfessoresDAO(EntityManager em) {
		super(em);
	}
	
	public List<Professores> listarOrdenadoNome(){
		return this.em.createQuery("from Professores order by nomeProfessor", Professores.class)
				.getResultList();
	}
	
	public List<Professores> listarOrdenadoId(){
		return this.em.createQuery("from Professores order by id desc", Professores.class)
				.getResultList();
	}

}
