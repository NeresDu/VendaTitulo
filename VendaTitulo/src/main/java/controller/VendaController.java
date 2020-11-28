package controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DAO.GenericoDAO;
import DAO.VendaDAO;
import model.Venda;

@RestController
public class VendaController {
	VendaDAO vDAO = new VendaDAO();
	@RequestMapping("/salvarVenda")
	public Venda salvaDeposito(@RequestBody String venda) {

		Venda d = new Venda();
		System.out.println(venda);
		Gson gson = new Gson();
		d = gson.fromJson(venda, Venda.class);
//		System.out.println(d.getTitulo().getCodigo()+" | "+d.getTitulo().getSituacao());
		vDAO.Save(d);
		return d;
		
	}

}
