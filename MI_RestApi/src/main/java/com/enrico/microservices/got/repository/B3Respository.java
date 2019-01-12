package com.enrico.microservices.got.repository;

import com.enrico.microservices.got.entity.B3;
import org.springframework.data.jpa.repository.JpaRepository;

public interface B3Respository extends JpaRepository<B3, Long> {
  B3 findByCitoyensCin(Long citoyensCin);
}