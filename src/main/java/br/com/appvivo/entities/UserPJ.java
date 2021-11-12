package br.com.appvivo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_user_pj")
public class UserPJ extends User{
		
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@ManyToOne
	@JoinColumn(name = "conta_pj_id")
	private ContaPJ contaPJ;
		
	public UserPJ() {
	}

	public UserPJ(String cnpj, String razaoSocial) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public ContaPJ getContaPJ() {
		return contaPJ;
	}

	public void setContaPJ(ContaPJ contaPJ) {
		this.contaPJ = contaPJ;
	}
	
	@Override
	public boolean validaCpfCnPJ(String cnpj) {
		return validaCpfCnPJ(cnpj);
	}	
}