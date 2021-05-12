package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Endroit;
import tn.esprit.spring.entities.Publicite;
import tn.esprit.spring.service.EndroitService;
import tn.esprit.spring.service.PubliciteService;

@RestController
@RequestMapping("/Publicite")
public class PubliciteRestController {
	@Autowired
	PubliciteService pr;

	//http://localhost:8081/SpringMVC/servlet/Publicite/add-publicite
	@PostMapping("/add-publicite")
	@ResponseBody
	public Publicite savePublicite(@RequestBody Publicite publicite) {
	Publicite pub = pr.save(publicite);
	return publicite;
	}



	//http://localhost:8081/SpringMVC/servlet/Publicite/retrieve-all-publicite
	@GetMapping("/retrieve-all-publicite")
	@ResponseBody
	public List<Publicite> getPublicite() {
	List<Publicite> list = pr.retrieveAllPublicite();
	return list;
	}
	//http://localhost:8081/SpringMVC/servlet/Publicite/remove-publicite/{event-id}
	@DeleteMapping("/remove-publicite/{publicite-id}")
	@ResponseBody
	public void removePublicite(@PathVariable("publicite-id") long publiciteId) {
	pr.deletePublicite(publiciteId);
	}

	//http://localhost:8081/SpringMVC/servlet/Publicite/modify-publicite
	@PutMapping("/modify-publicite")
	@ResponseBody
	public Publicite modifypublicite(@RequestBody Publicite publicite) {
	return pr.updatePublicite(publicite);
	}

}
