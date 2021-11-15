package br.com.appvivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.appvivo.entities.UserPJ;
import br.com.appvivo.enuns.Produtos;

public class UserPJDAO extends GenericDAO<UserPJ, Integer>{

	public UserPJDAO(EntityManager em) {
		super(em);
	}
}
