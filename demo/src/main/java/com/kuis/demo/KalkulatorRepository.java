package com.kuis.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KalkulatorRepository extends JpaRepository<Kalkulator, Long> {
}