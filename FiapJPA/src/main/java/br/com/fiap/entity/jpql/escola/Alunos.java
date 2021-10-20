package br.com.fiap.entity.jpql.escola;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_alunos")
public class Alunos {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nome_aluno")
	private String nome;
	
	@Column(name="idade_aluno")
	private int idade;	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}	

}
