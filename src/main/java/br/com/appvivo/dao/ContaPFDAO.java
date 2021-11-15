package br.com.appvivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.appvivo.entities.ContaPF;
import br.com.appvivo.entities.UserPF;
import br.com.appvivo.enuns.Produtos;

public class ContaPFDAO extends GenericDAO<ContaPF, Integer> {

	public ContaPFDAO(EntityManager em) {
		super(em);
	}

	public List<UserPF> filtrarPorProduto(Produtos produtos) {
		if (produtos.toString() == "TELEFONE_FIXO")
			return em.createNativeQuery(
					"SELECT tb_user_pf.id FROM conta_pf," + " tb_user_pf WHERE conta_pf.produtos = 'TELEFONE_FIXO' AND"
							+ " conta_pf.id = tb_user_pf.conta_pf_id",
					UserPF.class).getResultList();
		else {
			return em.createNativeQuery(
					"SELECT tb_user_pf.id FROM conta_pf," + " tb_user_pf WHERE conta_pf.produtos <> 'TELEFONE_FIXO' AND"
							+ " conta_pf.id = tb_user_pf.conta_pf_id",
					UserPF.class).getResultList();
		}
	}
}