package tn.esprit.spring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties.Whitelabel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.City;
import tn.esprit.spring.entities.CoordonneeCity;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMan;
import tn.esprit.spring.entities.MapsCoordonnees;
import tn.esprit.spring.entities.MoyenTransport;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.service.IDeliveryManService;
import tn.esprit.spring.service.IDeliveryService;
import tn.esprit.spring.service.ProductService;


@Controller

public class DeliveryController {

	@Autowired
	IDeliveryService iDeliveryService;
	
	@Autowired
	IDeliveryManService iDeliveryManService;
	
	@Autowired
	ProductService productService;
	
	

	@GetMapping("/deliveriesList")
	public String getDeliveries(Model model) {
		List<Delivery> list = iDeliveryService.getAllDeliveries();
		for (Delivery delivery : list) {
			delivery.setFrais(calculerFrais(delivery));
		}
		model.addAttribute("listDeliveries", list);
		return "listDeliveries";
	}
	
	@GetMapping("/showNewDeliveryForm")
	public String showNewDeliveryManForm(Model model){
		Delivery d = new Delivery();
		model.addAttribute("delivery",d);
		model.addAttribute("cities", City.values());
		model.addAttribute("moyenTransports", MoyenTransport.values());
		return "new_delivery";
	}
	
	
	@PostMapping("/newDelivery")
	public String newDeliveryMan(@ModelAttribute ("delivery") Delivery d) {
		MapsCoordonnees mp = new MapsCoordonnees();
		HashMap<City, CoordonneeCity>map = mp.getMap();
		CoordonneeCity cordonneee = map.get(d.getLieu());
		d.setLatitude(cordonneee.getLatitude());
		d.setLongitude(cordonneee.getLongitude());
		d.setDeliveryDate(new Date());
		List<DeliveryMan> men =iDeliveryManService.retrieveAllDeliveryMan();
		DeliveryMan bonMan = new DeliveryMan();
		boolean b=false;
		long id_nonDispo = 0;
		double distance=5000;
		while(!b){
		for (DeliveryMan deliveryMan : men) {
			double dist =  distance(d.getLatitude(), deliveryMan.getLatitude(), d.getLongitude(), deliveryMan.getLongitude(), 0, 0);
			dist/=1000;
			System.out.println("distance : "+dist);
			if(dist<distance && deliveryMan.getId()!=id_nonDispo){
				distance = dist;
				bonMan = deliveryMan;
			}
		}
		if(!bonMan.isDisponible())id_nonDispo=bonMan.getId();
		else
			b=true;
		}
		d.setDeliveryMans(bonMan);
		
		  iDeliveryService.addDelivery(d);
	     return "redirect:/servlet/deliveriesList";
	     
	     
	}

	
	@GetMapping("/showFormForUpdateDelivery/{delivery-id}")
	public String showFormForUpdate(@PathVariable("delivery-id") String id, Model model) {
		Delivery d =  iDeliveryService.getDelivery(id);
		model.addAttribute("delivery",d);
		model.addAttribute("cities", City.values());
		model.addAttribute("moyenTransports", MoyenTransport.values());
		return "new_delivery";
	}
	
	
	@GetMapping("/deleteDelivery/{delivery-id}")
	public String DeleteDeliveryRest(@PathVariable("delivery-id") String id) {
		iDeliveryService.deleteDelivery(id);
		System.out.println("delete Delivery N"+id);
	     return "redirect:/servlet/deliveriesList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/get-all-deliveries")
	@ResponseBody
	public List<Delivery> getDeliveries() {
		List<Delivery> list = iDeliveryService.getAllDeliveries();
		return list;
	}
	
	
	
	
	
	
	
	
	@DeleteMapping("/deleteDeliveryRest/{delivery-id}")
	@ResponseBody
	public String DeleteDelivery(@PathVariable("delivery-id") String id) {
		iDeliveryService.deleteDelivery(id);
		System.out.println("delete Delivery N"+id);
	     return "delete Delivery N"+id;
	}
	
	
	
	
	
	
	
	


	@GetMapping("/get-delivery/{delivery-id}")
	@ResponseBody
	public Delivery getDelivery(@PathVariable("delivery-id") String id) {
		return iDeliveryService.getDelivery(id);
	}

	@PostMapping("/add-delivery")
	@ResponseBody
	public Delivery addDelivery(@RequestBody Delivery d) {
		MapsCoordonnees mp = new MapsCoordonnees();
		HashMap<City, CoordonneeCity>map = mp.getMap();
		CoordonneeCity cordonneee = map.get(d.getLieu());
		d.setLatitude(cordonneee.getLatitude());
		d.setLongitude(cordonneee.getLongitude());
		d.setDeliveryDate(new Date());
		List<DeliveryMan> men =iDeliveryManService.retrieveAllDeliveryMan();
		DeliveryMan bonMan = new DeliveryMan();
		
		boolean b=false;
		long id_nonDispo = 0;
		double distance=5000;
		while(!b){
		for (DeliveryMan deliveryMan : men) {
			double dist =  distance(d.getLatitude(), deliveryMan.getLatitude(), d.getLongitude(), deliveryMan.getLongitude(), 0, 0);
			dist/=1000;
			System.out.println("distance : "+dist);
			if(dist<distance && deliveryMan.getId()!=id_nonDispo){
				distance = dist;
				bonMan = deliveryMan;
			}
		}
		if(!bonMan.isDisponible())id_nonDispo=bonMan.getId();
		else
			b=true;
		}
		d.setDeliveryMans(bonMan);
		
		Delivery delivery = iDeliveryService.addDelivery(d);
		return delivery;
	}

	@DeleteMapping("/remove-delivery/{delivery-id}")
	@ResponseBody
	public void removeDeliveryr(@PathVariable("delivery-id") String id) {
		iDeliveryService.deleteDelivery(id);
	}
	
	
	
	
	@GetMapping("/calculer-frais/{delivery-id}")
	@ResponseBody
	public float calculerFraisMeth(@PathVariable("delivery-id") String id) {
		Delivery d = iDeliveryService.getDelivery(id);
		return calculerFrais(d);
	}
	
	
	
	
	public static float calculerFrais(Delivery d){
		float sommePoids = 0;
		Set<Product> products = d.getProducts();
		for (Product product : products) {
			sommePoids+=product.getPoids();
		}
		float frais = 10;
		if(sommePoids>20) frais+=3;
		if(d.getMoyenTransport()==MoyenTransport.AVION)frais+=10;
		if(d.getMoyenTransport()==MoyenTransport.VOITURE)frais+=2;
		
		double distance =  distance(d.getLatitude(), d.getDeliveryMans().getLatitude(), d.getLongitude(), d.getDeliveryMans().getLongitude(), 0, 0);
		distance /=1000;
		if( distance>30)frais+=2;
		System.out.println("distance : "+distance);
		return frais;
	}
	
	
	
	
	
	
	
	/**
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	public static double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance);
	}
	
	
	
	
}
