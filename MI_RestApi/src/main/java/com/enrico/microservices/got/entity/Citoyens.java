package com.enrico.microservices.got.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "citoyens")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Citoyens implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long cin;
	private String nom;
	private String prenom;
	private String prenomPere;
	private String prenomGpere;
	private String nomMere;
	private String prenomMere;
	private String profession;
	@Temporal(TemporalType.DATE)
	private Date datenaissance;
	private String adressmail;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "citoyens")
    private B3 b3;
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
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
	public String getPrenomPere() {
		return prenomPere;
	}
	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}
	public String getPrenomGpere() {
		return prenomGpere;
	}
	public void setPrenomGpere(String prenomGpere) {
		this.prenomGpere = prenomGpere;
	}
	public String getNomMere() {
		return nomMere;
	}
	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}
	public String getPrenomMere() {
		return prenomMere;
	}
	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getAdressmail() {
		return adressmail;
	}
	public void setAdressmail(String adressmail) {
		this.adressmail = adressmail;
	}
	public Citoyens() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Citoyens(String nom, String prenom, String prenomPere, String prenomGpere, String nomMere, String prenomMere,
			String profession, Date datenaissance, String adressmail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.prenomPere = prenomPere;
		this.prenomGpere = prenomGpere;
		this.nomMere = nomMere;
		this.prenomMere = prenomMere;
		this.profession = profession;
		this.datenaissance = datenaissance;
		this.adressmail = adressmail;
	}
	
}
