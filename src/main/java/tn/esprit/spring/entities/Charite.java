package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Charite implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String typecharite;
	private float montantpaye;
	@ManyToOne
	@JsonIgnore
    private Event event ;
	//@ManyToOne
	//@JsonIgnore
	//private User iduser;
	
	public long getId() {
		return id;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTypecharite() {
		return typecharite;
	}
	public void setTypecharite(String typecharite) {
		this.typecharite = typecharite;
	}
	public float getMontantpaye() {
		return montantpaye;
	}
	public void setMontantpaye(float montantpaye) {
		this.montantpaye = montantpaye;
	}
	public Charite() {
		
	}
}
