package DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.ProdutosVenda;
import model.Titulo;
import model.Venda;
import util.HibernateUtil;

public class VendaDAO extends GenericoDAO<Venda>{
	
	public void Save(Venda venda) {
		Transaction trans = null;

		try (Session Session = HibernateUtil.getSessionFactory().openSession()){

			trans = Session.beginTransaction();
			venda.getTitulo().setCliente(venda.getCliente());
			Date x=new Date();
			venda.setDataVenda(x.toString());
			venda.getTitulo().setDataCriação(x.toString());
			if(venda.getTitulo().getDataVencimento() == null) {
				venda.getTitulo().setDataVencimento(x.toString());
			}
			double total = 0;
			if(venda.getProdutosVenda() != null) {
				List<ProdutosVenda> produtos = venda.getProdutosVenda();
			
			for (ProdutosVenda p : produtos) {
				if(p.getQuantidade() == 1) {
					total = total + p.getPreco();
					System.out.println(p.getCodigo()+ " // "+p.getNome());
				}
				if(p.getQuantidade() > 1) {
					total = total + (p.getQuantidade()*p.getPreco());
				}
				
			}
			}
			
			venda.getTitulo().setValor(total);
			venda.getTitulo().setSituacao("pendente");
			/*
			 * Session.save(t); trans.commit(); Session.clear(); trans =
			 * Session.beginTransaction();
			 */
			Session.save(venda);
			trans.commit();
			

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			e.printStackTrace();
		}
	}

}
