package br.com.appvivo.dao;

import javax.persistence.EntityManager;
import br.com.appvivo.entities.ContaPJ;

public class ContaPJDAO extends GenericDAO<ContaPJ, Integer>{

	public ContaPJDAO(EntityManager em) {
		super(em);
	}
}
