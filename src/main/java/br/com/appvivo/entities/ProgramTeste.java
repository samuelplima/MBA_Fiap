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
			userPf.setNome("maria");
			userPf.setCodigoCliente("5678");
			userPf.setCpf("22222222222");
			userPf.setSenha("4321");

			////////////////////////
			userPj.setRazaoSocial("samuel MEI");
			userPj.setCodigoCliente("5678");
			userPj.setCnpj("11111111111111");
			userPj.setSenha("9876");

			///////////////////////
			contaPF.setPlanos(Planos.PESSOAL);
			contaPF.setProdutos(Produtos.INTERNET);

			//////////////////////
			contaPJ.setPlanos(Planos.EMPRESARIAL);
			contaPJ.setProdutos(Produtos.TELEFONE);
			
			//////////////////////
			contaPJ.setUserPJ(userPj);
			
			/////////////////////
			contaPF.setUserPF(userPf);;
			
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
