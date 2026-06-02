package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Locatie;

public interface LocatieRepository extends JpaRepository<Locatie, Long> {

}
