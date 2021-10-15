package br.com.fiap.entity.produto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Id	
	@SequenceGenerator(name="produto",sequenceName="sq_tb_produto",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "produto")
	private int id;
	
	@Column(name="nm_produto",nullable=false,length=100)
	private String nome;
	
//	@Column(name="vlpreço")
//	private int preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade")
	private Calendar dataValidade;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@Column(name="dt_cadastro")
	@CreationTimestamp
	private Calendar dataCalendario;
	
	@Column(name="dt_atualizacao")
	@UpdateTimestamp
	private Calendar dataModificacao;
	
//	@Formula("vlpreco*0.9")
//	private int precoDesconto;
	
	public Produto() {
		super();
	}

	public Produto(int id, String nome/*, int preco*/, Calendar dataValidade, Estado estado, Calendar dataCalendario,
			Calendar dataModificacao/*, int precoDesconto*/) {
		super();
		this.id = id;
		this.nome = nome;
//		this.preco = preco;
		this.dataValidade = dataValidade;
		this.estado = estado;
		this.dataCalendario = dataCalendario;
		this.dataModificacao = dataModificacao;
//		this.precoDesconto = precoDesconto;
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

//	public int getPreco() {
//		return preco;
//	}

//	public void setPreco(int preco) {
//		this.preco = preco;
//	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Calendar getDataCalendario() {
		return dataCalendario;
	}

	public void setDataCalendario(Calendar dataCalendario) {
		this.dataCalendario = dataCalendario;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

//	public int getPrecoDesconto() {
//		return precoDesconto;
//	}

//	public void setPrecoDesconto(int precoDesconto) {
//		this.precoDesconto = precoDesconto;
//	}	

}
