package tn.esprit.spring.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.City;
import tn.esprit.spring.entities.CoordonneeCity;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMan;
import tn.esprit.spring.entities.MapsCoordonnees;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.service.IDeliveryManService;

@Controller
public class DeliveryManController {
	@Autowired
	IDeliveryManService ds;
	
	@GetMapping("/get-all-deliveryMan")
	public String getDeliveries(Model model) {
		List<DeliveryMan> list = ds.retrieveAllDeliveryMan();
		model.addAttribute("listDeliveryMan", list);
		return "listDeliveryMan";
	}
	
	
	@GetMapping("/showNewDeliveryManForm")
	public String showNewDeliveryManForm(Model model){
		// create a model attribute to bind data
		DeliveryMan dm = new DeliveryMan();
		model.addAttribute("deliveryMan",dm);
		model.addAttribute("cities", City.values());
		return "new_deliveryMan";
	}
	
	
	@PostMapping("/newDeliveryMan")
	public String newDeliveryMan(@ModelAttribute ("deliveryMan") DeliveryMan dm) {
		MapsCoordonnees mp = new MapsCoordonnees();
		HashMap<City, CoordonneeCity>map = mp.getMap();
		CoordonneeCity cordonneee = map.get(dm.getLieu());
		dm.setLatitude(cordonneee.getLatitude());
		dm.setLongitude(cordonneee.getLongitude());
		dm.setPrime(0);
		dm.setRole(Role.AGENT);
	     ds.addDeliveryMan(dm);
	     return "redirect:/servlet/get-all-deliveryMan";
	}
	
	
	@GetMapping("/showFormForUpdate/{deliveryMan-id}")
	public String showFormForUpdate(@PathVariable("deliveryMan-id") String id, Model model) {
		DeliveryMan dm =  ds.retrieveDeliveryMan(Long.parseLong(id)).get();
		model.addAttribute("deliveryMan",dm);
		model.addAttribute("cities", City.values());
		return "new_deliveryMan";
	}
	
	@GetMapping("/deleteDeliveryMan/{deliveryMan-id}")
	public String DeleteDeliveryMan(@PathVariable("deliveryMan-id") String id) {
		 ds.deleteDeliveryMan(Long.parseLong(id));
	     return "redirect:/servlet/get-all-deliveryMan";
	}
	
	
	
	
	
	
	
	@GetMapping("/get-deliveryMan/{deliveryMan-id}")
	@ResponseBody
	public DeliveryMan getDelivery(@PathVariable("deliveryMan-id") String id) {
		return ds.retrieveDeliveryMan(Long.parseLong(id)).get();
	}
	
	@PostMapping("/add-deliveryMan")
	@ResponseBody
	public void addDelivery(@RequestBody DeliveryMan d) {
		MapsCoordonnees mp = new MapsCoordonnees();
		HashMap<City, CoordonneeCity>map = mp.getMap();
		CoordonneeCity cordonneee = map.get(d.getLieu());
		d.setLatitude(cordonneee.getLatitude());
		d.setLongitude(cordonneee.getLongitude());
		d.setPrime(0);
		d.setRole(Role.AGENT);
	     ds.addDeliveryMan(d);
	}
	
	@PutMapping("/modify-deliveryMan")
	@ResponseBody
	public void modifyDelivery(@RequestBody DeliveryMan d) {
		MapsCoordonnees mp = new MapsCoordonnees();
		HashMap<City, CoordonneeCity>map = mp.getMap();
		CoordonneeCity cordonneee = map.get(d.getLieu());
		d.setLatitude(cordonneee.getLatitude());
		d.setLongitude(cordonneee.getLongitude());
		d.setPrime(0);
		d.setRole(Role.AGENT);
	     ds.updateDeliveryMan(d);
	}
	
	
	
	
	@DeleteMapping("/remove-deliveryMan/{deliveryMan-id}")
	@ResponseBody
	public void removeDeliveryMan(@PathVariable("deliveryMan-id") String id) {
		ds.deleteDeliveryMan(Long.parseLong(id));
	}
	
	

	
}
