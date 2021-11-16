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
import br.com.appvivo.enuns.UF;

public class ProgramTesteDAO {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("app-vivo").createEntityManager();

		try {

			//instanciação
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
			userPF.setNome("Ursinho TED");
			userPF.setCodigoCliente("4526");
			userPF.setCpf("3333333333");
			userPF.setSenha("8456");
			userPF.setBairro("abcde");
			userPF.setCep("123456");
			userPF.setCidade("abcdeh");
			userPF.setEmail("abdgeeh@gmail.com");
			userPF.setRua("avenida abdefgh");
			userPF.setUf(UF.MG);
			userPFDAO.salvar(userPF);			
			userPFDAO.commit();

			//cadastro userPJ
			////////////////////////
			userPJ.setRazaoSocial("Dona Florinda MEI");
			userPJ.setCodigoCliente("5678");
			userPJ.setCnpj("4444444444");
			userPJ.setSenha("4596");
			userPJ.setBairro("abcde");
			userPJ.setCep("123456");
			userPJ.setCidade("abcdeh");
			userPJ.setEmail("abdgeeh@gmail.com");
			userPJ.setRua("avenida abdefgh");
			userPJ.setUf(UF.AC);
			userPJDAO.salvar(userPJ);
			userPJDAO.commit();

			//cadastro contaPF
			///////////////////////
			contaPF.setPlanos(Planos.PESSOAL);
			contaPF.setProdutos(Produtos.TELEFONE_MOVEL);
			contaPFDAO.salvar(contaPF);
			contaPFDAO.commit();

			//cadastro contaPJ
			//////////////////////
			contaPJ.setPlanos(Planos.EMPRESARIAL);
			contaPJ.setProdutos(Produtos.TELEFONE_FIXO);
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


 			/////////////////////////////
 			//lista por fixo ou movel ContaPF
 			List<UserPF> listaContaPFFixo = contaPFDAO.filtrarPorProduto(Produtos.TELEFONE_FIXO);
			for (UserPF lista : listaContaPFFixo) {
				System.out.println(lista.getNome());
			}
			System.out.println("--------------------------------------------------");
			List<UserPF> listaContaPFMovel = contaPFDAO.filtrarPorProduto(Produtos.TELEFONE_MOVEL);
			for (UserPF lista : listaContaPFMovel) {
				System.out.println(lista.getNome());
			}
			System.out.println("--------------------------------------------------");
			
 			/////////////////////////////
 			//lista por fixo ou movel ContaPJ
 			List<UserPJ> listaContaPJFixo = contaPJDAO.filtrarPorProduto(Produtos.TELEFONE_FIXO);
			for (UserPJ lista : listaContaPJFixo) {
				System.out.println(lista.getRazaoSocial());
			}
			System.out.println("--------------------------------------------------");
			List<UserPJ> listaContaPJMovel = contaPJDAO.filtrarPorProduto(Produtos.TELEFONE_MOVEL);
			for (UserPJ lista : listaContaPJMovel) {
				System.out.println(lista.getRazaoSocial());
			}
			System.out.println("--------------------------------------------------");
 			
 			
/* 			
			////////////////////////////
			// atualiza userPF
			UserPF userPFUpdate = userPFDAO.recuperar(3);
			userPFUpdate.setNome("Ursinho TED");
			userPFDAO.commit();

			////////////////////////////
			// atualiza userPJ
			UserPJ userPJUpdate = userPJDAO.recuperar(2);
			userPJUpdate.setRazaoSocial("Jason matança ltda.");
			userPJDAO.commit();

			////////////////////////////
			// atualiza contaPF
			ContaPF contaPFUpdate = contaPFDAO.recuperar(1);
			contaPFUpdate.setProdutos(Produtos.TV);
			contaPFDAO.commit();

			////////////////////////////
			// atualiza contaPJ
			ContaPJ contaPJUpdate = contaPJDAO.recuperar(2);
			contaPJUpdate.setProdutos(Produtos.TELEFONE_FIXO);
			userPJDAO.commit();
			
			////////////////////////////
			// encontra e exclui userPF do banco
			System.out.println(userPFDAO.recuperar(1).getNome() + ", id " + userPFDAO.recuperar(1).getId()+ " excluido!");
			userPFDAO.excluir(1);
			userPFDAO.commit();
			System.out.println("--------------------------------------------------");

			////////////////////////////
			// encontra e exclui userPJ do banco
			System.out.println(userPJDAO.recuperar(2).getRazaoSocial() + ", id " + userPJDAO.recuperar(2).getId()+ " excluido!");
			userPJDAO.excluir(2);
			userPJDAO.commit();
			System.out.println("--------------------------------------------------");

			////////////////////////////
			// encontra e exclui contaPF do banco
			System.out.println("Conta id : "+contaPFDAO.recuperar(1).getId() + " excluida!");
			contaPFDAO.excluir(1);
			contaPFDAO.commit();
			System.out.println("--------------------------------------------------");

			////////////////////////////
			// encontra e exclui contaPJ do banco
			System.out.println("Conta id : "+contaPJDAO.recuperar(2).getId() + " excluida!");
			contaPJDAO.excluir(2);
			contaPJDAO.commit();
			System.out.println("--------------------------------------------------");
*/

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
