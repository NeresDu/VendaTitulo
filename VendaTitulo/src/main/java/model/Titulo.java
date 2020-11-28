package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import DAO.TituloDAO;

@Entity
@Table(name = "Titulos")
public class Titulo implements EntidadeBase{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Codigo")
	private int Codigo;
	
	private String DataCriação;
	private String DataVencimento;
	private String DataPagamento;
	private double Valor;
	private String Situacao;
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente Cliente
	;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return Codigo;
	}
	public Titulo(int codigo, String dataCriação, String dataVencimento, String dataPagamento, double valor, String situacao) {
		super();
		Codigo = codigo;
		DataCriação = dataCriação;
		DataVencimento = dataVencimento;
		Valor = valor;
		Situacao = situacao;
		DataPagamento = dataPagamento;
	}
	public Titulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	public String getDataCriação() {
		return DataCriação;
	}
	public void setDataCriação(String dataCriação) {
		DataCriação = dataCriação;
	}
	public String getDataVencimento() {
		return DataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		DataVencimento = dataVencimento;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public String getSituacao() {
		return Situacao;
	}
	public void setSituacao(String situacao) {
		Situacao = situacao;
	}
	public String getDataPagamento() {
		return DataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		DataPagamento = dataPagamento;
	}
	public void PagarTitulo(String cpf){
		TituloDAO tDAO = new TituloDAO();
		List<Titulo> titulos = null;
		titulos = tDAO.GetTituloByCPF(cpf);
		
		for (Titulo t : titulos) {
			System.out.println(t.getCodigo()+" | "+t.getSituacao()+" | "+t.getValor());
		}
		
		
	}
	

}
