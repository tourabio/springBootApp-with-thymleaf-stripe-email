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
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.service.IStockSerivce;
import tn.esprit.spring.service.RayService;

@RestController
@RequestMapping("/Stock")
public class StockRestController {
	@Autowired
	IStockSerivce iStockService;

	
	// http://localhost:8081/SpringMVC/servlet/Stock/CommanderStock
	@PostMapping("/CommanderStock")
	@ResponseBody
	public Stock ajouterStock(@RequestBody Stock stock) {
		iStockService.ajouterStock(stock);
		return stock;
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/Stock/deleteStock/{IDSTOCK}
	 @DeleteMapping("/deleteStock/{IdStock}") 
	 @ResponseBody
	public void deleteStock(@PathVariable("IdStock")int IdStock){
		 iStockService.deleteStock(IdStock);
	 }

	

	
	// http://localhost:8081/SpringMVC/servlet/Stock/retrieve-all-Stock
				@GetMapping("/retrieve-all-Stock")
				@ResponseBody
				public List<Stock> getStock() {
				List<Stock> list = iStockService.retrieveAllStock();
				return list;
				}
				// http://localhost:8081/SpringMVC/servlet/Stock/updatestock
				@PutMapping("/updatestock")
				@ResponseBody
				public Stock modifystock(@RequestBody Stock stock) {
				return iStockService.updateStock(stock);
				}
				// http://localhost:8081/SpringMVC/servlet/Stock/OutOfStockDetector
				 @GetMapping(value = "OutOfStockDetector") 
				 public List<Stock> OutOfStockDetector(){
			  return iStockService.OutOfStockDetector();
				 }
				 //http://localhost:8081/SpringMVC/servlet/Stock/showPDF/{id}
				   @GetMapping("/showPDF/{id}")
				   public void stockpdf (@PathVariable("id") Long id) {
					   
					 iStockService.stockpdf(id);
				   }
		
}