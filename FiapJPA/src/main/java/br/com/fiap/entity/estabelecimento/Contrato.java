package br.com.fiap.entity.estabelecimento;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_contrato")
public class Contrato {
	
	@Id
	@Column(name="id_contrato")
//	@SequenceGenerator(name="contrato",sequenceName="sq_tb_contrato", allocationSize=1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="contrato")
	private int id;
		
	@Temporal(TemporalType.DATE)
	@Column(name="dt_vencimento")
	private Calendar dataVencimento;
	
	@Column(name="vl_aluguel")
	private String valor;
	
	@OneToOne
	@JoinColumn(name="id_estabelecimento")
	private Estabelecimento estabelecimento;
	
	public Contrato() {
	}
	
	public Contrato(int id, Calendar dataVencimento, String valor, Estabelecimento estabelecimento) {
		this.id = id;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	

}
