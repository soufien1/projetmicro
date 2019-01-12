package com.enrico.microservices.got.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.enrico.microservices.got.entity.Citoyens;

public interface CitoyensRespository extends JpaRepository<Citoyens, Long> {

}