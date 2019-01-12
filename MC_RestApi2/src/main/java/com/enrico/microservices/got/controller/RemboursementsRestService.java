package com.enrico.microservices.got.controller;

import java.util.List;

import javax.validation.Valid;

import com.enrico.microservices.got.repository.RemboursementsRespository;
import com.enrico.microservices.got.entity.Citoyens;
import com.enrico.microservices.got.entity.Remboursements;
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
@RequestMapping("/api")
public class RemboursementsRestService {

	@Autowired
	private RemboursementsRespository cnamRespository;
	
	
	@Autowired
	private CitoyensRespository citoyensRespository;
	
	@GetMapping("/citoyens/{citoyensNumaff}/")
    public List<Remboursements> getContactByCitoyensNumaff(@PathVariable Long citoyensNumaff) {
    	
        if(!citoyensRespository.existsById(citoyensNumaff)) {
            throw new NotFoundException("Student not found!");
        }
        return cnamRespository.findByCitoyensNumaff(citoyensNumaff);
	}
	@PostMapping("/citoyens/{citoyensNumaff}/cnam")
    public Remboursements addAssignment(@PathVariable Long citoyensNumaff,
                            @Valid @RequestBody Remboursements cnam) {
        return citoyensRespository.findById(citoyensNumaff)
                .map(citoyens -> {
                    cnam.setCitoyens(citoyens);
                    return cnamRespository.save(cnam);
                }).orElseThrow(() -> new NotFoundException("Citoyen not found!"));
    }
	
}
