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

import tn.esprit.spring.entities.Charite;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.service.ChariteSerice;

@RestController
@RequestMapping("/Charite")
public class ChariteRestController {
@Autowired
ChariteSerice cs;   
//http://localhost:8081/SpringMVC/servlet/Charite/add-charite

@PostMapping("/add-charite")
@ResponseBody
public Charite saveCharite(@RequestBody Charite charit) {
Charite charite = cs.save(charit);
return charite;
}



//http://localhost:8081/SpringMVC/servlet/Charite/retrieve-all-Charite
@GetMapping("/retrieve-all-Charite")
@ResponseBody
public List<Charite> getCharite() {
List<Charite> list = cs.retrieveAllCharite();
return list;
}
//http://localhost:8081/SpringMVC/servlet/Charite/remove-Charite/{event-id}
@DeleteMapping("/remove-Charite/{charit-id}")
@ResponseBody
public void removeCharite(@PathVariable("charit-id") long charitid) {
cs.deleteCharite(charitid);
}

//http://localhost:8081/SpringMVC/servlet/Charite/modify-charite
			@PutMapping("/modify-charite")
			@ResponseBody
			public Charite modifycharite(@RequestBody Charite charit) {
			return cs.updateCharite(charit);
			}
// http://localhost:8081/SpringMVC/servlet/Charite/charitsomme
			   @GetMapping("/charitesomme")
				@ResponseBody
				public float somme() {
				return cs.TotalDonation();
				}














}
