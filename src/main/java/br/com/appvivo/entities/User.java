package br.com.appvivo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import br.com.appvivo.enuns.UF;

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
	
	@Column
	private String email;
	
	@Column
	private String rua;
	
	@Column
	private String bairro;
	
	@Column
	private String cidade;
	
	@Column
	private String cep;
	
	@Column(name = "UF")
	@Enumerated(EnumType.STRING)
	private UF uf;

	public User() {
	}		
	
	public User(int id, String codigoCliente, String senha, String email, String rua, String bairro, String cidade,
			String cep, UF uf) {
		super();
		this.id = id;
		this.codigoCliente = codigoCliente;
		this.senha = senha;
		this.email = email;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
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
