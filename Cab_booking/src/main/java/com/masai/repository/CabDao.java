package com.masai.repository;

import java.util.List;
import java.util.Optional;

import com.masai.enums.CabType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.entity.Cab;
import com.masai.entity.Driver;

@Repository
public interface CabDao extends JpaRepository<Cab, Integer> {

	
	@Query("select distinct carType from Cab")
	public List<CabType> viewCarType();

	Optional<Cab> findByCabId(String cabId);
	void deleteByCabId(String cabId);
}
