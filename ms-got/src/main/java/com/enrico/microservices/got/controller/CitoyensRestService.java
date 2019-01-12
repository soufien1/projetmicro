package com.enrico.microservices.got.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enrico.microservices.got.entity.Citoyens;
import com.enrico.microservices.got.repository.CitoyensRespository;

@RestController
@CrossOrigin("*")
public class CitoyensRestService {
	
	@Autowired
private CitoyensRespository citoyensRespository;
	@RequestMapping(value="/citoyens",method=RequestMethod.GET)
public List<Citoyens> getCitoyens(){
	return citoyensRespository.findAll();
}
	@RequestMapping(value="/citoyens/{id}",method=RequestMethod.GET)
	public Citoyens getCitoyens(@PathVariable Long id) {
		return citoyensRespository.findById(id).get();
	}
	@RequestMapping(value="/citoyens",method=RequestMethod.POST)

	public Citoyens save(@RequestBody Citoyens c)
	{
	return citoyensRespository.save(c);
	}
	@RequestMapping(value="/citoyens/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id){
		citoyensRespository.deleteById(id);
		return true;
	}
	@RequestMapping(value="/citoyens/{id}",method=RequestMethod.PUT)
	public Citoyens save(@PathVariable Long id, @RequestBody Citoyens c){
		c.setId(id);
		return citoyensRespository.save(c);
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/chercherCitoyens",method=RequestMethod.GET)
	public Page<Citoyens> chercher(@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="5") int size)
	{
		return citoyensRespository.chercher("%"+mc+"%",new PageRequest(page, size));
	}
}
