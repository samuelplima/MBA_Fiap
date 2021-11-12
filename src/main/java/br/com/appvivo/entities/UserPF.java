package br.com.appvivo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_user_pf")
public class UserPF extends User{	
	
	@Column(name="nome",length=50,nullable=false)
	private String nome;

	@Column(name="cpf",length=50,nullable=false)
	private String cpf;	
	
	@ManyToOne
	@JoinColumn(name = "conta_pf_id")
	private ContaPF contaPF;
	
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

	public ContaPF getContaPF() {
		return contaPF;
	}

	public void setContaPF(ContaPF contaPF) {
		this.contaPF = contaPF;
	}
	
	@Override
	public boolean validaCpfCnPJ(String cpf) {
		return validaCpfCnPJ(cpf);
	}
}
