package com.enrico.microservices.got.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.enrico.microservices.got.entity.Citoyens;
import com.enrico.microservices.got.repository.CitoyensRespository;
import com.enrico.microservices.got.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;






@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CitoyensRestService {

	@Autowired
	private CitoyensRespository citoyensRespository;
	
	@GetMapping("/citoyens")
    public List<Citoyens> getAllCitoyens() {
    	return citoyensRespository.findAll();
    }
	  @GetMapping("/citoyens/{numaff}")
	    public Citoyens getCitoyensByNUMAFF(@PathVariable Long numaff) {
	    	Optional<Citoyens> optStudent = citoyensRespository.findById(numaff);
	    	if(optStudent.isPresent()) {
	    		return optStudent.get();
	    	}else {
	    		throw new NotFoundException("Student not found with id " + numaff);
	    	}
	    }
	  @PostMapping("/citoyens")
	    public Citoyens createStudent(@Valid @RequestBody Citoyens citoyens) {
	        return citoyensRespository.save(citoyens);
	    }
	  @PutMapping("/citoyens/{numaff}")
	    public Citoyens updateCitoyens(@PathVariable Long numaff,
	                                   @Valid @RequestBody Citoyens citoyensUpdated) {
	        return citoyensRespository.findById(numaff)
	                .map(citoyens -> {
	                	citoyens.setNom(citoyensUpdated.getNom());
	                	citoyens.setPrenom(citoyensUpdated.getPrenom());
	                    return citoyensRespository.save(citoyens);
	                }).orElseThrow(() -> new NotFoundException("Student not found with id " + numaff));
	    }
	  @DeleteMapping("/citoyens/{numaff}")
	    public String deleteCitoyens(@PathVariable Long numaff) {
	        return citoyensRespository.findById(numaff)
	                .map(citoyen -> {
	                    citoyensRespository.delete(citoyen);
	                    return "Delete Successfully!";
	                }).orElseThrow(() -> new NotFoundException("Student not found with id " + numaff));
	    }  
}