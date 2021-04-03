package com.RessourseHumaine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RessourseHumaine.Entity.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{

}
