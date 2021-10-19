package br.com.fiap.entity.estabelecimento.relacionamento;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_estabelecimento")
public class TipoEstabelecimento {
	
	@Id
	@Column(name="id_tipo_estabelecimento")
	@SequenceGenerator(name="tipoEstabelecimento",sequenceName="sq_tb_tipo_estabelecimento", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tipoEstabelecimento")
	private int id;
	
	@Column(name="nm_tipo_estabelecimento", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "tipo")
	private Collection<Estabelecimento> estabelecimento;	
	

	public TipoEstabelecimento() {
	}

	public TipoEstabelecimento(int id, String nome, Collection<Estabelecimento> estabelecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.estabelecimento = estabelecimento;
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

	public Collection<Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimentos(Collection<Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}	
	
	
	
}
