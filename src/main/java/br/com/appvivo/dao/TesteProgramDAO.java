package br.com.appvivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.appvivo.entities.ContaPF;
import br.com.appvivo.entities.ContaPJ;
import br.com.appvivo.entities.UserPF;
import br.com.appvivo.entities.UserPJ;
import br.com.appvivo.enuns.Planos;
import br.com.appvivo.enuns.Produtos;

public class TesteProgramDAO {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("app-vivo").createEntityManager();

		try {

			ContaPJ contaPJ = new ContaPJ();
			ContaPF contaPF = new ContaPF();
			UserPF userPF = new UserPF();
			UserPJ userPJ = new UserPJ();
			ContaPJDAO contaPJDAO = new ContaPJDAO(em);
			ContaPFDAO contaPFDAO = new ContaPFDAO(em);
			UserPFDAO userPFDAO = new UserPFDAO(em);
			UserPJDAO userPJDAO = new UserPJDAO(em);

			
			//cadastro userPF
			/////////////////////////
			userPF.setNome("joao");
			userPF.setCodigoCliente("4526");
			userPF.setCpf("3333333333");
			userPF.setSenha("8456");
			userPFDAO.salvar(userPF);
			userPFDAO.commit();

			//cadastro userPJ
			////////////////////////
			userPJ.setRazaoSocial("suelen MEI");
			userPJ.setCodigoCliente("5678");
			userPJ.setCnpj("4444444444");
			userPJ.setSenha("4596");
			userPJDAO.salvar(userPJ);
			userPJDAO.commit();

			//cadastro contaPF
			///////////////////////
			contaPF.setPlanos(Planos.PESSOAL);
			contaPF.setProdutos(Produtos.INTERNET);
			contaPFDAO.salvar(contaPF);
			contaPFDAO.commit();

			//cadastro contaPJ
			//////////////////////
			contaPJ.setPlanos(Planos.EMPRESARIAL);
			contaPJ.setProdutos(Produtos.INTERNET);
			contaPJDAO.salvar(contaPJ);
			contaPJDAO.commit();

			//cadastro conta_pf_id
			//////////////////////
			userPF.setContaPF(contaPF);
			userPFDAO.salvar(userPF);
			userPFDAO.commit();

			//cadastro conta_pj_id
			/////////////////////
			userPJ.setContaPJ(contaPJ);
			userPJDAO.salvar(userPJ);
			userPJDAO.commit();

			//////////////////////////////
			// lista userPF
			List<UserPF> listaUserPF = userPFDAO.listar();
			for (UserPF lista : listaUserPF) {
				System.out.println(lista.getNome());
			}
			System.out.println("--------------------------------------------------");

			//////////////////////////////
			// lista userPJ
			List<UserPJ> listaUserPJ = userPJDAO.listar();
			for (UserPJ lista : listaUserPJ) {
				System.out.println(lista.getRazaoSocial());
			}
			System.out.println("--------------------------------------------------");

			//////////////////////////////
			// lista contaPF
			List<ContaPF> listaContaPF = contaPFDAO.listar();
			for (ContaPF lista : listaContaPF) {
				System.out.println("Conta : "+lista.getPlanos() +" ,id : " + lista.getId());
			}
			System.out.println("--------------------------------------------------");

			//////////////////////////////
			// lista contaPJ
			List<ContaPJ> listaContaPJ = contaPJDAO.listar();
			for (ContaPJ lista : listaContaPJ) {
				System.out.println("Conta : "+lista.getPlanos() +" ,id : " + lista.getId());
			}
			System.out.println("--------------------------------------------------");

			////////////////////////////
			// atualiza userPF
			UserPF userPFUpdate = userPFDAO.recuperar(35);
			userPFUpdate.setNome("Ursinho TED");
			userPFDAO.commit();

			////////////////////////////
			// atualiza userPJ
			UserPJ userPJUpdate = userPJDAO.recuperar(36);
			userPJUpdate.setRazaoSocial("Jason matança ltda.");
			userPJDAO.commit();

			////////////////////////////
			// atualiza contaPF
			ContaPF contaPFUpdate = contaPFDAO.recuperar(25);
			contaPFUpdate.setProdutos(Produtos.TV);
			contaPFDAO.commit();

			////////////////////////////
			// atualiza contaPJ
			ContaPJ contaPJUpdate = contaPJDAO.recuperar(24);
			contaPJUpdate.setProdutos(Produtos.TELEFONE);
			userPJDAO.commit();
			
			////////////////////////////
			// encontra e exclui userPF do banco
			System.out.println(userPFDAO.recuperar(47).getNome() + ", id " + userPFDAO.recuperar(47).getId()+ " excluido!");
			userPFDAO.excluir(47);
			userPFDAO.commit();
			System.out.println("--------------------------------------------------");

			////////////////////////////
			// encontra e exclui userPJ do banco
			System.out.println(userPJDAO.recuperar(30).getRazaoSocial() + ", id " + userPJDAO.recuperar(30).getId()+ " excluido!");
			userPJDAO.excluir(30);
			userPJDAO.commit();
			System.out.println("--------------------------------------------------");

			////////////////////////////
			// encontra e exclui contaPF do banco
			System.out.println("Conta id : "+contaPFDAO.recuperar(31).getId() + " excluida!");
			contaPFDAO.excluir(31);
			contaPFDAO.commit();
			System.out.println("--------------------------------------------------");

			////////////////////////////
			// encontra e exclui contaPJ do banco
			System.out.println("Conta id : "+contaPJDAO.recuperar(24).getId() + " excluida!");
			contaPJDAO.excluir(24);
			contaPJDAO.commit();
			System.out.println("--------------------------------------------------");

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
