package entities;

import java.io.Serializable;

public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	//Constructors
	public Departamento() {
	}
	public Departamento(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	

	//Getters/Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Departamento other = (Departamento) obj;
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
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Departamento criado com sucesso!\n"
				+ "[ID do departamento = " + id + "]\n[Nome do departamento = " + nome + "]";
	}
	

}
