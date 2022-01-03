package com.letscode.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Traicao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Rebelde traidor;
	@ManyToOne
	private Rebelde delator;
	
	public Traicao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Traicao(Long id, Rebelde traidor, Rebelde delator) {
		super();
		this.id = id;
		this.traidor = traidor;
		this.delator = delator;
	}
	public Long getId() {
		return id;
	}
	public Rebelde getTraidor() {
		return traidor;
	}
	public Rebelde getDelator() {
		return delator;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delator == null) ? 0 : delator.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((traidor == null) ? 0 : traidor.hashCode());
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
		Traicao other = (Traicao) obj;
		if (delator == null) {
			if (other.delator != null)
				return false;
		} else if (!delator.equals(other.delator))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (traidor == null) {
			if (other.traidor != null)
				return false;
		} else if (!traidor.equals(other.traidor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Traicao [id=" + id + ", traidor=" + traidor + ", delator=" + delator + "]";
	}
	
}
