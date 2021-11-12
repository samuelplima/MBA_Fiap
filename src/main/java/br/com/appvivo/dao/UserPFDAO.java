package br.com.appvivo.dao;

import javax.persistence.EntityManager;
import br.com.appvivo.entities.UserPF;

public class UserPFDAO extends GenericDAO<UserPF, Integer>{

	public UserPFDAO(EntityManager em) {
		super(em);
	}
}
