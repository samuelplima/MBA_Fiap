package br.com.fiap.entity.jpql.escola;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_professores")
public class Professores {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nome_professor")
	private String nomeProfessor;
	
	@Column(name="qtde_materias")
	private int qtdeMaterias;
	
	@Column(name="materia")
	private Materias materias;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public int getQtdeMaterias() {
		return qtdeMaterias;
	}

	public void setQtdeMaterias(int qtdeMaterias) {
		this.qtdeMaterias = qtdeMaterias;
	}

	public Materias getMaterias() {
		return materias;
	}

	public void setMaterias(Materias materias) {
		this.materias = materias;
	}

}
