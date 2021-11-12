package br.com.appvivo.dao;

import javax.persistence.EntityManager;
import br.com.appvivo.entities.UserPJ;

public class UserPJDAO extends GenericDAO<UserPJ, Integer>{

	public UserPJDAO(EntityManager em) {
		super(em);
	}

}
