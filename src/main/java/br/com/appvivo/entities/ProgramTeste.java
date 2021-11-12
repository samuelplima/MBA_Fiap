package br.com.appvivo.entities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.appvivo.enuns.Planos;
import br.com.appvivo.enuns.Produtos;

public class ProgramTeste {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("app-vivo").createEntityManager();

			UserPF userPf = new UserPF();
			UserPJ userPj = new UserPJ();
			ContaPF contaPF = new ContaPF();
			ContaPJ contaPJ = new ContaPJ();

			em.getTransaction().begin();

			/////////////////////////
			userPf.setNome("joao");
			userPf.setCodigoCliente("4526");
			userPf.setCpf("3333333333");
			userPf.setSenha("8456");

			////////////////////////
			userPj.setRazaoSocial("suelen MEI");
			userPj.setCodigoCliente("5678");
			userPj.setCnpj("4444444444");
			userPj.setSenha("4596");

			///////////////////////
			contaPF.setPlanos(Planos.PESSOAL);
			contaPF.setProdutos(Produtos.INTERNET);

			//////////////////////
			contaPJ.setPlanos(Planos.EMPRESARIAL);			
			contaPJ.setProdutos(Produtos.INTERNET);

			
			//////////////////////
			userPj.setContaPJ(contaPJ);
			
			/////////////////////
			userPf.setContaPF(contaPF);

			
			/////////////////////
			contaPF.validaConta(contaPF.getPlanos().toString());
			
			////////////////////
			contaPJ.validaConta(contaPJ.getPlanos().toString());			

			
			/////////////////////
			userPf.validaCpfCnPJ(userPf.getCpf());
			
			/////////////////////
			userPj.validaCpfCnPJ(userPj.getCnpj());	
			System.out.println("------------------------------------------");
			
			////////////////////
			em.persist(userPf);
//			em.refresh(userPf);
			em.persist(userPj);
//			em.refresh(userPj);
			em.persist(contaPJ);
//			em.refresh(contaPJ);
			em.persist(contaPF);
//			em.refresh(contaPF);
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
