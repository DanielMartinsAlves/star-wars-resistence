package com.letscode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.entidade.Rebelde;

@Repository
public interface RebeldeRepository extends JpaRepository<Rebelde, Long> {

}
