package br.com.fiap.entity.pessoa.heranca;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="tb_pessoa_juridica")
public class PessoaJuridica extends Pessoa {

	@Column
	private String cnpj;
	
	@Column(name="inscr_estadual")
	private String inscr_Estadual;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String cnpj, String inscr_Estadual) {
		this.cnpj = cnpj;
		this.inscr_Estadual = inscr_Estadual;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscr_Estadual() {
		return inscr_Estadual;
	}

	public void setInscr_Estadual(String inscr_Estadual) {
		this.inscr_Estadual = inscr_Estadual;
	}	
	
}
