package com.RessourseHumaine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RessourseHumaine.Entity.Calendrier;

@Repository
public interface CalendrierRepository  extends JpaRepository<Calendrier, Long>{

}
