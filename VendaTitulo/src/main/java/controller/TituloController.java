package controller;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import DAO.TituloDAO;
import model.Titulo;
import model.Venda;

@RestController
public class TituloController {

	
		TituloDAO tDAO = new TituloDAO();
		@RequestMapping(value = "/getTitulos", consumes = MediaType.TEXT_PLAIN_VALUE)
		public List<Titulo> GetTituloByCPF(@RequestBody String cpf) {
			System.out.println(cpf);
			List<Titulo> titulos = null;

			titulos = tDAO.GetTituloByCPF(cpf);
			for (Titulo t : titulos) {
				System.out.println(t.getCodigo()+" // "+t.getValor());
			}
			return titulos;


		}
		
		@RequestMapping(value = "/pagarTitulo", consumes = MediaType.TEXT_PLAIN_VALUE)
		public Titulo PagarTituloById(@RequestBody String codString) {
			int codInt = Integer.parseInt(codString);
			System.out.println(codInt);
			return tDAO.PagarTituloById(codInt);
			 


		}
		
}
