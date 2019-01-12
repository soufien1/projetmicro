package com.enrico.microservices.got.repository;

import java.util.List;

import com.enrico.microservices.got.entity.Remboursements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementsRespository extends JpaRepository<Remboursements, Long> {
  List<Remboursements> findByCitoyensNumaff(Long citoyensNumaff);
}