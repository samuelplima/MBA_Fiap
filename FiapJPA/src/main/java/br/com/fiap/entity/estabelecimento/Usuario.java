package br.com.fiap.entity.estabelecimento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@SequenceGenerator(name="usuario", sequenceName="sq_usuario", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario")
	private int id;
	
	@Column(length=50,nullable=false)
	private String nome;
	
	@Column(length=50,nullable=false)
	private String senha;
	
	@Column(length=50,nullable=false)
	private String usuario;
	
	public Usuario() {
	}

	public Usuario(int id, String nome, String senha, String usuario) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
			
}
