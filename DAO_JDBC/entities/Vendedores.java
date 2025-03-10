package entities;

import java.io.Serializable;
import java.util.Date;

public class Vendedores implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private Double salarioBase;
	private Departamento departamento;
	
	//Construtor
	public Vendedores() {
	}

	public Vendedores(Integer id, String nome, String email, Date dataNascimento, Double salarioBase,
			Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//HashCodes/equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Vendedores other = (Vendedores) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Vendedor:\n"
				+ "ID do vendedor = " + id + "\nNome do vendedor = " + nome + "\nE-mail = " + email
				+ "\nData de nascimento = " + dataNascimento
				+ "\nSalário Bruto = " + salarioBase + "\nDepartamento [ID = "
				+ departamento.getId() + "]: " + departamento.getNome();
	}
}
