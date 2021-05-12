package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entities.Stock;

public interface IStockSerivce {
	public Stock save(Stock ray);
	List<Stock> retrieveAllStock();
	public int ajouterStock(Stock stock);
	public void deleteStock(long id);
	public List<Stock> OutOfStockDetector();
	
	//void deleteStock(long id);
	Stock updateStock(Stock stock);
	void stockpdf(Long id);

	

}