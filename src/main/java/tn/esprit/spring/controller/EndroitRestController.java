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
import tn.esprit.spring.entities.Endroit;
import tn.esprit.spring.service.EndroitService;

@RestController
@RequestMapping("/Endroit")
public class EndroitRestController {
@Autowired
EndroitService cr;

//http://localhost:8081/SpringMVC/servlet/Endroit/add-endroit
@PostMapping("/add-endroit")
@ResponseBody
public Endroit saveEndroit(@RequestBody Endroit endroite) {
Endroit endroit = cr.save(endroite);
return endroite;
}



//http://localhost:8081/SpringMVC/servlet/Endroit/retrieve-all-endroit
@GetMapping("/retrieve-all-endroit")
@ResponseBody
public List<Endroit> getEndroit() {
List<Endroit> list = cr.retrieveAllEndroit();
return list;
}
//http://localhost:8081/SpringMVC/servlet/Endroit/remove-endroit/{event-id}
@DeleteMapping("/remove-endroit/{endroit-id}")
@ResponseBody
public void removeEndroit(@PathVariable("endroit-id") long endroitId) {
cr.deleteEndroit(endroitId);
}

//http://localhost:8081/SpringMVC/servlet/Endroit/modify-endroit
@PutMapping("/modify-endroit")
@ResponseBody
public Endroit modifyendroit(@RequestBody Endroit endroit) {
return cr.updateEndroite(endroit);
}
//http://localhost:8081/SpringMVC/servlet/Endroit/endroitreserved
@GetMapping("/endroitreserved")
@ResponseBody
public List<Endroit> getEndroiteR() {
List<Endroit> listr = cr.ListeEndroitR();
return listr;
}}