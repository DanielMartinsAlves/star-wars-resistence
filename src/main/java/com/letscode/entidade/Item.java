package com.letscode.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer pontuacao;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Long id, String nome, Integer pontuacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.pontuacao = pontuacao;
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Integer getPontuacao() {
		return pontuacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pontuacao == null) ? 0 : pontuacao.hashCode());
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pontuacao == null) {
			if (other.pontuacao != null)
				return false;
		} else if (!pontuacao.equals(other.pontuacao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", pontuacao=" + pontuacao + "]";
	}
	
	
}
