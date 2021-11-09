package br.com.appvivo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_user_pj")
public class UserPJ extends User{
		
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@OneToMany(mappedBy = "userPJ", targetEntity = ContaPJ.class)
	private List<UserPJ> userPJ;
	
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

	public List<UserPJ> getUserPJ() {
		return userPJ;
	}

	public void setUserPJ(List<UserPJ> userPJ) {
		this.userPJ = userPJ;
	}
	
	@Override
	public boolean validaCpfCnPJ(String cnpj) {
		return super.validaCpfCnPJ(cnpj);
	}
	
	
}