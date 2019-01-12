package com.enrico.microservices.got.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Citoyens implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
private Long id;
private String nom;
private String prenom;
@Temporal(TemporalType.DATE)
private Date datenaissance;
private String cin;
private String revenuannuel;
private String adressmail;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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
public Date getDatenaissance() {
	return datenaissance;
}
public void setDatenaissance(Date datenaissance) {
	this.datenaissance = datenaissance;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getRevenuannuel() {
	return revenuannuel;
}
public void setRevenuannuel(String revenuannuel) {
	this.revenuannuel = revenuannuel;
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
public Citoyens(String nom, String prenom, Date datenaissance, String cin, String revenuannuel, String adressmail) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.datenaissance = datenaissance;
	this.cin = cin;
	this.revenuannuel = revenuannuel;
	this.adressmail = adressmail;
}


}
