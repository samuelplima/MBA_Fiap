package br.com.appvivo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conta_pf")
public class ContaPF extends Conta{
	
	@OneToMany(mappedBy = "contaPF", targetEntity = UserPF.class)
	private List<UserPF> userPF;
	
	public ContaPF() {
	}

	public List<UserPF> getUserPF() {
		return userPF;
	}

	public void setUserPF(List<UserPF> userPF) {
		this.userPF = userPF;
	}
	
	@Override
	public boolean validaConta(String s) {
		return validaConta(s);
	}	

}
