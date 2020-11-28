package testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.GenericoDAO;
import DAO.VendaDAO;
import model.Cliente;
import model.ProdutosVenda;
import model.Titulo;
import model.Venda;
import model.Vendedor;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendaDAO vDAO = new VendaDAO();
		Venda v = new Venda();
		ProdutosVenda prod = new ProdutosVenda();
		GenericoDAO gDAO = new GenericoDAO();
		
		  Cliente cli = new Cliente(); cli.setCPF("123"); cli.setNome("Jose");
		  v.setCliente(cli);
		 
		
		  Vendedor vendedor = new Vendedor(); vendedor.setCPF("987");
		  vendedor.setNome("Augusto"); v.setVendedor(vendedor);
		 
		
		  List<ProdutosVenda> produtos = new ArrayList<ProdutosVenda>();
		  prod.setNome("Coxinha"); prod.setPreco(1.90); prod.setQuantidade(2);
		  gDAO.Save(prod);
		  produtos.add(prod);
		  
		  
		  prod = new ProdutosVenda(); prod.setNome("Cheese Burguer");
		  prod.setPreco(5.20); prod.setQuantidade(1); 
		  gDAO.Save(prod);
		  produtos.add(prod);
		  v.setProdutosVenda(produtos);
		 

		Titulo t = new Titulo();
		Date da = new Date();
		t.setDataVencimento(da.toString());
		v.setTitulo(t);

		 vDAO.Save(v);
		
		//gDAO.Save(v);
		 t.PagarTitulo("123");

	}

}
