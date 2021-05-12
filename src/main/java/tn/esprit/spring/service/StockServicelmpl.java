package tn.esprit.spring.service;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entities.Stock;

import tn.esprit.spring.repository.StockRepository;
@Service
public class StockServicelmpl implements IStockSerivce{
	@Autowired 
	StockRepository Sr;
	private static final Logger L =  LogManager.getLogger(StockServicelmpl.class);
	@Override
	public Stock save(Stock stock) {
		// TODO Auto-generated method stub
		return Sr.save(stock);
	}

	
	@Override
	public List<Stock> retrieveAllStock() {
		// TODO Auto-generated method stub
		List<Stock> stocks = (List<Stock>) Sr.findAll();
		for (Stock stock : stocks){
		L.info("stock +++: " + stock );}
		return stocks;
	}
	
	public int ajouterStock(Stock stock) {
		Sr.save(stock);
		return stock.getIdStock();
	}

	@Override
	public void deleteStock(long id) {
		// TODO Auto-generated method stub
Optional<Stock> stk = Sr.findById((int) id);
	    
	    if(stk.isPresent()) 
	        Sr.deleteById((int) id);}

	
	@Override
	public Stock updateStock(Stock stock) {
		// TODO Auto-generated method stub
		return Sr.save(stock);
	}



	@Override
	public List<Stock> OutOfStockDetector(){
		return(List<Stock>)Sr.OutOfStockDetector();
	}
	

	@Override
	public void stockpdf (Long id){
		try {
			Stock fr = Sr.getOne(id);
			
		String file_name="H:\\commande\\"+fr.getIdStock()+".pdf";
		Document document=new Document(PageSize.A4,15,15,45,30);
		
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			 document.open();
			 document.add(new Paragraph("  "));
			 document.add(new Paragraph("  "));
			 Image img=Image.getInstance("H:\\commande\\capture.PNG");
			 img.setAlignment(Element.ALIGN_LEFT);
			 img.setIndentationLeft(5);
			 img.setIndentationRight(5);
			 img.setSpacingAfter(1);
			 document.add(img); 

			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 document.add(new Paragraph("Telephone  :(+216) 98155255   "+"                                                             Adresse :Al Ghazela /Tunis "));
			 document.add(new Paragraph("Fax          :(+216) 75155255   "+"                                                                 Code Postal :2088  "));
			 document.add(new Paragraph("Email       :service@consomitounsi.tn  "));
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 document.add(new Paragraph(" "));
			 document.add(new Paragraph(" "));

		
			 Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
			 Date aujourdhui = fr.getEntry_Date();
			 document.add(new Paragraph("idStock   :"+fr.getIdStock()));
			 SimpleDateFormat formater = null;
			 formater = new SimpleDateFormat("dd-MM-yy");
		
			 Paragraph adresse=(new Paragraph("NomStock : "+fr. getNameStock()));
			 document.add(adresse);
			 
			 document.add(new Paragraph("Fournisseur :  "+fr.getFournisseur()));
			 document.add(new Paragraph("Date :  "+fr.getEntry_Date()));
			 document.add(new Paragraph("Quantité:  "+fr.getQuantityStock()));
			
			 Font mainFont = FontFactory.getFont("Cooper Black",35, BaseColor.BLACK);
			 
			 
			 
			 document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	

}
