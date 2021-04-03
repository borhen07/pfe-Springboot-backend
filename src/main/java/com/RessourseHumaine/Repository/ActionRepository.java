package com.RessourseHumaine.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.RessourseHumaine.Entity.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long>{

	@Modifying
	@Transactional
	@Query("update Action e set e.dateDebut = :dateDebut ,e.dateFin = :dateFin,e.typeAction = :typeAction,e.statutAction = :statutAction,e.subjectif = :subjectif  where e.id = :actionId")
	public void updateActionJPQL(@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin,@Param("typeAction") String typeAction,@Param("statutAction") String statutAction,@Param("subjectif") String subjectif,@Param("actionId") long actionId);
	
	
}
