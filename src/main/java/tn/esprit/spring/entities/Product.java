package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // Clé primaire
	
	private String picture;
	private String name;
	private String description;
	private int quantite;
	private float price;
	private float poids;
	

	
	
	
	
	@ManyToOne
	Stock stock;
	
	@ManyToOne
	Delivery delivery;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String picture, String name, String description, int quantite, float price, Stock stock) {
		super();
		this.id = id;
		this.picture = picture;
		this.name = name;
		this.description = description;
		this.quantite = quantite;
		this.price = price;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	
	
	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", picture=" + picture + ", name=" + name + ", description=" + description
				+ ", quantite=" + quantite + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
	
	
	
	
	
	
}
