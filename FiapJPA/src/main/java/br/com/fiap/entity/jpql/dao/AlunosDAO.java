package br.com.fiap.entity.jpql.dao;
import javax.persistence.EntityManager;

import br.com.fiap.entity.jpql.escola.Alunos;

public class AlunosDAO extends GenericJpqlDAO<Alunos, Integer>{

	public AlunosDAO(EntityManager em) {
		super(em);
	}
	
	public void excluirAlunos(int id) throws Exception {
		Alunos alunosId = this.em.find(Alunos.class, id);
		em.getTransaction().begin();
		if(alunosId == null) {
			throw new Exception("id nao existe");
		}
		else {
		em.createQuery("delete from Alunos e where e.id =:id")
		.setParameter("id", id).executeUpdate();
		}
		em.getTransaction().commit();
	}
	
	public void updateAlunos(String nome) throws Exception {
		em.getTransaction().begin();
		em.createQuery("update Alunos e set e.nome =:nome")
		.setParameter("nome", nome).executeUpdate();
		em.getTransaction().commit();
	}
	
}
