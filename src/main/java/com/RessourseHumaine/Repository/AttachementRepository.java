package com.RessourseHumaine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RessourseHumaine.Entity.Attachement;

@Repository
public interface AttachementRepository  extends JpaRepository<Attachement, Long>{

}
