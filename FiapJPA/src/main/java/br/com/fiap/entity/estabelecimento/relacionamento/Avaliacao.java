package br.com.fiap.entity.estabelecimento.relacionamento;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_avaliacao")
@IdClass(AvaliacaoId.class)
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Usuario usuarioId;

	@Id
	@JoinColumn(name = "id_estabelecimento", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Estabelecimento estabelecimentoId;

	@Enumerated(EnumType.ORDINAL)
	@Column(length = 1)
	private NotaAvaliacao nota;

	// @CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_avaliacao")
	private Calendar dataAvaliacao;

	public Avaliacao() {
	}

	public Avaliacao(Usuario usuarioId, Estabelecimento estabelecimentoId, NotaAvaliacao nota,
			Calendar dataAvaliacao) {
		this.usuarioId = usuarioId;
		this.estabelecimentoId = estabelecimentoId;
		this.nota = nota;
		this.dataAvaliacao = dataAvaliacao;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Estabelecimento getEstabelecimentoId() {
		return estabelecimentoId;
	}

	public void setEstabelecimentoId(Estabelecimento estabelecimentoId) {
		this.estabelecimentoId = estabelecimentoId;
	}

	public NotaAvaliacao getNota() {
		return nota;
	}

	public void setNota(NotaAvaliacao nota) {
		this.nota = nota;
	}

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

}
