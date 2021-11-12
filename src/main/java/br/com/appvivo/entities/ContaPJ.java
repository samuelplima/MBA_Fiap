package br.com.appvivo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "conta_pj")
public class ContaPJ extends Conta {

	@OneToMany(mappedBy = "contaPJ", targetEntity = UserPJ.class)
	private List<UserPJ> userPJ;

	public ContaPJ() {
	}

	public List<UserPJ> getUserPJ() {
		return userPJ;
	}

	public void setUserPJ(List<UserPJ> userPJ) {
		this.userPJ = userPJ;
	}	
	
	@Override
	public boolean validaConta(String s) {
		return validaConta(s);
	}
}
