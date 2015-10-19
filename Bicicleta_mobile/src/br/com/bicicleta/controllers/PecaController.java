package br.com.bicicleta.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bicicleta.modelo.Peca;

@Controller
public class PecaController {

	@SuppressWarnings("unchecked")
	@RequestMapping("buscapeca")
	public String buscaPeca(Model model){
		List<Peca> pecas = null;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bicicletas");
		EntityManager manager = factory.createEntityManager();

		pecas = (List<Peca>) manager.createQuery("select p from Peca p").getResultList();

		model.addAttribute("pecas",pecas);
		factory.close();
		return "peca/busca";
	}
	
	@RequestMapping("home")
	public void home()
	{
		
	}
}
