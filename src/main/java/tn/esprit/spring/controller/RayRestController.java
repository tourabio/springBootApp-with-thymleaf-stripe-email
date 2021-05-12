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

import tn.esprit.spring.entities.Ray;
import tn.esprit.spring.service.RayService;

@RestController
@RequestMapping("/Ray")
public class RayRestController {
	@Autowired
	RayService Rr;
	// http://localhost:8081/SpringMVC/servlet/Ray/add-Ray
	@PostMapping("/add-Ray")
	@ResponseBody
	public Ray saveRay(@RequestBody Ray ray) {
		Ray rayon = Rr.save(ray);
		return rayon;
	}
	// http://localhost:8081/SpringMVC/servlet/Ray/visitevirtuelle
	@GetMapping("/visitevirtuelle")
	@ResponseBody
	public List<Ray> getRay() {
		List<Ray> list = Rr.retrieveAllRay();
		return list;
	}
	// http://localhost:8081/SpringMVC/servlet/Ray/remove-Ray/{rayon-id}
	@DeleteMapping("/remove-Ray/{rayon-id}")
	@ResponseBody
	public void removeRay(@PathVariable("rayon-id") long rayId) {
		Rr.deleteRay(rayId);
	}
	// http://localhost:8081/SpringMVC/servlet/Ray/modify-Rayon
	@PutMapping("/modify-Rayon")
	@ResponseBody
	public Ray modifyrayon(@RequestBody Ray ray) {
		return Rr.updateRay(ray);
	}
}
