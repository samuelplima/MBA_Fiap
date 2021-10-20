package br.com.fiap.entity.jpql.escola;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_escola")
public class Escola {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nome_escola")
	private String nomeEscola;
	
	@Column(name="qtde_alunos")
	private int qtdeAlunos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public int getQtdeAlunos() {
		return qtdeAlunos;
	}

	public void setQtdeAlunos(int qtdeAlunos) {
		this.qtdeAlunos = qtdeAlunos;
	}	

}
