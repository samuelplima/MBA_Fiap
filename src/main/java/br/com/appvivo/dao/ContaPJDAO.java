package br.com.appvivo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.appvivo.entities.ContaPJ;
import br.com.appvivo.entities.UserPJ;
import br.com.appvivo.enuns.Produtos;

public class ContaPJDAO extends GenericDAO<ContaPJ, Integer> {
	
	Produtos produtos;

	public ContaPJDAO(EntityManager em) {
		super(em);
	}

	public List<UserPJ> filtrarPorProduto(Produtos produtos) {
		if (produtos.TELEFONE_FIXO == this.produtos.TELEFONE_FIXO) {
			return em.createNativeQuery(
					"SELECT tb_user_pj.id FROM conta_pj," + " tb_user_pj WHERE conta_pj.produtos = 'TELEFONE_FIXO' AND"
							+ " conta_pj.id = tb_user_pj.conta_pj_id",
					UserPJ.class).getResultList();
		}
		else {
			return em.createNativeQuery(
					"SELECT tb_user_pj.id FROM conta_pj," + " tb_user_pj WHERE conta_pj.produtos <> 'TELEFONE_FIXO' AND"
							+ " conta_pj.id = tb_user_pj.conta_pj_id",
					UserPJ.class).getResultList();
		}
	}
}
