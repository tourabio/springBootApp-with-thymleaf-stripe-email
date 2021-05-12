package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tn.esprit.spring.entities.Product;





@Entity
public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdStock;
	private String NameStock;
	private int QuantityStock;
	private String Fournisseur;
	private Date Entry_Date;
	
	@OneToMany(mappedBy="stock")
	private List<Product> produit;
	
	public int getIdStock() {
		return IdStock;
	}

	public void setIdStock(int idStock) {
		IdStock = idStock;
	}

	public String getNameStock() {
		return NameStock;
	}

	public void setNameStock(String nameStock) {
		NameStock = nameStock;
	}

	public int getQuantityStock() {
		return QuantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		QuantityStock = quantityStock;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFournisseur() {
		return Fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		Fournisseur = fournisseur;
	}

	public Date getEntry_Date() {
		return Entry_Date;
	}

	public void setEntry_Date(Date entry_Date) {
		Entry_Date = entry_Date;
	}
	
	
	
	

}