package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Vendas")
public class Venda implements EntidadeBase{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Codigo")
	private int Codigo;
	private String DataVenda;
	//@JoinColumn(name = "CpfCliente")
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente Cliente;
	//@JoinColumn(name = "CpfVendedor")
	@OneToOne(cascade = CascadeType.ALL)
	private Vendedor Vendedor;
	//@JoinColumn(name = "CodigoTitulo")
	@OneToOne(cascade = CascadeType.ALL)
	private Titulo Titulo;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProdutosVenda> ProdutosVenda;

	@Override
	public Serializable getId() {
		return Codigo;
	}

	public Venda(int codigo, String dataVenda, model.Cliente cliente, model.Vendedor vendedor,
			List<model.ProdutosVenda> produtosVenda) {
		super();
		Codigo = codigo;
		DataVenda = dataVenda;
		Cliente = cliente;
		Vendedor = vendedor;
		ProdutosVenda = produtosVenda;
	}

	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getDataVenda() {
		return DataVenda;
	}
	public void setDataVenda(String datavenda) {
		DataVenda = datavenda;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public Vendedor getVendedor() {
		return Vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		Vendedor = vendedor;
	}

	public List<ProdutosVenda> getProdutosVenda() {
		return ProdutosVenda;
	}

	public void setProdutosVenda(List<ProdutosVenda> produtosVenda) {
		ProdutosVenda = produtosVenda;
	}

	public Titulo getTitulo() {
		return Titulo;
	}

	public void setTitulo(Titulo titulo) {
		Titulo = titulo;
	}
	
	
	

}
