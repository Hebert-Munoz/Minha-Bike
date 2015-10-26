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

	
	EntityManagerFactory factory;
	
	@RequestMapping("formpeca")
	public String formPeca()
	{
		return "peca/form_peca";
	}

	@RequestMapping("CadastraPeca")
	public String cadastraPeca(Peca peca)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bicicletas");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();    
		manager.persist(peca);
		manager.getTransaction().commit();  

		manager.close();

		return "redirect:detalhepeca?id="+peca.getId();
	}


	@SuppressWarnings("unchecked")
	@RequestMapping("buscapeca")
	public String buscaPeca(Model model){
		List<Peca> pecas = null;

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();
		pecas = (List<Peca>) manager.createQuery("select p from Peca p").getResultList();

		model.addAttribute("pecas",pecas);
		//factory.close();
		
		return "peca/busca";

	}

	private EntityManagerFactory getFactory() {
		
		if (factory == null) {
			factory =  Persistence.createEntityManagerFactory("bicicletas");
		}
		return factory;
	
	}

	@RequestMapping("detalhepeca")
	public String show(Long id, Model model) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("bicicletas");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Peca peca = entityManager.find(Peca.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close(); 
		model.addAttribute("peca",peca);
		return 	"peca/detalhepeca";
	}
	
	@RequestMapping("home")
	public void home() {
		
	}

}
