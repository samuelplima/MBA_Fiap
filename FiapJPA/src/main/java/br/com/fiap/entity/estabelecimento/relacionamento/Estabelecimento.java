package br.com.fiap.entity.estabelecimento.relacionamento;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

	@Id
	@SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimento", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento")
	@Column(name = "id_estabelecimento")	
	private int id;
	
	@Column(name="nm_estabelecimento", length = 50)
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_tipo_estabelecimento")
	private TipoEstabelecimento tipo;
	
	@OneToOne(mappedBy="estabelecimento", cascade = CascadeType.ALL)	
	private Contrato contrato;	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name="id_estabelecimento"),
	inverseJoinColumns=@JoinColumn(name="id_cliente"),
	name="tb_cliente_estabelecimento")
	private Collection<Cliente> clientes;
	
	
	public Estabelecimento() {
	}

	public Estabelecimento(int id, String name, TipoEstabelecimento tipo, Contrato contrato,
			Collection<Cliente> clientes) {
		this.id = id;
		this.name = name;
		this.tipo = tipo;
		this.contrato = contrato;
		this.clientes = clientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TipoEstabelecimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstabelecimento tipo) {
		this.tipo = tipo;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

}
