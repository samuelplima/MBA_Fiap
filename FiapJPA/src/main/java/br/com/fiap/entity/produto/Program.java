package br.com.fiap.entity.produto;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Program {

	public static void main(String[] args) {

		EntityManager em = null;
		
		try {
			em = Persistence.createEntityManagerFactory("FiapJPA").createEntityManager();		
			em.getTransaction().begin();

/*			
			//consulta e reescreve na tabela produto
			Produto recuperado = em.find(Produto.class, 1);
			recuperado.setNome("PS5");
			System.out.println(recuperado.getId() + " " + recuperado.getNome());			
			em.persist(recuperado);
			em.getTransaction().commit();
*/
			
/*			
			//consulta e deleta da tabela produto
			Produto recuperado = em.find(Produto.class, 3);
			System.out.println("Sera deletado : " + " ID: " + recuperado.getId() + ", nome :" + recuperado.getNome());			
			em.remove(recuperado);
			em.getTransaction().commit();
*/						
			
			//insere na tabela produto
			Produto produto = new Produto();
			produto.setNome("TV");
//			produto.setPreco(900.0);
			produto.setDataValidade(Calendar.getInstance());
			produto.setEstado(Estado.NOVO);
			produto.setDataCalendario(Calendar.getInstance());
			produto.setDataModificacao(Calendar.getInstance());
//			produto.setPrecoDesconto(50.0);			
			em.persist(produto);
			em.getTransaction().commit();


/*			
			//insere na tabela fornecedor
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setDataCadastro(Calendar.getInstance());
			fornecedor.setDataModificacao(Calendar.getInstance());
			fornecedor.setNome("Fornecedor de comida");
			em.persist(fornecedor);
			em.getTransaction().commit();
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
