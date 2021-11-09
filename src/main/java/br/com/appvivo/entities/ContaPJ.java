package br.com.appvivo.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.appvivo.enuns.Produtos;

@Entity
@Table(name = "conta_pj")
public class ContaPJ extends Conta {

	@ManyToOne
	@JoinColumn(name = "user_pj_id")
	private UserPJ userPJ;

	public ContaPJ() {
	}

	public UserPJ getUserPJ() {
		return userPJ;
	}

	public void setUserPJ(UserPJ userPJ) {
		this.userPJ = userPJ;
	}
	
	@Override
	public boolean validaConta(String s) {
		return super.validaConta(s);
	}

}
