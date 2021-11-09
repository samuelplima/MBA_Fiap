package br.com.appvivo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

	
	@Id
	@SequenceGenerator(name="id", sequenceName="sq_user", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	@Column(name="id",length=50)
	private int id;
	
	@Column(name="codigo_cliente",length=50, nullable = false)
	private String codigoCliente;
	
	@Column(name="senha_cliente")
	private String senha;	

	public User() {
	}	

	public User(int id, String codigoCliente, String senha) {
		super();
		this.id = id;
		this.codigoCliente = codigoCliente;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean validaCpfCnPJ(String valida) {
		String[] s = valida.split("");
		if(valida != null && s.length == 11) {
			System.out.println("--------------------------------------------");
			System.out.println("É um cpf");
			return true;
		}
		else if(valida != null && s.length == 14){
			System.out.println("--------------------------------------------");
			System.out.println("É um cnpj");
			return true;
		}
		else {
			System.out.println("--------------------------------------------");
			System.out.println("Dados invalidos.");			
			return false;
		}
	}
	
}
