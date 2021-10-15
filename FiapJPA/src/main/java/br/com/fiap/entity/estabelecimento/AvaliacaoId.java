package br.com.fiap.entity.estabelecimento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AvaliacaoId implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id_usuario")
	private Integer usuarioId;

	@Column(name = "id_estabelecimento")
	private Integer estabelecimentoId;

	public AvaliacaoId() {
	}

	public AvaliacaoId(Integer usuarioId, Integer estabelecimentoId) {
		this.usuarioId = usuarioId;
		this.estabelecimentoId = estabelecimentoId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getEstabelecimentoId() {
		return estabelecimentoId;
	}

	public void setEstabelecimentoId(Integer estabelecimentoId) {
		this.estabelecimentoId = estabelecimentoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estabelecimentoId == null) ? 0 : estabelecimentoId.hashCode());
		result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoId other = (AvaliacaoId) obj;
		if (estabelecimentoId == null) {
			if (other.estabelecimentoId != null)
				return false;
		} else if (!estabelecimentoId.equals(other.estabelecimentoId))
			return false;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}

}
