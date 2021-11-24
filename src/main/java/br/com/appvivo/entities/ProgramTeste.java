package br.com.appvivo.entities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.appvivo.enuns.Planos;
import br.com.appvivo.enuns.Produtos;
import br.com.appvivo.enuns.UF;

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
			userPf.setBairro("abcdefg");
			userPf.setCep("123456789");
			userPf.setCidade("campinas");
			userPf.setEmail("agshsd@gmail.com");
			userPf.setRua("agaagagagag");
			userPf.setUf(UF.SP);
			
			////////////////////////
			userPj.setRazaoSocial("suelen MEI");
			userPj.setCodigoCliente("5678");
			userPj.setCnpj("4444444444");
			userPj.setSenha("4596");
			userPj.setBairro("abcdefg");
			userPj.setCep("123456789");
			userPj.setCidade("campinas");
			userPj.setEmail("agshsd@gmail.com");
			userPj.setRua("agaagagagag");
			userPj.setUf(UF.MG);

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
			em.persist(userPj);
			em.persist(contaPJ);
			em.persist(contaPF);
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
