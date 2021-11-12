package br.com.appvivo.dao;

import javax.persistence.EntityManager;
import br.com.appvivo.entities.ContaPF;

public class ContaPFDAO extends GenericDAO<ContaPF,Integer>{

	public ContaPFDAO(EntityManager em) {
		super(em);
	}
}