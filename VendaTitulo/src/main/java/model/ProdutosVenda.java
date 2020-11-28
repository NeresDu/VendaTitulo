package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ProdutosVenda")
public class ProdutosVenda implements EntidadeBase{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Codigo")
	private int Codigo;
	private String Nome;
	private int Quantidade;
	private double Preco;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return Codigo;
	}
	public ProdutosVenda(int codigo, int quantidade, double preco, String nome) {
		super();
		Codigo = codigo;
		Quantidade = quantidade;
		Preco = preco;
		Nome = nome;
	}
	public ProdutosVenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		Preco = preco;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	
	
}
