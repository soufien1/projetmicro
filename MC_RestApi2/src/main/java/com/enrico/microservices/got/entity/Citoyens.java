package com.enrico.microservices.got.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "citoyens")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Citoyens implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private Long numaff;
	private String nom;
	private String prenom;
	
	
	@OneToMany(mappedBy = "citoyens", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Remboursements> cnams;


	public Long getNumaff() {
		return numaff;
	}


	public void setNumaff(Long numaff) {
		this.numaff = numaff;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Set<Remboursements> getCnams() {
		return cnams;
	}


	public void setCnams(Set<Remboursements> cnams) {
		this.cnams = cnams;
	}


	public Citoyens() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Citoyens(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

}
