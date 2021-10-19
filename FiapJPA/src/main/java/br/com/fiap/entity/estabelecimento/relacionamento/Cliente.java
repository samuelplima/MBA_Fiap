package br.com.fiap.entity.estabelecimento.relacionamento;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_cliente")
public class Cliente {
	
	@Id
	@Column(name="id_cliente")
	@SequenceGenerator(name="cliente",sequenceName="sq_tb_cliente", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="cliente")
	private int id;
	
	@Column(name="nm_cliente", length = 50)
	private String nome;	
	
	@ManyToMany(mappedBy = "clientes")
	private Collection<Estabelecimento> estabelecimentos;

	public Cliente() {
	}

	public Cliente(int id, String nome, Collection<Estabelecimento> estabelecimentos) {
		this.id = id;
		this.nome = nome;
		this.estabelecimentos = estabelecimentos;
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

	public Collection<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(Collection<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}		

}
