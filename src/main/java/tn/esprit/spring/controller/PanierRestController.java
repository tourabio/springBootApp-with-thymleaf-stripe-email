package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.service.PanierService;

@RestController

public class PanierRestController {
	@Autowired
	PanierService ps;
	// http://localhost:8081/SpringMVC/servlet/add-panier
	@PostMapping("/add-panier")
	@ResponseBody
	public Panier savePanier(@RequestBody Panier pan) {
	Panier panier = ps.savepan(pan);
	return panier;
	}

	// URL : http://localhost:8081/SpringMVC/servlet/getAllPanier
    @GetMapping(value = "getAllPanier")
  
    public List<Panier> getPanier() {
		List<Panier> paniers = ps.getPanier();
		return paniers;
	}

}
