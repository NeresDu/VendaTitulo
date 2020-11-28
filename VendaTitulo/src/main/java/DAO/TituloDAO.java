package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Cliente;
import model.Titulo;
import model.Venda;
import util.HibernateUtil;

public class TituloDAO extends GenericoDAO<Titulo>{
	
	public List<Titulo> GetTituloByCPF(String cpf) {
		//Iniciar nova Transa��o banco
		Transaction trans = null;

		List<Titulo> titulos = null;
		List<Titulo> titulosPorCpf = new ArrayList<Titulo>();

		//CONTROLE DE SESS�O COM UMA SESS�O QUE VIR� DO SERVIDOR
		try (Session Session = HibernateUtil.getSessionFactory().openSession()){
			Session.clear();
			trans = Session.beginTransaction();

			CriteriaBuilder builder = Session.getCriteriaBuilder();
			CriteriaQuery<Titulo> criteryQuery = builder.createQuery(Titulo.class);
			Root<Titulo> rootEntry = criteryQuery.from(Titulo.class);
			CriteriaQuery<Titulo> all = criteryQuery.select(rootEntry);

			TypedQuery<Titulo> allQuery = Session.createQuery(all);
			titulos = allQuery.getResultList();
			
			for (Titulo t : titulos) {
				if(t.getCliente().getCPF().equals(cpf)) {
					titulosPorCpf.add(t);
				}
			}
			/*
			 * c = Session.get(Titulo.class, cpf); titulos.add(c);
			 * 
			 * trans.commit();
			 */

		} catch (Exception e) {
			trans.rollback();
		}
		return titulosPorCpf;
	}
	public Titulo PagarTituloById(int Codigo) {
		//Iniciar nova Transa��o banco
		Transaction trans = null;

		Titulo t = null;

		//CONTROLE DE SESS�O COM UMA SESS�O QUE VIR� DO SERVIDOR
		try (Session Session = HibernateUtil.getSessionFactory().openSession()){
			Session.clear();
			trans = Session.beginTransaction();

			t = Session.get(Titulo.class, Codigo);
			t.setSituacao("pago");
			


			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
		return t;
	}
}
