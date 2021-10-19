package br.com.fiap.entity.pessoa.heranca;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Program {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("FiapJPA").createEntityManager();
			
			PessoaFisica cpf = new PessoaFisica();
			cpf.setCpf("987654321");
			cpf.setNome("Samuel Lima");
			
			PessoaJuridica cnpj = new PessoaJuridica();
			cnpj.setNome("SL automação ltda.");
			cnpj.setCnpj("14731645/0001");
			cnpj.setInscr_Estadual("123456789-9");
			
			em.persist(cpf);
			em.persist(cnpj);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
			

		} catch (Exception e) {

			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();

		}

		if (em != null) {
			em.close();
		}
		System.exit(0);

	}

}
