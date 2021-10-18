package br.com.fiap.entity.dao;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.entity.produto.Estado;
import br.com.fiap.entity.produto.Fornecedor;
import br.com.fiap.entity.produto.Produto;

public class ProgramTesteDAO {

	public static void main(String[] args) {

		EntityManager em = null;
		try {
			
			em = Persistence.createEntityManagerFactory("FiapJPA").createEntityManager();
			
			ProdutoDAO produtodao = new ProdutoDAO(em);
			FornecedorDAO fornecedordao  = new FornecedorDAO(em);
			
			em.getTransaction().begin();
			
			////////////////////////////////
			Produto produto = new Produto();
			produto.setNome("Microwave");
			produto.setDataCalendario(Calendar.getInstance());
			produto.setDataValidade(Calendar.getInstance());
			produto.setEstado(Estado.NOVO);
			///////////////////////////////
			produtodao.salvar(produto);
			///////////////////////////////
			
			////////////////////////////////
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome("Day´n Light Boose");
			fornecedor.setDataCadastro(Calendar.getInstance());	
			///////////////////////////////
			fornecedordao.salvar(fornecedor);
			///////////////////////////////

			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Erro no commit");
			em.getTransaction().rollback();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}
}
