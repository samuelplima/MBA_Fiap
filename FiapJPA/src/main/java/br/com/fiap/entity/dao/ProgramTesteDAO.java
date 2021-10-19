package br.com.fiap.entity.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.entity.produto.Estado;
import br.com.fiap.entity.produto.Fornecedor;
import br.com.fiap.entity.produto.Produto;

public class ProgramTesteDAO {

	public static void main(String[] args) {
			
		 	EntityManager em = Persistence.createEntityManagerFactory("FiapJPA").
		 			createEntityManager();
			
			ProdutoDAO produtoDao = new ProdutoDAO(em);
			FornecedorDAO fornecedorDao  = new FornecedorDAO(em);
			Produto produto = new Produto();
			Fornecedor fornecedor = new Fornecedor();

			
			////////////////////////////////
			//produto cadastro
			produto.setNome("Television 4K");
			produto.setDataCalendario(Calendar.getInstance());
			produto.setDataValidade(Calendar.getInstance());
			produto.setEstado(Estado.NOVO);
			///////////////////////////////
			produtoDao.salvar(produto);
			//////////////////////////////
			try {
				produtoDao.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/////////////////////////////////
			
			////////////////////////////////
			//fornecedor cadastro
			fornecedor.setNome("K mart");
			fornecedor.setDataCadastro(Calendar.getInstance());	
			///////////////////////////////
			fornecedorDao.salvar(fornecedor);
			//////////////////////////////
			try {
				fornecedorDao.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			///////////////////////////////

			System.out.println("--------------------------------------------------");
			System.out.println("Antes das exclusoes e atualiaçoes");
			
			//////////////////////////////
			//lista produtos no banco de dados 
			List<Produto> listaProduto = produtoDao.listar();
			for(Produto lista : listaProduto) {
				System.out.println("Id " + lista.getId() + ", nome  " + lista.getNome());
			}
			/////////////////////////////
			
			//////////////////////////////
			//lista fornecedores no banco de dados 
			List<Fornecedor> listaFornecedor = fornecedorDao.listar();
			for(Fornecedor lista : listaFornecedor) {
				System.out.println("Id " + lista.getCodigo() + ", nome  " + lista.getNome());
			}
			/////////////////////////////
			
			System.out.println("--------------------------------------------------");
			
			////////////////////////////
			//encontra e exclui produto do banco
			try {
				System.out.println(produtoDao.recuperar(3));
				produtoDao.excluir(3);
				produtoDao.commit();
			} catch (Exception e) {
					e.printStackTrace();
			}
			///////////////////////////
			
			System.out.println("--------------------------------------------------");
			
			////////////////////////////
			//encontra e exclui fornecedor do banco
			try {
				System.out.println(fornecedorDao.recuperar(1));
				fornecedorDao.excluir(1);
				fornecedorDao.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			///////////////////////////

			
			////////////////////////////
			//atualiza produtos
			try {
				Produto prodAtualiza = produtoDao.recuperar(2);
				prodAtualiza.setNome("Sound");
				produtoDao.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			///////////////////////////
			
			////////////////////////////
			//atualiza produtos
			try {
				Fornecedor fornAtualiza = fornecedorDao.recuperar(2);
				fornAtualiza.setNome("Krusty Krabs");
				produtoDao.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			///////////////////////////
			
			System.out.println("--------------------------------------------------");
			System.out.println("Depois das exclusoes e atualizaçoes");
			
			//////////////////////////////
			//lista produtos no banco de dados 
			List<Produto> listaProduto1 = produtoDao.listar();
			for(Produto lista : listaProduto1) {
				System.out.println("Id " + lista.getId() + ", nome  " + lista.getNome());
			}
			/////////////////////////////
			
			System.out.println("--------------------------------------------------");
			
			//////////////////////////////
			//lista fornecedores no banco de dados 
			List<Fornecedor> listaFornecedor1 = fornecedorDao.listar();
			for(Fornecedor lista : listaFornecedor1) {
				System.out.println("Id " + lista.getCodigo() + ", nome  " + lista.getNome());
			}
			/////////////////////////////
			
	}
}
