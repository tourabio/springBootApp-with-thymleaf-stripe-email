package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publicite implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	//@Temporal(TemporalType.TIMESTAMP)
	private Date datedebut;
	private Date datefin;
	private String image;
	@OneToOne(fetch=FetchType.EAGER,mappedBy="publicite") 
	@JsonIgnore
	private Event events;
	
	
	public Event getEvents() {
		return events;
	}
	



	public void setEvents(Event events) {
		this.events = events;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Date getDatedebut() {
		return datedebut;
	}



	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}



	public Date getDatefin() {
		return datefin;
	}



	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Publicite() {
		
	}
}
