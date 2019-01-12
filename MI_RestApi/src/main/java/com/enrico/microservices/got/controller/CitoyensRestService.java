package com.enrico.microservices.got.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import com.enrico.microservices.got.entity.Citoyens;
import com.enrico.microservices.got.repository.CitoyensRespository;
import com.enrico.microservices.got.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;







@RestController
@RequestMapping("c")
public class CitoyensRestService {

	@Autowired
	private CitoyensRespository citoyensRespository;
	 @GetMapping("/citoyens")
	    public List<Citoyens> getAllStudents() {
	    	return citoyensRespository.findAll();
	    }
	 @GetMapping("/citoyens/{cin}")
	    public Citoyens getCitoyenstByCIN(@PathVariable Long cin) {
	    	Optional<Citoyens> optStudent = citoyensRespository.findById(cin);
	    	if(optStudent.isPresent()) {
	    		return optStudent.get();
	    	}else {
	    		throw new NotFoundException("Student not found with id " + cin);
	    	}
	    }
	 @PostMapping("/citoyens")
	    public Citoyens createCitoyens(@Valid @RequestBody Citoyens citoyens) {
	        return citoyensRespository.save(citoyens);
	    }
	 
}
