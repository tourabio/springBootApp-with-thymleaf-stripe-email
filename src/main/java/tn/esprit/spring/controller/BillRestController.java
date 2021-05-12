package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

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

import tn.esprit.spring.entities.Facture;

import tn.esprit.spring.entities.Typepayment;
import tn.esprit.spring.service.BillService;

@RestController
@RequestMapping("/Bill")
public class BillRestController {
@Autowired
BillService Sr;
	// http://localhost:8081/SpringMVC/servlet/Bill/add-facture
				@PostMapping("/add-facture")
				@ResponseBody
				public Facture saveBill(@RequestBody Facture fact) {
				Facture facture = Sr.save(fact);
				return facture;
				}
				
				// URL : http://localhost:8081/SpringMVC/servlet/Bill/getAllBill
			    @GetMapping(value = "getAllBill")
			  
			    public List<Facture> getAllBill() {
					List<Facture> list = Sr.getAllBill();
					return list;
				}
			    
			    
			    // URL : http://localhost:8081/SpringMVC/servlet/Bill/delete-bill
				   @DeleteMapping(value = "delete-bill/{id}")
				   
					public void deleteBill(@PathVariable("id")long id){
					   Sr.deleteBill(id);
				   }
				   
					// http://localhost:8081/SpringMVC/servlet/Bill/modify-bill
					@PutMapping("/modify-bill")
					@ResponseBody
					public Facture modifyBill(@RequestBody Facture facture) {
					return Sr.updateBill(facture);}
					
					// URL : http://localhost:8081/SpringMVC/servlet/Bill/getBill_by_ID
					 @GetMapping(value = "getBill_by_ID/{id}")
					   
					 public Optional<Facture> getBill_by_ID(@PathVariable("id")Long id) {
							return Sr.getBill_by_ID(id);
					}
					 
					// URL : http://localhost:8081/SpringMVC/servlet/Bill/modify_type_bill
					   @PutMapping(value = "modify_type_bill/{id}/{Typepayment}")
					   @ResponseBody
						public void modify_type_bill(@PathVariable("Typepayment")Typepayment paymentType,@PathVariable("id")Long id){
						   Sr.modify_type_bill(paymentType, id);
							 
						}
					// URL : http://localhost:8081/SpringMVC/servlet/Bill/get_payment_type_by_id

					   @GetMapping(value = "get_payment_type_by_id/{id}")
					  

					   public String  get_payment_type_by_id(@PathVariable("id")Long id) {
						 return  Sr.get_payment_type_by_id(id);
}
					   //http://localhost:8081/SpringMVC/servlet/Bill/showPDF/{id}
						   @GetMapping("/showPDF/{id}")
						   public void billpdf (@PathVariable("id") Long id) {
							   
							 Sr.billpdf(id);
						   }
				
				
}			
						   
			    
