package br.com.fiap.entity.jpql.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.entity.jpql.escola.Alunos;
import br.com.fiap.entity.jpql.escola.Escola;
import br.com.fiap.entity.jpql.escola.Professores;

public class ProgramJpqlTestDAO {
	
	public static void main(String[] args) {
		
		try {
		
		EntityManager em = Persistence.createEntityManagerFactory("FiapJPA").
	 			createEntityManager();
		
		Escola escola = new Escola();
		Alunos alunos = new Alunos();
		Professores professores = new Professores();
		EscolaDAO escolaDao = new EscolaDAO(em);
		AlunosDAO alunosDao = new AlunosDAO(em);
		ProfessoresDAO professoresDao = new ProfessoresDAO(em);
			
			/*
			////////////////////////////////
			//adiciona escolas
			escola.setId(2);
			escola.setNomeEscola("EE Machado de Assis");
			escola.setQtdeAlunos(800);
			escolaDao.salvar(escola);
			escolaDao.commit();
			///////////////////////////////
			
			
			//////////////////////////////
			//adiciona alunos
			alunos.setId(2);
			alunos.setIdade(15);
			alunos.setNome("Maria Alice");
			alunosDao.salvar(alunos);
			alunosDao.commit();
			////////////////////////////
			 
			 
			/////////////////////////// 
			//adiciona professores
			professores.setId(2);
			professores.setNomeProfessor("Jorge Fereira");
			professores.setQtdeMaterias(2);
			professores.setMaterias(Materias.MATEMATICA);
			professoresDao.salvar(professores);
			professoresDao.commit();
	*/		///////////////////////////
			
			System.out.println("------------------------------------------ ");
			
			///////////////////////////
			//listar 2 ultimos metodo com jpql em Escola
			List<Escola> listar = escolaDao.listarDoisUltimos(); 		
			for(Escola listaEscola : listar) {
				System.out.println("Nome : " + listaEscola.getNomeEscola() + ", Id : " + listaEscola.getId());
			}
			//////////////////////////		
			
			System.out.println("------------------------------------------");
			
			///////////////////////////
			//listar por nome metodo com jpql em Escola
			List<Escola> listarNome = escolaDao.listarPorNome("Floriano"); 		
			for(Escola listaEscola : listarNome) {
				System.out.println("Nome : " + listaEscola.getNomeEscola());
			}
			//////////////////////////
			
			System.out.println("------------------------------------------");
			
			/////////////////////////
			//listar por nome ordenado
			List<Professores> listarNomeOrd = professoresDao.listarOrdenadoNome();
			for(Professores listaProfessores : listarNomeOrd) {
				System.out.println("Nome : " + listaProfessores.getNomeProfessor());
			}
			////////////////////////
			//listar por id ordenado
			List<Professores> listarIdOrd = professoresDao.listarOrdenadoId();
			for(Professores listaProfessores : listarIdOrd) {
				System.out.println("Id : " + listaProfessores.getId());
			}
			///////////////////////
			
			System.out.println("---------------------------------------------");
			System.out.println("comando de atualizaçao e nova listagem de alunos");

			///////////////////////
			//atualiza nome aluno em tabela toda e lista
			alunosDao.updateAlunos(3,"Suelen jorge");
			List<Alunos> listaAlunos1 = alunosDao.listar();
			for(Alunos alunosListar : listaAlunos1) {
				System.out.println("Nome : " + alunosListar.getNome() + ", Id : " + alunosListar.getId());
			}		
			///////////////////////
			
			System.out.println("---------------------------------------------");
			System.out.println("comando de exclusao e nova listagem de alunos");
			
			////////////////////////
			//exclui de alunos e lista
			alunosDao.excluirAlunos(4);
			List<Alunos> listaAlunos = alunosDao.listar();
			for(Alunos alunosListar : listaAlunos) {
				System.out.println("Nome : " + alunosListar.getNome() + ", Id : " + alunosListar.getId());
			}
			////////////////////////
			
		}catch(Exception e) {
			System.out.println("erro na transação");
			e.printStackTrace();
		}
		
	}
	
}
