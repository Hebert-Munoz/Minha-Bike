package br.com.bicicleta.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bicicleta.modelo.Bicicleta;

@Controller
public class BicicletaController {

	@SuppressWarnings("unchecked")
	@RequestMapping("buscabicicleta")
	public String buscaBicicleta(Model model){

		List<Bicicleta> bicicletas = null;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bicicletas");
		EntityManager manager = factory.createEntityManager();

		bicicletas = (List<Bicicleta>) manager.createQuery("select p from Bicicleta p").getResultList();
		model.addAttribute("bicicletas",bicicletas);
		factory.close();
		return "bicicleta/buscabicicleta";
	}

	@RequestMapping("showbicicleta")
	public String showBicicleta(Model model, Long id){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bicicletas");
		EntityManager manager = factory.createEntityManager();

		Bicicleta bicicleta = manager.find(Bicicleta.class, id);
		model.addAttribute("bicicleta", bicicleta);

		return "bicicleta/bicicletacadastrada";	
	}

}
