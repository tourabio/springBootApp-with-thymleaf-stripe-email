package tn.esprit.spring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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


import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.City;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.CoordonneeCity;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMan;
import tn.esprit.spring.entities.Mail;
import tn.esprit.spring.entities.MapsCoordonnees;
import tn.esprit.spring.entities.MoyenTransport;
import tn.esprit.spring.entities.Reclamations;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.service.ClientService;
import tn.esprit.spring.service.IDeliveryService;
import tn.esprit.spring.service.ReclamationService;
import tn.esprit.spring.service.StripeService;
import tn.esprit.utils.Response;

@Controller
public class ReclamationController {

	@Autowired
	ReclamationService rs;

	@Autowired
	ClientService cs;
	
	@Autowired
	IDeliveryService ds;
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	
	
	private StripeService stripeService;


	@Value("${stripe.key.public}")
	private String API_PUBLIC_KEY;
	
	
	public ReclamationController(StripeService stripeService) {
		this.stripeService = stripeService;
	}
	
	
	
	@GetMapping("/reclamationsList")
	public String getReclamation(Model model) {
		List<Reclamations> list = rs.retrieveAllReclamations();
		model.addAttribute("listReclamation", list);
		return "listReclamation";
	}

	@GetMapping("/showNewReclamationForm/{delivery-id}")
	public String showNewReclamationForm(Model model, @PathVariable("delivery-id") String idDelivery ) {
		Reclamations m = new Reclamations();
		Delivery d = ds.getDelivery(idDelivery);
		m.setDelivery(d);
		model.addAttribute("reclamation", m);
		model.addAttribute("categories", Category.values());
		return "new_reclamation";
	}

	@PostMapping("/newReclamation/{client-id}/{delivery-id}")
	public String newDeliveryMan(@ModelAttribute("reclamation") Reclamations r,
			@PathVariable("client-id") String idClient,
			@PathVariable("delivery-id") String idDelivery) {
		
		Client c = cs.retrieveClient(Long.parseLong(idClient)).get();
		Delivery d = ds.getDelivery(idDelivery);
		r.setDelivery(d);
		r.setClient(c);
		r.setDateReclamation(new Date());
		rs.addReclamation(r);
		return "redirect:/servlet/deliveriesList";
	}

	
	
	@GetMapping("/showFormForUpdateReclamation/{reclamation-id}")
	public String showFormForUpdate(@PathVariable("reclamation-id") String id, Model model) {
		Reclamations r =  rs.retrieveReclamation(Long.parseLong(id)).get();
		model.addAttribute("reclamation",r);
		model.addAttribute("categories", Category.values());
		return "new_reclamation";
	}
	
	
	@GetMapping("/deleteReclamation/{reclamation-id}")
	public String DeleteReclamation(@PathVariable("reclamation-id") String id) {
		rs.deleteReclamation(Long.parseLong(id));
		System.out.println("delete Reclamation N"+id);
	     return "redirect:/servlet/reclamationsList";
	}
	
	
	@GetMapping("/charge/{reclamation-id}")
	public String chargePage(Model model, @PathVariable("reclamation-id") String id) {
		Reclamations r = rs.retrieveReclamation(Long.parseLong(id)).get();
		float frais = DeliveryController.calculerFrais(r.getDelivery());
		model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
		model.addAttribute("frais", (int)frais);
		model.addAttribute("email", r.getClient().getEmail());
		model.addAttribute("nom", r.getClient().getNom());
		model.addAttribute("prenom", r.getClient().getPrenom());
		model.addAttribute("id", r.getId());
		
		return "charge";
	}
	
	@PostMapping("/create-charge")
	public @ResponseBody Response createCharge(String email,String frais,String recId, String token) {
		if (token == null) {
			return new Response(false, "Stripe payment token is missing. please try again later.");
		}
		
		String chargeId = stripeService.createCharge(email, token, Integer.parseInt(frais)*100);

		if (chargeId == null) {
			return new Response(false, "An error accurred while trying to charge.");
		}

		// You may want to store charge id along with order information
		rs.deleteReclamation(Long.parseLong(recId));
		
		return new Response(true, "Success your charge id is " + chargeId);
	}
	
	
	
	@GetMapping("/showSendEmailForm/{reclamation-id}")
	public String showSendMailForm(Model model, @PathVariable("reclamation-id") String idReclamation ) {
		Reclamations r = rs.retrieveReclamation(Long.parseLong(idReclamation)).get();
		model.addAttribute("reclamation", r);
		Mail m = new Mail();
		m.setTo(r.getClient().getEmail());
		model.addAttribute("mail",m );
		return "send_mail";
	}
	
	
	
	@PostMapping("/sendMail/{reclamation-id}")
	public String newDeliveryMan(@ModelAttribute("mail") Mail m,@PathVariable("reclamation-id") String idReclamation ) {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(m.getTo());
	        msg.setSubject(m.getSubject());
	        msg.setText(m.getContent());
	        javaMailSender.send(msg);
		rs.deleteReclamation(Long.parseLong(idReclamation));
		return "redirect:/servlet/reclamationsList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/ajouterReclamation/{client-id}/{delivery-id}")
	@ResponseBody
	public Reclamations ajouterReclamation(@RequestBody Reclamations r, @PathVariable("client-id") String idClient, @PathVariable("delivery-id") String idDelivery) {
		Client c = cs.retrieveClient(Long.parseLong(idClient)).get();
		Delivery d = ds.getDelivery(idDelivery);
		r.setClient(c);
		r.setDelivery(d);
		r.setDateReclamation(new Date());
		rs.addReclamation(r);
		return r;
	}

	@GetMapping("/retrieve-all-reclamations")
	@ResponseBody
	public List<Reclamations> getReclamation() {
		List<Reclamations> list = rs.retrieveAllReclamations();
		return list;
	}

	@GetMapping("/retrieve-reclamation/{reclamation-id}")
	@ResponseBody
	public Optional<Reclamations> retrievereclamation(@PathVariable("reclamation-id") String reclamationId) {

		return rs.retrieveReclamation(Long.parseLong(reclamationId));
	}

	@DeleteMapping("/remove-reclamation/{reclamation-id}")
	@ResponseBody
	public void removereclamation(@PathVariable("reclamation-id") String id) {
		rs.deleteReclamation(Long.parseLong(id));
	}

	@PutMapping("/modify-reclamation/{client-id}")
	@ResponseBody
	public void modifyreclamation(@RequestBody Reclamations r, @PathVariable("client-id") String idClient) {
		Client c = cs.retrieveClient(Long.parseLong(idClient)).get();
		r.setClient(c);
		rs.updateReclamation(r);
	}

}
