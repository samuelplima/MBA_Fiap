package br.com.fiap.entity.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<E, C> {

	protected Class<E> classeEntidade;

	protected EntityManager em;

	public GenericDAO(EntityManager em) {
		this.em = em;
		this.classeEntidade = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(E entidade) {
		this.em.persist(entidade);
	}

	public E recuperar(C chave) throws Exception {
		if(chave == null) {
			throw new Exception("Chave não encontrada");			
		}
		return this.em.find(classeEntidade, chave);
	}

	public List<E> listar() {
		return em.createQuery("from " + classeEntidade.getName()).getResultList();
	}

	public void excluir(C chave) throws Exception {
		E entidadeExcluir = this.recuperar(chave);

		if (entidadeExcluir == null) {
			throw new IllegalArgumentException(
					"Nenhum registro de " + this.classeEntidade.getSimpleName() + "encontrado para a chave " + chave);
		}

		this.em.remove(entidadeExcluir);
	}
	
	public void commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new Exception("Erro no commit");				
			}
		}
	}

}
