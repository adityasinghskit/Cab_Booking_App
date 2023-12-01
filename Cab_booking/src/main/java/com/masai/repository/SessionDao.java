package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.CurrentUserSession;

@Repository
public interface SessionDao extends JpaRepository<CurrentUserSession, Integer>{
	
	Optional<CurrentUserSession> findById(String userId);
	
	Optional<CurrentUserSession> findByUuid(String uuid);
}
