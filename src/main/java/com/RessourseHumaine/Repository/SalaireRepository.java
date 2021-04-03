package com.RessourseHumaine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.RessourseHumaine.Entity.Salaire;

@Repository
public interface SalaireRepository  extends JpaRepository<Salaire, Long>{

}
