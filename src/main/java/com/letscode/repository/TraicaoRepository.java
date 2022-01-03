package com.letscode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.letscode.entidade.Traicao;

@Repository
public interface TraicaoRepository extends JpaRepository<Traicao, Long>{
	
	 @Query("SELECT CASE WHEN COUNT(distinct t.delator.id) > 2 THEN true ELSE false END FROM Traicao t WHERE t.traidor.id = :traidorId")
	 Boolean isTraidor(@Param("traidorId") Long traidorId);
	    
	 Long countByTraidorId(Long id);

}
