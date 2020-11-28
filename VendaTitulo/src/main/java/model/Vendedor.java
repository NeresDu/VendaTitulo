package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Vendedores")
public class Vendedor implements EntidadeBase{
	@Id
	private String CPF;
	private String Nome;
	private String Telefone;
	private Date DataNascimento;
	public Vendedor(String cPF, String nome, String telefone, Date dataNascimento) {
		super();
		CPF = cPF;
		Nome = nome;
		Telefone = telefone;
		DataNascimento = dataNascimento;
	}
	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return CPF;
	}

	
	
}
