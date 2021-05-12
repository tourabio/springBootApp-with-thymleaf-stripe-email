package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Client  extends User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // Clé primaire
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client",fetch = FetchType.EAGER)
	private Set<Reclamations> reclamations;
	
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	

	public Client(Long id, Set<Reclamations> reclamations) {
		super();
		this.id = id;
		this.reclamations = reclamations;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Set<Reclamations> getReclamations() {
		return reclamations;
	}



	public void setReclamations(Set<Reclamations> reclamations) {
		this.reclamations = reclamations;
	}



	
	
	
	
	
}
