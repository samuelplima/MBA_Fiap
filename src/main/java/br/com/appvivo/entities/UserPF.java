package br.com.appvivo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_user_pf")
public class UserPF extends User{	
	
	@Column(name="nome",length=50,nullable=false)
	private String nome;

	@Column(name="cpf",length=50,nullable=false)
	private String cpf;	
	
	@OneToMany(mappedBy = "userPF", targetEntity = ContaPF.class)
	private List<UserPF> userPF;
	
	public UserPF() {
	}	

	public UserPF(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	

	public List<UserPF> getUserPF() {
		return userPF;
	}

	public void setUserPF(List<UserPF> userPF) {
		this.userPF = userPF;
	}
	
	@Override
	public boolean validaCpfCnPJ(String cpf) {
		return super.validaCpfCnPJ(cpf);
	}

}
