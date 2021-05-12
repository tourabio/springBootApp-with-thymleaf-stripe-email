package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Entity
public class Reclamations implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateReclamation;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@ManyToOne
	Client client;
	
	
	@OneToOne
	Delivery delivery;
	
	public Reclamations() {
		// TODO Auto-generated constructor stub
	}

	

	







	public Reclamations(Long id, String title, String content, Date dateReclamation, Category category, Client client) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.dateReclamation = dateReclamation;
		this.category = category;
		this.client = client;
	}











	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	



	public User getClient() {
		return client;
	}






	public Date getDateReclamation() {
		return dateReclamation;
	}











	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}











	public void setClient(Client client) {
		this.client = client;
	}











	public Delivery getDelivery() {
		return delivery;
	}











	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}











	@Override
	public String toString() {
		return "Reclamations [id=" + id + ", title=" + title + ", content=" + content + ", dateReclamation="
				+ dateReclamation + ", category=" + category + ", client=" + client + "]";
	}






	
	
	
	
}
