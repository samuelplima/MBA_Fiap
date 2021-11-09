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

import br.com.appvivo.enuns.Planos;
import br.com.appvivo.enuns.Produtos;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Conta {

	@Id
	@SequenceGenerator(name = "id_conta", sequenceName = "sq_conta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_conta")
	@Column(name = "id", length = 50)
	private int id;

	@Column(name = "planos")
	@Enumerated(EnumType.STRING)
	Planos planos;

	@Column(name = "produtos")
	@Enumerated(EnumType.STRING)
	Produtos produtos;

	public Conta() {
		super();
	}

	public Conta(int id, Planos planos, Produtos produtos) {
		super();
		this.id = id;
		this.planos = planos;
		this.produtos = produtos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Planos getPlanos() {
		return planos;
	}

	public void setPlanos(Planos planos) {
		this.planos = planos;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public boolean validaConta(String s) {
		if (this.getPlanos().toString() == s) {
			System.out.println("--------------------------------------------");
			System.out.println("O plano é: " + s);
			return true;
		} else {
			System.out.println("--------------------------------------------");
			System.out.println("Conta incompativel com o plano.");
			return false;
		}
	}

}
