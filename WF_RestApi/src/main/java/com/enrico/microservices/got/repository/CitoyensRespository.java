package com.enrico.microservices.got.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enrico.microservices.got.entity.Citoyens;

public interface CitoyensRespository extends JpaRepository<Citoyens, Long> {
	@Query ("select c from Citoyens c where c.nom like :x")
	public Page<Citoyens> chercher(@Param("x")String mc, Pageable pageable);
}