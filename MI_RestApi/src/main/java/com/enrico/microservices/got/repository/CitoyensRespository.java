package com.enrico.microservices.got.repository;

import com.enrico.microservices.got.entity.Citoyens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitoyensRespository extends JpaRepository<Citoyens, Long> {

}