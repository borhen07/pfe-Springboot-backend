package com.RessourseHumaine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RessourseHumaine.Entity.Reglage;

@Repository
public interface ReglageRepository extends JpaRepository<Reglage, Long>{

}
