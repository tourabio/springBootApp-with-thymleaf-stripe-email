package tn.esprit.spring.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
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


import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Typepayment;
import tn.esprit.spring.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	BillRepository br;
	private static final Logger L =  LogManager.getLogger(BillServiceImpl.class);
	@Override
	public Facture save(Facture facture) {
		// TODO Auto-generated method stub
		return br.save(facture);
	}
	@Override
	public List<Facture> getAllBill() {
		List<Facture> factures = (List<Facture>) br.findAll();
		for (Facture facture : factures){
		L.info("facture +++: " + factures);}
		return factures;

	}
	@Override
	public void deleteBill(Long id) {
		
		Optional<Facture> facture = br.findById(id);
	    
	    if(facture.isPresent()) 
	    {
	       br.deleteById(id);
	       }	}
@Override 
public Facture updateBill(Facture fr){
			
			return br.save(fr);
		}
@Override
public Optional<Facture> getBill_by_ID(Long id) {
	return br.findById(id);
}
/*
@Override
public List<Facture> getBill_by_Type(Typepayment paymentType){
   return br.findByTypepayment(paymentType);
}
}*/

@Override
public void modify_type_bill(Typepayment paymentType, Long id) {
	Facture fr =br.findById(id).get();
	fr.setTypepayment(paymentType);
		br.save(fr);
	}

@Override
public String  get_payment_type_by_id(Long id) {
	
	 return br.get_payment_type_by_id(id);
}
@Override
public void billpdf (Long id){
	try {
		Facture fr = br.getOne(id);
		
	String file_name="E:\\pdf\\Pipdf"+fr.getId()+".pdf";
	Document document=new Document(PageSize.A4,15,15,45,30);
	
		PdfWriter.getInstance(document, new FileOutputStream(file_name));
		 document.open();
		 document.add(new Paragraph("  "));
		 document.add(new Paragraph("  "));
		 Image img=Image.getInstance("E:\\pdf\\capture.PNG");
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
		 Date aujourdhui = fr.getDatefacture();
		 document.add(new Paragraph("idFacture   :"+fr.getId()));
		 SimpleDateFormat formater = null;
		 formater = new SimpleDateFormat("dd-MM-yy");
	
		 Paragraph adresse=new Paragraph("Adresse : "+fr.getAdresse());
		 document.add(adresse);
		 
		 document.add(new Paragraph("PaymentType :  "+fr.getTypepayment()));
		 document.add(new Paragraph("Date Payment:  "+fr.getDatefacture()));
		 document.add(new Paragraph("Amount:  "+fr.getAmount()));
		
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
 
	}}

	
	

