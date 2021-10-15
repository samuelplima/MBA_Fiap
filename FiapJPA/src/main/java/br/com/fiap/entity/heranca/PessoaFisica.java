package br.com.fiap.entity.heranca;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="tb_pessoa_fisica")
public class PessoaFisica extends Pessoa {
	
	@Column(name = "nr_cpf")
	private String cpf;

	public PessoaFisica() {
	}

	public PessoaFisica(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	

}
