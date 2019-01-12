package com.enrico.microservices.got.controller;

import java.util.List;

import javax.validation.Valid;

import com.enrico.microservices.got.repository.B3Respository;
import com.enrico.microservices.got.entity.B3;
import com.enrico.microservices.got.repository.CitoyensRespository;
import com.enrico.microservices.got.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class B3RestService {
	
	@Autowired
	private B3Respository b3Respository;
    @Autowired
    private CitoyensRespository citoyensRespository;
    
    @GetMapping("/b3")
	public List<B3> getAllB3(){
		return b3Respository.findAll();
	}
    
    
    @GetMapping("/citoyens/{citoyensCin}")
    public B3 getB3ByCitoyensCin(@PathVariable Long citoyensCin) {
    	
        if(!citoyensRespository.existsById(citoyensCin)) {
            throw new NotFoundException("Citoyen not found!");
        }
    	
    	B3 b3 = b3Respository.findByCitoyensCin(citoyensCin);
    
    		return b3;
    	
    }
    @PostMapping("/citoyens/{citoyensCin}/b3")
    public B3 addB3(@PathVariable Long citoyensCin,
                            @Valid @RequestBody B3 b3) {
        return citoyensRespository.findById(citoyensCin)
                .map(citoyens -> {
                    b3.setCitoyens(citoyens);
                    return b3Respository.save(b3);
                }).orElseThrow(() -> new NotFoundException("Citoyens not found!"));
    }
    
}