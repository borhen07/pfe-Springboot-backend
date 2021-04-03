package com.RessourseHumaine.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RessourseHumaine.Entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	Utilisateur findByEmail(String email);
	public Optional<Utilisateur> findUserByEmail(String email);
	Boolean existsByEmail(String email);
	
	@Query(
			value = "SELECT *  FROM t_user u  WHERE u.id_account = :accountId",
			nativeQuery = true)
	List<Utilisateur> findAllUsers(@Param("accountId") Long accountId);

}
