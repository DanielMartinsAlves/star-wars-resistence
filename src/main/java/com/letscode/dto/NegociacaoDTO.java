package com.letscode.dto;

import java.util.Arrays;

public class NegociacaoDTO {

	private Long idNegociador1;
	private Long[] idsItensNegociador1;
	private Long idNegociador2;
	private Long[] idsItensNegociador2;
	
	public NegociacaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NegociacaoDTO(Long idNegociador1, Long[] idsItensNegociador1, Long idNegociador2,
			Long[] idsItensNegociador2) {
		super();
		this.idNegociador1 = idNegociador1;
		this.idsItensNegociador1 = idsItensNegociador1;
		this.idNegociador2 = idNegociador2;
		this.idsItensNegociador2 = idsItensNegociador2;
	}
	public Long getIdNegociador1() {
		return idNegociador1;
	}
	public Long[] getIdsItensNegociador1() {
		return idsItensNegociador1;
	}
	public Long getIdNegociador2() {
		return idNegociador2;
	}
	public Long[] getIdsItensNegociador2() {
		return idsItensNegociador2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNegociador1 == null) ? 0 : idNegociador1.hashCode());
		result = prime * result + ((idNegociador2 == null) ? 0 : idNegociador2.hashCode());
		result = prime * result + Arrays.hashCode(idsItensNegociador1);
		result = prime * result + Arrays.hashCode(idsItensNegociador2);
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
		NegociacaoDTO other = (NegociacaoDTO) obj;
		if (idNegociador1 == null) {
			if (other.idNegociador1 != null)
				return false;
		} else if (!idNegociador1.equals(other.idNegociador1))
			return false;
		if (idNegociador2 == null) {
			if (other.idNegociador2 != null)
				return false;
		} else if (!idNegociador2.equals(other.idNegociador2))
			return false;
		if (!Arrays.equals(idsItensNegociador1, other.idsItensNegociador1))
			return false;
		if (!Arrays.equals(idsItensNegociador2, other.idsItensNegociador2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NegociacaoDTO [idNegociador1=" + idNegociador1 + ", idsItensNegociador1="
				+ Arrays.toString(idsItensNegociador1) + ", idNegociador2=" + idNegociador2 + ", idsItensNegociador2="
				+ Arrays.toString(idsItensNegociador2) + "]";
	}
	
}
