package br.com.appvivo.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="conta_pf")
public class ContaPF extends Conta{
	
	@ManyToOne
	@JoinColumn(name = "user_pf_id")
	private UserPF userPF;
	
	public ContaPF() {
	}

	public UserPF getUserPF() {
		return userPF;
	}

	public void setUserPF(UserPF userPF) {
		this.userPF = userPF;
	}
	
	@Override
	public boolean validaConta(String s) {
		return super.validaConta(s);
	}
	

}
