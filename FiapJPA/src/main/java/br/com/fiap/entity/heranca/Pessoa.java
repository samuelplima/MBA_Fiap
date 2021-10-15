package br.com.fiap.entity.heranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {	
	
	@Id
	@SequenceGenerator(name="pessoa", sequenceName="sq_pessoa",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pessoa")
	private int id;
	
	@Column(length=50, nullable=false)
	private String nome;

	public Pessoa() {
	}

	public Pessoa(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

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
}
